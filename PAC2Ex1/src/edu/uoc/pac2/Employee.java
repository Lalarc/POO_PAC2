package edu.uoc.pac2;

import java.time.LocalDate;

public class Employee {

	private int id;
	private static int nextId=0;
	private String name;
	private String street;
	private double salary;
	private String email;
	private int birthYear;
	
	public Employee() {
		setId();
		name="Lorem Ipsum";
		street="Sesame Street";
		salary=50000;
		email="lorem@uoc.edu";
		birthYear=1982;
		
	}
	
	public Employee (String name, String street, double salary, String email, int birthYear) {

		setId();
		setName(name);
		setStreet(street);
		setSalary(salary);
		setEmail(email);
		setBirthYear(birthYear);
		
	}
	
	public int getId(){
		return id;
	}
	
	public static int getNextId() {
		return nextId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public double getSalary() {
		return salary;
	}
	public String getEmail() {
		return email;
	}
	public int getBirthYear() {
		return birthYear;
	}
	
	
	public void setId(){
		this.id=nextId;
		incNextId();
		
	}
	private void incNextId() {
		nextId++;
	}
	public void setName(String name) {
		if(name.length()<=50) {
		this.name=name;
		}else {
			System.out.print("[ERROR] Employee's name cannot be longer than 50 characters");
		}
	}
	public void setStreet(String street) {
		this.street=street;
	}
	public void setSalary(double salary) {
		if((salary>=13300)&&(salary<=60000)) {
			this.salary=salary;
		}else {
			System.out.print("[ERROR] Employee's salary must be in range [13300,60000]");
		}
	}
	public void setEmail(String email) {
		if(email.contains("@")) {
			this.email=email;
		}else {
			System.out.print("[ERROR] Employee's email does not have the correct format");
		}
	}
	public void setBirthYear(int birthYear) {
		if(birthYear<LocalDate.now().getYear()-17) {
			this.birthYear=birthYear;
		}else {
			System.out.println("[ERROR] Employee's age must be greater than or equal to 18 years old");
		}
	}
}
