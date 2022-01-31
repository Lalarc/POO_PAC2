package edu.uoc.pac2.strings.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac2.strings.PAC2Ex4;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class Check {

	PAC2Ex4 p;
	
	@BeforeAll
	void init() {
		p = new PAC2Ex4();
	}
	
	@Test
	@Order(1)
	void testPalindrome() {
		assertNull(p.palindromeADN(null));
		assertEquals("AA", p.palindromeADN("a"));
		assertEquals("ATCGGCTA", p.palindromeADN("ATCG"));
		assertEquals("ACCCCA", p.palindromeADN("acc"));
		assertEquals("ACCTTCCA", p.palindromeADN("AC C t"));
	}
	
	@Test
	@Order(2)
	void testEquals() {
		
		assertTrue(p.equalsADN("CGTA", "CGTA"));
		assertTrue(p.equalsADN("CGTA", "TACG"));
		assertTrue(p.equalsADN("CGTA", "TACG"));
		assertTrue(p.equalsADN("ACCGAATCATT", "ATCATTACCGA"));
		assertTrue(p.equalsADN("", ""));
		assertFalse(p.equalsADN("CGTA", "TAGC"));
		assertFalse(p.equalsADN(null, "CGTA"));
		assertFalse(p.equalsADN("C", null));
		assertFalse(p.equalsADN(null, null));
	}
	
	@Test
	@Order(3)
	void testPrint() {
		assertEquals("A\nT\nC\nG\nT\nG\n", p.printADN("ATCGTG", 1));
		assertEquals("A\n T\nC\n G\nT\n G\n", p.printADN("ATCGTG", 2));
		assertEquals("A\n T\n  C\n G\nT\n G\n"	, p.printADN("ATCGTG", 3));
		assertEquals("A\n C\n  C\n   G\n  A\n A\nT\n C\n  A\n   T\n  T\n A\nC\n C\n  G\n   A\n  A\n T\nC\n A\n  T\n   T\n", p.printADN("ACCGAATCATTACCGAATCATT", 4));
		
		assertNull(p.printADN(null, 1));
		assertNull(p.printADN("ATCGT", 1));
		assertNull(p.printADN("ATCGTG", 0));
	}
}
