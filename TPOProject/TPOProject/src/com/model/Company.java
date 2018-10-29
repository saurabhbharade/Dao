package com.model;

public class Company 
{
	private int cid,backlog,numrequired,poolcampus;
	private String cname,designation,location;
	private float salary,ssc,hsc,beaggregate;
	
	//parameterized constructor
		public Company(int cid, int backlog, int numrequired, int poolcampus, String cname, String designation,
				String location, float salary, float ssc, float hsc, float beaggregate) {
			super();
			this.cid = cid;
			this.backlog = backlog;
			this.numrequired = numrequired;
			this.poolcampus = poolcampus;
			this.cname = cname;
			this.designation = designation;
			this.location = location;
			this.salary = salary;
			this.ssc = ssc;
			this.hsc = hsc;
			this.beaggregate = beaggregate;
		}
		
		//default constructor
		public Company() {
			super();
		}
	
	//getters and setter
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBacklog() {
		return backlog;
	}
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}
	public int getNumrequired() {
		return numrequired;
	}
	public void setNumrequired(int numrequired) {
		this.numrequired = numrequired;
	}
	public int getPoolcampus() {
		return poolcampus;
	}
	public void setPoolcampus(int poolcampus) {
		this.poolcampus = poolcampus;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getSsc() {
		return ssc;
	}
	public void setSsc(float ssc) {
		this.ssc = ssc;
	}
	public float getHsc() {
		return hsc;
	}
	public void setHsc(float hsc) {
		this.hsc = hsc;
	}
	public float getBeaggregate() {
		return beaggregate;
	}
	public void setBeaggregate(float beaggregate) {
		this.beaggregate = beaggregate;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", backlog=" + backlog + ", numrequired=" + numrequired + ", poolcampus="
				+ poolcampus + ", cname=" + cname + ", designation=" + designation + ", location=" + location
				+ ", salary=" + salary + ", ssc=" + ssc + ", hsc=" + hsc + ", beaggregate=" + beaggregate + "]";
	}
	

}
