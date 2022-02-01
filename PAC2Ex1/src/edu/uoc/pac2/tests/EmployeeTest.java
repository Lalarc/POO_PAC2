package edu.uoc.pac2.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac2.Employee;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeTest {
	
	private ByteArrayOutputStream outContent;	
	private final PrintStream originalOut = System.out;	
	

	Employee employee;
	
	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));	    
	}
	
	@AfterEach
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@BeforeEach
	void init() {
		 employee = new Employee("Fran", "Rambla Poblenou, 156", 13300.50, "fmanezsa@uoc.edu", 2003);
	}
	
	@Test
	void testEmployee() {
		Employee employeeDefault = new Employee();
		assertEquals(12,employeeDefault.getId());
		assertEquals("Lorem Ipsum",employeeDefault.getName());
		assertEquals("Sesame Street",employeeDefault.getStreet());
		assertEquals(50000,employeeDefault.getSalary());
		assertEquals("lorem@uoc.edu",employeeDefault.getEmail());
		assertEquals(1982,employeeDefault.getBirthYear());
	}


	@Test
	void testGetId() {
		assertEquals(1,employee.getId());		
	}

	@Test
	void testGetNextId() {
		assertEquals(7,Employee.getNextId());
	}

	@Test
	void testGetName() {
		assertEquals("Fran",employee.getName());		
	}

	@Test
	void testSetName() {
		employee.setName("David");
		assertEquals("David",employee.getName());
		
		employee.setName("Lorem ipsum dolor sit amet, consectetur vestibulum.");
		assertEquals("[ERROR] Employee's name cannot be longer than 50 characters", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}

	@Test
	void testGetStreet() {
		assertEquals("Rambla Poblenou, 156",employee.getStreet());	
	}

	@Test
	void testSetStreet() {
		employee.setStreet("Plaça Eivissa");
		assertEquals("Plaça Eivissa",employee.getStreet());
	}

	@Test
	void testGetSalary() {		
		assertEquals(13300.50,employee.getSalary());		
	}

	@Test
	void testSetSalary() {
		employee.setSalary(20000);
		assertEquals(20000,employee.getSalary());
		
		employee.setSalary(13299);
		assertEquals("[ERROR] Employee's salary must be in range [13300,60000]", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
		
		restoreStreams();
		
		employee.setSalary(60000.01);
		assertEquals("[ERROR] Employee's salary must be in range [13300,60000]", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));

		employee.setSalary(60000);
		assertEquals(60000.00,employee.getSalary());		
	}

	@Test
	void testGetEmail() {
		assertEquals("fmanezsa@uoc.edu",employee.getEmail());		
	}

	@Test
	void testSetEmail() {
		employee.setEmail("dgarciaso@uoc.edu");
		assertEquals("dgarciaso@uoc.edu",employee.getEmail());
		
		employee.setEmail("fmanezsauoc.edu");
		assertEquals("[ERROR] Employee's email does not have the correct format", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
		
		restoreStreams();
		
		employee.setEmail("fmanezsa@uoc.edu");
		assertEquals("fmanezsa@uoc.edu",employee.getEmail());
	}

	@Test
	void testGetBirthYear() {
		assertEquals(2003,employee.getBirthYear());
	}

	@Test
	void testSetBirthYear() {
		employee.setBirthYear(1982);
		assertEquals(1982,employee.getBirthYear());
		
		employee.setBirthYear(2005);
		assertEquals("[ERROR] Employee's age must be greater than or equal to 18 years old", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
		
		restoreStreams();
	}
}