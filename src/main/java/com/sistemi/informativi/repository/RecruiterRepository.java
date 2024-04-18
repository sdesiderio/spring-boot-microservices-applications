package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.informativi.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter,String>{
	
	/*
	 * Spring Data JPA traduce la firma del metodo in una query JPQL:
	 * select r from recruiter r where r.experienceYears > experienceYears
	 */
     public List<Recruiter> findByExperienceYearsGreaterThan(int experienceYears);
     
     // saveAll

}
