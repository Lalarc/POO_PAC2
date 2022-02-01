package edu.uoc.pac2.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac2.Employee;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeTest {
	
	
	Employee employee;
		
	
	@BeforeEach
	void init() {
		 try{
			 employee = new Employee("Fran", "Rambla Poblenou, 156", 13300.50, "fmanezsa@uoc.edu", 2003);
		 }catch(Exception e) {
				fail("Parameterized constructor failed");
		}
	}
	
	@Test
	void testEmployee() {
		try{
			Employee employeeDefault = new Employee();
			assertEquals(12,employeeDefault.getId());
			assertEquals("Lorem Ipsum",employeeDefault.getName());
			assertEquals("Sesame Street",employeeDefault.getStreet());
			assertEquals(50000,employeeDefault.getSalary());
			assertEquals("lorem@uoc.edu",employeeDefault.getEmail());
			assertEquals(1982,employeeDefault.getBirthYear());
		}catch(Exception e) {
			fail("Default constructor failed");
		}
		
	}

	@Test
	void testConstructor() {		
		Exception ex = assertThrows(Exception.class, () -> new Employee("Lorem ipsum dolor sit amet, consectetur vestibulum.", "Rambla Poblenou, 156", 13300.50, "fmanezsa@uoc.edu", 2003)); 
		assertEquals("[ERROR] Employee's name cannot be longer than 50 characters", ex.getMessage());
		
		ex = assertThrows(Exception.class, () -> new Employee("Fran", "Rambla Poblenou, 156", 10000, "fmanezsa@uoc.edu", 2003));
		assertEquals("[ERROR] Employee's salary must be in range [13300,60000]", ex.getMessage());
		
		ex = assertThrows(Exception.class, () -> new Employee("Fran", "Rambla Poblenou, 156", 13300.50, "fmanezsauoc.edu", 2003));
		assertEquals("[ERROR] Employee's email does not have the correct format", ex.getMessage());
		
		ex = assertThrows(Exception.class, () -> new Employee("Fran", "Rambla Poblenou, 156", 13300.50, "fmanezsa@uoc.edu", 2020));
		assertEquals("[ERROR] Employee's age must be greater than or equal to 18 years old", ex.getMessage());		
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
		try{
			employee.setName("David");
			assertEquals("David",employee.getName());
		}catch(Exception e) {
			fail("setName failed");
		}
		
		
		Exception ex = assertThrows(Exception.class, () ->	employee.setName("Lorem ipsum dolor sit amet, consectetur vestibulum."));
		assertEquals("[ERROR] Employee's name cannot be longer than 50 characters", ex.getMessage());
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
		try{
			employee.setSalary(20000);
			assertEquals(20000,employee.getSalary());
		}catch(Exception e) {
			fail("setLatitude failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	employee.setSalary(13299));
		assertEquals("[ERROR] Employee's salary must be in range [13300,60000]", ex.getMessage());
		
		
		ex = assertThrows(Exception.class, () ->	employee.setSalary(60000.01));
		assertEquals("[ERROR] Employee's salary must be in range [13300,60000]", ex.getMessage());
	}

	@Test
	void testGetEmail() {
		assertEquals("fmanezsa@uoc.edu",employee.getEmail());		
	}

	@Test
	void testSetEmail() {
		try{
			employee.setEmail("dgarciaso@uoc.edu");
			assertEquals("dgarciaso@uoc.edu",employee.getEmail());
		}catch(Exception e) {
			fail("setLongitude failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	employee.setEmail("fmanezsauoc.edu"));
		assertEquals("[ERROR] Employee's email does not have the correct format", ex.getMessage());
	
	}

	@Test
	void testGetBirthYear() {
		assertEquals(2003,employee.getBirthYear());
	}

	@Test
	void testSetBirthYear() {
		try{
			employee.setBirthYear(1982);
			assertEquals(1982,employee.getBirthYear());
		}catch(Exception e) {
			fail("setCapacity failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	employee.setBirthYear(2005));
		assertEquals("[ERROR] Employee's age must be greater than or equal to 18 years old", ex.getMessage());
	}
}