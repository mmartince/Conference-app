package hr.tvz.martincevic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

@RestController
@RequestMapping(path = "/api/predavanje", produces = "application/json")
@CrossOrigin(origins = "*")
public class PredavanjeRestController
{
	@Autowired
	PredavanjeRepository predavanjeRepository;

	@GetMapping
	public List<Predavanje> findAll()
	{
		return predavanjeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Predavanje> findOne(@PathVariable String id)
	{
		Predavanje predavanje = predavanjeRepository.findById(Long.parseLong(id, 10)).get();
		if (predavanje != null)
		{
			return new ResponseEntity<>(predavanje, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = "application/json")
	public Predavanje save(@RequestBody Predavanje predavanje)
	{
		return predavanjeRepository.save(predavanje);
	}

	@PutMapping("/{id}")
	public Predavanje update(@RequestBody Predavanje predavanje)
	{
		//SHOULD BE UPDATE, NOT SAVE
		return predavanjeRepository.save(predavanje);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id)
	{
		predavanjeRepository.deleteById(Long.parseLong(id, 10));
	}
}
