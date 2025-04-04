package com.thekleinbottle.truckerreviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.truckerreviews.domain.*;

@SpringBootApplication
public class TruckerReviewsApplication implements CommandLineRunner {
	private final DepartmentRepository deptRepo;

	public TruckerReviewsApplication(DepartmentRepository deptRepo) {
		this.deptRepo = deptRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(TruckerReviewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deptRepo.save(new Department("Truckwash"));


	}

}
