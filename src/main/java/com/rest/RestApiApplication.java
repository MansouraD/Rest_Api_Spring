package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Autowired
	private RestRepository pharmacieRepository;
	
	@GetMapping(value = "/pharmacies")
	public List<Pharmacie> getPharmacies() {
		
		return pharmacieRepository.findAll();
	}
	
	@GetMapping(value = "/pharmacies/{id}")
	public Pharmacie getPharmacie(@PathVariable Integer id) {
		
		return pharmacieRepository.getOne(id);
	}
	
	
	@PostMapping(value = "/pharmacies")
	public Pharmacie addParmacie( @RequestBody Pharmacie ph) {
		
		return pharmacieRepository.save(ph);
	}
	
	@PutMapping(value = "/pharmacies/{id}")
	public Pharmacie updatePharmacies(@PathVariable Integer id, @RequestBody Pharmacie ph) {
		Pharmacie phar = new Pharmacie();
		phar = ph;
		phar.setId(id);
		return pharmacieRepository.save(phar);
	}
	
	@DeleteMapping(value = "/pharmacies/{id}")
	public void deletePharmacie(@PathVariable Integer id) {
		 pharmacieRepository.deleteById(id);;
	}
	
	@GetMapping(value = "/findPharmacie")
	public List<Pharmacie> getPharmacieByNom(
				@RequestParam(name = "nom",defaultValue = "") String nom) {
		
		return pharmacieRepository.getPharmacieByNom("%"+nom+"%");
	}
	
}
