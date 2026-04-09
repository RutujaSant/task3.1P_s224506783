package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S224506783";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Rutuja Sant";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);   // 1 January 2024
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());             // should be 2 January
		Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);   // 1 January 2024
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());            // should be 31 December 2023
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// ============================================================
	// TABLE A - Previous Date (decrement) tests
	// ============================================================

	@Test
	public void test_1A_June1_1994_PreviousShouldBeMay31() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.decrement();
	    assertEquals(31, date.getDay());
	    assertEquals(5, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_2A_June2_1994_PreviousShouldBeJune1() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.decrement();
	    assertEquals(1, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_3A_June15_1994_PreviousShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_4A_June30_1994_PreviousShouldBeJune29() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.decrement();
	    assertEquals(29, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void test_5A_June31_1994_ShouldBeInvalid() {
	    DateUtil date = new DateUtil(31, 6, 1994);
	}

	@Test
	public void test_6A_January15_1994_PreviousShouldBeJanuary14() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(1, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_7A_February15_1994_PreviousShouldBeFebruary14() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(2, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_8A_November15_1994_PreviousShouldBeNovember14() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(11, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_9A_December15_1994_PreviousShouldBeDecember14() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(12, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_10A_June15_1700_PreviousShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1700, date.getYear());
	}

	@Test
	public void test_11A_June15_1701_PreviousShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1701, date.getYear());
	}

	@Test
	public void test_12A_June15_2023_PreviousShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(2023, date.getYear());
	}

	@Test
	public void test_13A_June15_2024_PreviousShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.decrement();
	    assertEquals(14, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(2024, date.getYear());
	}

	// ============================================================
	// TABLE B - Next Date (increment) tests
	// ============================================================

	@Test
	public void test_1B_June1_1994_NextShouldBeJune2() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.increment();
	    assertEquals(2, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_2B_June2_1994_NextShouldBeJune3() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.increment();
	    assertEquals(3, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_3B_June15_1994_NextShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_4B_June30_1994_NextShouldBeJuly1() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.increment();
	    assertEquals(1, date.getDay());
	    assertEquals(7, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_5B_January15_1994_NextShouldBeJanuary16() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(1, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_6B_February15_1994_NextShouldBeFebruary16() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(2, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_7B_November15_1994_NextShouldBeNovember16() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(11, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_8B_December15_1994_NextShouldBeDecember16() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(12, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test
	public void test_9B_June15_1700_NextShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1700, date.getYear());
	}

	@Test
	public void test_10B_June15_1701_NextShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(1701, date.getYear());
	}

	@Test
	public void test_11B_June15_2023_NextShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(2023, date.getYear());
	}

	@Test
	public void test_13B_June15_2024_NextShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.increment();
	    assertEquals(16, date.getDay());
	    assertEquals(6, date.getMonth());
	    assertEquals(2024, date.getYear());
	}

	// ============================================================
	// EXTRA: February leap year tests
	// ============================================================

	@Test
	public void test_Extra_Feb28_LeapYear_NextShouldBeFeb29() {
	    // 2024 is a leap year — February has 29 days
	    DateUtil date = new DateUtil(28, 2, 2024);
	    date.increment();
	    assertEquals(29, date.getDay());
	    assertEquals(2, date.getMonth());
	    assertEquals(2024, date.getYear());
	}

	@Test
	public void test_Extra_Feb29_LeapYear_NextShouldBeMarch1() {
	    // 2024 is a leap year
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.increment();
	    assertEquals(1, date.getDay());
	    assertEquals(3, date.getMonth());
	    assertEquals(2024, date.getYear());
	}

	@Test
	public void test_Extra_Feb28_NonLeapYear_NextShouldBeMarch1() {
	    // 1994 is NOT a leap year — February has only 28 days
	    DateUtil date = new DateUtil(28, 2, 1994);
	    date.increment();
	    assertEquals(1, date.getDay());
	    assertEquals(3, date.getMonth());
	    assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void test_Extra_Feb29_NonLeapYear_ShouldBeInvalid() {
	    // 1994 is NOT a leap year — Feb 29 doesn't exist
	    DateUtil date = new DateUtil(29, 2, 1994);
	}
}
