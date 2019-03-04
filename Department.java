package com;

public class Department {
	private String departmentName;

	private int noOfEmployees;

	public Department(String departmentName, int noOfEmployees) {
		super();
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	
}
