package hr.tvz.martincevic.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

@Controller
public class TestController
{
	//@Autowired
	//HibernatePredavanjeRepository repo;
	
	@Autowired
	PredavanjeRepository predavanjeRepository;
	
	
	@GetMapping("/testFunction")
	public String testFunction()
	{
		Iterable<Predavanje> predavanja = predavanjeRepository.findByTema("temica");
		
		predavanja.iterator();
		
		return "testFunction";
	}

	/*
	 * @ModelAttribute("nekaj") public Integer setNekaj() { return new Integer(5); }
	 */
}
