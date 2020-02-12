package testNGPart1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGAnnotation {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@Test
	public void test1() {
		String x = "test1";
		String y = "test2";
		Assert.assertEquals(x, y);
	}

	@Test(priority = 5, groups = "runtime", enabled = false)
	public void test2() {
		System.out.println("test2");
	}

	@Test(priority = 0, groups = "runtime")
	public void test3() {
		System.out.println("test3");
	}

	@Test(priority = 6, groups = "runtime", invocationCount = 3)
	public void test4() {
		System.out.println("test4");
	}

	
	@Test(priority = 6, groups = "runtime", timeOut = 2)
	public void test5() {
		int i = 0 ;
		while ( i>=1) {
			i++;
			System.out.println(i);
			
			
		}		
	}
	
	@Test(priority = -11, groups = "runtime", expectedExceptions = java.lang.NumberFormatException.class)
	public void test6() {
		String a = "100A-0";
		int x = Integer.parseInt(a);
		System.out.println(x);
				
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("AfterTest");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
}
