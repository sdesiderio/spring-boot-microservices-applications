package com.sistemi.informativi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.entity.Recruiter;
import com.sistemi.informativi.repository.RecruiterRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/rest/api/recruiters")
public class RecruiterController {
	
	private RecruiterRepository recruiterRepository;

	public RecruiterController(RecruiterRepository recruiterRepository) {
		
		this.recruiterRepository = recruiterRepository;
	}
	
	@GetMapping
	public List<Recruiter> findAllRecruiters(){
		
		return recruiterRepository.findAll();
		
	}
	
	@GetMapping("/greater-than/{experienceYears}")
	public List<Recruiter> findAllRecruitersByExperienceYearsGreaterThan(@PathVariable("experienceYears") int experienceYears){
		
		return recruiterRepository.findByExperienceYearsGreaterThan(experienceYears);
		
	}
	
	/*
	 * Questo metodo riceverà in input un JSON contenente una lista di recruiters
	 * successivamente convertirà il JSON in una Lista Java contenente i recruiters
	 * inviati dal consumer; successibamente ancora invocherà il metodo saveAll fornito
	 * nativamente da Spring Data Jpa per eseguire inserimento multiplo di tutti i
	 * recruiters sul database
	 */
	@PostMapping("/all")
	public List<Recruiter> saveRecruiters(@RequestBody List<Recruiter> recruiters){
		
		return recruiterRepository.saveAll(recruiters);
	}
	
	@GetMapping("/hateoas/greater-than/{experienceYears}")
	public CollectionModel<Recruiter> findAcademyByCodeNumberHATEOAS(@PathVariable("experienceYears") int experienceYears) throws Exception {

	    List<Recruiter> recruiters = recruiterRepository.findByExperienceYearsGreaterThan(experienceYears);

	    /*
	     * CollectionModel è una API facente parte dello starter HATEOAS
	     * che consente di inizializzare una variabile per poi successivamente
	     * fare l'attach di uno o più link al JSON di risposta
	     */
	    CollectionModel<Recruiter> resource = CollectionModel.of(recruiters);

	    /*
	     * Costruizione di un link che rappresenta la url di esposizione di una
	     * determinata operazione (nel nostro caso ricerca di tutti i recruiters)
	     */
	    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllRecruiters());

	    // etichetta assegnata all'interno del JSON
	    resource.add(linkTo.withRel("all-recruiters"));


	    return resource;

	}
	

}
