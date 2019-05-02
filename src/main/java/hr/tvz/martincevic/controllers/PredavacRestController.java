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

import hr.tvz.martincevic.entities.Predavac;
import hr.tvz.martincevic.entities.repositories.PredavacRepository;

@RestController
@RequestMapping(path = "/api/predavac", produces = "application/json")
@CrossOrigin(origins = "*")
public class PredavacRestController
{
	@Autowired
	PredavacRepository predavacRepository;

	@GetMapping
	public List<Predavac> findAll()
	{
		return predavacRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Predavac> findOne(@PathVariable String id)
	{
		Predavac predavac = predavacRepository.findById(Long.parseLong(id, 10)).get();
		if (predavac != null)
		{
			return new ResponseEntity<>(predavac, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = "application/json")
	public Predavac save(@RequestBody Predavac predavac)
	{
		return predavacRepository.save(predavac);
	}

	@PutMapping("/{id}")
	public Predavac update(@RequestBody Predavac predavac)
	{
		//SHOULD BE UPDATE, NOT SAVE
		return predavacRepository.save(predavac);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id)
	{
		predavacRepository.deleteById(Long.parseLong(id, 10));
	}
}
