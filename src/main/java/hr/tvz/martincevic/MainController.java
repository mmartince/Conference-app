package hr.tvz.martincevic;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;
import hr.tvz.martincevic.enums.PozicijaPredavaca;
import hr.tvz.martincevic.enums.SearchTypes;
import hr.tvz.martincevic.enums.VrstaPredavanja;
import hr.tvz.martincevic.jpa.JPAParser;
import hr.tvz.martincevic.wrappers.ThString;
import hr.tvz.martincevic.wrappers.ThTypes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({ "vrsta", "pozicija", "listaPredavanja", "objavljeno", "types"/* , "nekaj" */ })
public class MainController
{	

	//@Autowired
	//HibernatePredavanjeRepository repo;
	
	@Autowired
	PredavanjeRepository predavanjeRepository;

	@GetMapping("/")
	public String greeting(Model model)
	{
		//JPAParser jpaParser = new JPAParser(predavanjeRepository);
		//jpaParser.findBySelectedParam("sAdr");
		return "greeting";
	}

	@GetMapping("/predavanja/novoPredavanje")
	public String novoPredavanje(Model model)
	{
		model.addAttribute("predavanje", new Predavanje());
		model.addAttribute("vrsta", VrstaPredavanja.values());
		model.addAttribute("pozicija", PozicijaPredavaca.values());
		return "novoPredavanje";
	}

	@PostMapping("/predavanja/novoPredavanje")
	public String processForm(@Valid Predavanje predavanje, Errors errors, Model model,
							  @SessionAttribute("listaPredavanja") Vector<Predavanje> listaPredavanja)
	{
		log.info("Procesiram predavanje: " + predavanje + "...");
		if (errors.hasErrors())
		{
			log.info("Predavanje ima grešaka. Prekida seslanje.");
			return "novoPredavanje";
		}
		if(predavanje.getObjavljeno() == null) predavanje.setObjavljeno(false);
		predavanje.getPredavac().setDatumUpisa(new Date());
		predavanje.setDatumUpisa(new Date());
		
		predavanje.getPredavac().parseName();
		
		model.addAttribute("predavanje", predavanje);
		
		listaPredavanja.addElement(predavanje);


		//repo.save(predavanje);
		predavanjeRepository.save(predavanje);
		

		log.info("Procesiranje uspješno.");

		return "prihvacenoPredavanje";
	}

	@GetMapping("/predavanja/resetirajBrojac")
	public String resetBrojac(SessionStatus sessionStatus)
	{
		sessionStatus.setComplete();
		log.info("Session resetiran.");
		return "redirect:/predavanja/novoPredavanje";
	}

	@GetMapping("/predavanja/list")
	public String prikaziSvaPredavanja(Model model)
	{
		model.addAttribute("datas", predavanjeRepository.findAll());
	    return "list";
	}
	
	@GetMapping("/predavanja/search")
	public String search(Model model)
	{
		model.addAttribute("predavanje", new Predavanje());
		model.addAttribute("typesObj", new ThTypes());
		model.addAttribute("searchValue", new ThString());
		model.addAttribute("types", SearchTypes.values());
		return "searchStuff";
	}
	
	@PostMapping("/predavanja/search")
	public String search(Predavanje predavanje, ThTypes typesObj, ThString searchValue, Model model)
	{
		//List<Predavanje> dt = predavanjeRepository.findByTema(predavanje.getTema());
		JPAParser parser = new JPAParser(predavanjeRepository);
		List<Predavanje> pronadjenaPredavanja = parser.parseAndReturn(typesObj, searchValue);
		model.addAttribute("datas", pronadjenaPredavanja);
		model.addAttribute("searchValue", new ThString());
		//model.addAttribute("typesObj", typesObj);
		//model.addAttribute("types", SearchTypes.values());
		return "searchStuff";
	}
	
	@ModelAttribute("listaPredavanja")
	public List<Predavanje> setListaPredavanja()
	{
		log.info("Inicializacija variabli...");
		return new Vector<Predavanje>();
	}
	/*@ModelAttribute("types")
	public SearchTypes[] setTypes()
	{
		log.info("Initializing types...");
		return SearchTypes.values();
	}*/
}