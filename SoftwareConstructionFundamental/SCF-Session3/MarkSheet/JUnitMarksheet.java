import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitMarksheet {
	Marksheet marksheet = new Marksheet();

	@Test(expected = AssertionError.class)
	void assertError() {
			marksheet.minimumGrade(new double[] { 19, -13, 30, 40, 50 });
	}
	
	@Test
	void testAverageOfGrades() {
		assertEquals(30, marksheet.averageOfGrades(new double[] { 10, 20, 30, 40, 50 }));
		assertEquals(40, marksheet.averageOfGrades(new double[] { 50, 30, 30, 40, 50 }));

		assertNotEquals(60, marksheet.averageOfGrades(new double[] { 10, 20, 35, 60, 30 }));
		assertNotEquals(40, marksheet.averageOfGrades(new double[] { 10, 20, 33, 30, 90 }));
	}

	@Test
	void testMaximumGrade() {
		assertEquals(90, marksheet.maximumGrade(new double[] { 20, 40, 50, 60, 90 }));
		assertEquals(45, marksheet.maximumGrade(new double[] { 20, 30, 35, 37, 45 }));

		assertNotEquals(40, marksheet.maximumGrade(new double[] { 20, 40, 50, 60, 90 }));
		assertNotEquals(30, marksheet.maximumGrade(new double[] { 20, 40, 50, 60, 90 }));
	}

	@Test
	void testMinimumGrade() {
		assertEquals(10, marksheet.minimumGrade(new double[] { 10, 20, 30, 40, 50 }));
		assertNotEquals(14, marksheet.minimumGrade(new double[] { 19, 13, 30, 40, 50 }));
	}

	@Test
	void testPercentOfPassedStudents() {
		assertEquals(50, marksheet.percentOfPassedStudents(new double[] { 20, 30, 50, 60 }));
		assertEquals(100, marksheet.percentOfPassedStudents(new double[] { 50, 70, 50, 60 }));

		assertNotEquals(50, marksheet.percentOfPassedStudents(new double[] { 50, 70, 50, 60 }));
	}
}
