package com.thekleinbottle.truckerreviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.truckerreviews.domain.*;

@SpringBootApplication
public class TruckerReviewsApplication implements CommandLineRunner {
	private final DepartmentRepository deptRepo;
	private final EmployeeRepository emplRepo;
	private final ItemRepository itemRepo;
	private final PurchaseOrderRepository purcRepo;

	public TruckerReviewsApplication(DepartmentRepository deptRepo, EmployeeRepository emplRepo, 
			ItemRepository itemRepo, PurchaseOrderRepository purcRepo) {
		this.deptRepo = deptRepo;
		this.emplRepo = emplRepo;
		this.itemRepo = itemRepo;
		this.purcRepo = purcRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(TruckerReviewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department tw = new Department("Truckwash");
		deptRepo.save(tw);

		emplRepo.save(new Employee("Bill", "Robertson", tw));

		PurchaseOrder po = new PurchaseOrder("186593", tw);
		itemRepo.save(new Item(po, "Soap", 3,"50gal"));
		itemRepo.save(new Item(po, "hot wax", 8, "20gal"));
	}

}
