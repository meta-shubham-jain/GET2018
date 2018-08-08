import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitArea {
	Area area = new Area();

	@Test(expected = AssertionError.class) 
	void assertError() {
		area.area.areaOfTriangle(15, -4);
		area.areaOfRectangle(-6, -5);
	}
	
	@Test
	void testAreaOfTriangle() {
		assertEquals(15, area.areaOfTriangle(5, 6));
		assertEquals(30, area.areaOfTriangle(15, 4));

		assertNotEquals(15, area.areaOfTriangle(5, 36));
		assertNotEquals(20, area.areaOfTriangle(25, 6));
	}

	@Test
	void testAreaOfRectangle() {
		assertEquals(20, area.areaOfRectangle(4, 5));
		assertEquals(30, area.areaOfRectangle(6, 5));

		assertNotEquals(20, area.areaOfRectangle(8, 5));
		assertNotEquals(20, area.areaOfRectangle(14, 5));
	}

	@Test
	void testAreaOfSquare() {
		assertEquals(16, area.areaOfSquare(4));
		assertEquals(64, area.areaOfSquare(8));

		assertNotEquals(16, area.areaOfSquare(9));
		assertNotEquals(16, area.areaOfSquare(14));
	}

	@Test
	void testAreaOfCircle() {
		assertEquals(78.53981633974483, area.areaOfCircle(5));
		assertEquals(113.09733552923255, area.areaOfCircle(6));

		assertNotEquals(67.54, area.areaOfCircle(8));
		assertNotEquals(78.96, area.areaOfCircle(9));
	}
}
