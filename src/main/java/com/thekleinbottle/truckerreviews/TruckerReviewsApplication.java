package com.thekleinbottle.truckerreviews;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.truckerreviews.domain.*;

@SpringBootApplication
public class TruckerReviewsApplication implements CommandLineRunner {
	private final DepartmentRepository deptRepo;
	private final EmployeeRepository emplRepo;
	private final PurchaseItemRepository itemRepo;
	private final PurchaseOrderRepository purcRepo;
	private final TankRepository tankRepo;
	private final AppUserRepository userRepo;

	public TruckerReviewsApplication(DepartmentRepository deptRepo, EmployeeRepository emplRepo, PurchaseItemRepository itemRepo, 
			PurchaseOrderRepository purcRepo, TankRepository tankRepo, AppUserRepository userRepo) {
		this.deptRepo = deptRepo;
		this.emplRepo = emplRepo;
		this.itemRepo = itemRepo;
		this.purcRepo = purcRepo;
		this.tankRepo = tankRepo;
		this.userRepo = userRepo;
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

		Employee e1 = new Employee("Bill", "Robertson", 24, new Date(), tw);
		Employee e2 = new Employee("Morgan", "Salablanca", 22, new Date(), tw);
		Employee e3 = new Employee("Walter", "White", 25, new Date(), cs);
		Employee e4 = new Employee("Jen", "Smith", 23, new Date(), cs);
		Employee e5 = new Employee("Sam", "Cooke", 24, new Date(), fc);
		Employee e6 = new Employee("Sarah", "Henderson", 25, new Date(), fc);
		Employee e7 = new Employee("Brian", "Colley", 23, new Date(), fo);
		Employee e8 = new Employee("Mike", "Smith", 26, new Date(), fo);
		Employee e9 = new Employee("Ryan", "Bosley", 22, new Date(), sd);
		Employee e0 = new Employee("Tim", "Berker", 21, new Date(), sd);
		emplRepo.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e0));

		PurchaseOrder po0 = new PurchaseOrder("186593", tw);
		PurchaseOrder po1 = new PurchaseOrder("31567", cs);
		PurchaseOrder po2 = new PurchaseOrder("8742", cs);
		PurchaseOrder po3 = new PurchaseOrder("5928", fc);
		purcRepo.saveAll(Arrays.asList(po0, po1, po2, po3));
		itemRepo.save(new PurchaseItem(po0, "Soap", 3,"50gal"));
		itemRepo.save(new PurchaseItem(po0, "hot wax", 8, "20gal"));


		tankRepo.save(new Tank("JR001", 16328, 22000));
		tankRepo.save(new Tank("BG864", 26312, 28000));
		tankRepo.save(new Tank("LR51", 8714, 24000));
		tankRepo.save(new Tank("GFG62", 1262, 22000));

		userRepo.save(new AppUser("admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}

}
