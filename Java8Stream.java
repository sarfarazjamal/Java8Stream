package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
	public static void main(String[] args) {

		Department account = new Department("Account", 75);
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("ITTechnology", 150);

		List<Employee> employeeList = Arrays.asList(
				new Employee("David", 32, "Matara", account),
				new Employee("Brayan", 25, "Galle", hr), new Employee("JoAnne", 45, "Negombo", ops),
				new Employee("Jake", 65, "Galle", hr), new Employee("Brent", 55, "Matara", hr),
				new Employee("Allice", 23, "Matara", ops), new Employee("Austin", 30, "Negombo", tech),
				new Employee("Gerry", 29, "Matara", tech), new Employee("Scote", 20, "Negombo", ops),
				new Employee("Branden", 32, "Matara", account), new Employee("Iflias", 31, "Galle", hr));
		// Find all employees who lives in ‘Matara’ city, sort them by their name and
		// print the names of employees.

		List<Employee> employeeCityFilteredList = employeeList.stream().filter(emp -> emp.getCity().equals("Matara")).collect(Collectors.toList());
		List<Employee> filterEmployeeList = new ArrayList<>();
		List<Department> distinctEmployeeList = new ArrayList<>();
		List<String> empNameList = new ArrayList<>();
		for (Employee employee : employeeCityFilteredList) {
			System.out.println(employee.getCity() + "<--->" + employee.getName());
		}

		employeeList.stream().filter(empIterationIndex -> empIterationIndex.getCity().equals("Matara"))
				.sorted(Comparator.comparing(Employee::getName))
				.forEach(filteredvalue -> filterEmployeeList.add(filteredvalue));
		// Find distinct department names that employees work for.
		System.out.println("<---filterEmployeeList.size---->" + filterEmployeeList.size());

		employeeList.stream().map(emp -> emp.getDepartment()).distinct()
				.forEach(filteredvalue -> distinctEmployeeList.add(filteredvalue));
		
		List<Department> distinctDeoartment=employeeList.stream().map(emp -> emp.getDepartment()).distinct()
		.collect(Collectors.toList());
		System.out.println("<---distinctDeoartment.size---->" + distinctDeoartment.size());

		// Create a comma separate string of department names sorted alphabetically.
		String value = employeeList.stream().map(emp -> emp.getDepartment().getDepartmentName())
				.distinct()
				.sorted()
				.reduce("", (a, b) -> a + "  " + b);
		 System.out.println(value);
		 
		// Print all employee’s name who are working for account department.
		 empNameList= employeeList.stream().filter(emp->emp.getDepartment().getDepartmentName().equals("Account")).map(Employee::getName).collect(Collectors.toList());
		 System.out.println("<---empNameList---->" + empNameList.size());
		 
		 //What is the highest number of of employees in all departments?
				 employeeList.stream()
		            .map(e -> e.getDepartment().getNoOfEmployees())
		            .reduce(Integer::max)
		            .ifPresent(System.out::print);
		 //Find the department which has the highest number of employees.
				 employeeList.stream()
		            .map(Employee::getDepartment)
		            .reduce( (d1, d2) -> d1.getNoOfEmployees() > d2.getNoOfEmployees() ? d1 : d2)
		            .ifPresent(d -> System.out.println(d.getDepartmentName()));
				 
		// Find the total number of employees in all the departments.
				 employeeList.stream()
		            .map(e -> e.getDepartment().getNoOfEmployees())
		            .distinct().reduce(Integer::sum).ifPresent(System.out::println);
	}
	
	
	/*
	 *   PageRequest req = null;
		 Page<Object[]> result = null;
		 List<YOUR ENTITY> responseList = new ArrayList<YOUR ENTITY>();
	     Page<CesEnquiry> result = null;
	     result.map(array -> new WomenAffair(
			(Long) array[0],
			(Employee) array[1],
			(Integer) array[2],
			(WomenAffairCategory) array[3],
			(Date) array[4],
			(String) array[5],
			(WomenAffairStatus) array[6]
			))
	.forEach(entity -> responseList.add(entity));*/
}
