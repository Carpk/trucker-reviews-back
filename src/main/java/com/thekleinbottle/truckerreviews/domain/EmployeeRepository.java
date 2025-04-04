package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  List<Employee> findByFirstname(String firstname);

  List<Employee> findByLastname(String lastname);
}
