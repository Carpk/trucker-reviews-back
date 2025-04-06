package com.thekleinbottle.truckerreviews;

import java.util.Arrays;

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
		Department cs = new Department("Convenience Store");
		Department fc = new Department("Fueling Center");
		Department fo = new Department("Food Court");
		Department sd = new Department("Shipping Department");
		deptRepo.saveAll(Arrays.asList(tw, cs, fc, fo, sd));

		Employee e1 = new Employee("Bill", "Robertson", tw);
		Employee e2 = new Employee("Morgan", "Salablanca", tw);
		Employee e3 = new Employee("Walter", "White", cs);
		Employee e4 = new Employee("Jen", "Smith", cs);
		Employee e5 = new Employee("Sam", "Cooke", fc);
		Employee e6 = new Employee("Sarah", "Henderson", fc);
		Employee e7 = new Employee("Brian", "Colley", fo);
		Employee e8 = new Employee("Mike", "Smith", fo);
		Employee e9 = new Employee("Ryan", "Bosley", sd);
		Employee e0 = new Employee("Tim", "Berker", sd);
		emplRepo.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e0));

		PurchaseOrder po0 = new PurchaseOrder("186593", tw);
		PurchaseOrder po1 = new PurchaseOrder("31567", cs);
		PurchaseOrder po2 = new PurchaseOrder("8742", cs);
		PurchaseOrder po3 = new PurchaseOrder("5928", fc);
		purcRepo.saveAll(Arrays.asList(po0, po1, po2, po3));
		itemRepo.save(new Item(po0, "Soap", 3,"50gal"));
		itemRepo.save(new Item(po0, "hot wax", 8, "20gal"));
	}

}
