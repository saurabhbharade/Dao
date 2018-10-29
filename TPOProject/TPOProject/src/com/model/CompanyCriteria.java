package com.model;

public class CompanyCriteria
{
	Company company;
	int yop;
	String branch;
	
	//parameterized constructor
	public CompanyCriteria(Company company, int yop, String branch) {
		super();
		this.company = company;
		this.yop = yop;
		this.branch = branch;
	}

	//default constructor
	public CompanyCriteria() {
		super();
	}

	//getters and setters
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	//toString
	@Override
	public String toString() {
		return "CompanyCriteria [company=" + company + ", yop=" + yop + ", branch=" + branch + "]";
	}
	
	
}
