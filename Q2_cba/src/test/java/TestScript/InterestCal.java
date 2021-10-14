package TestScript;

import org.testng.annotations.Test;

import PageObject.LoanPage;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class InterestCal {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\cba\\src\\test\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.commbank.com.au/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void interestCal() {

		driver.findElement(By.xpath(LoanPage.homeLoanTab)).click();
		driver.findElement(By.xpath(LoanPage.calculatorAndTools)).click();
		driver.findElement(By.xpath(LoanPage.clickOnCalculteNowINHomeLoanRepayment)).click();
		driver.findElement(By.xpath(LoanPage.inputInterestRate)).click();
		driver.findElement(By.xpath(LoanPage.borrowAmount)).click();
		driver.findElement(By.xpath(LoanPage.borrowAmount)).clear();
		driver.findElement(By.xpath(LoanPage.borrowAmount)).sendKeys("100000");

		driver.findElement(By.xpath(LoanPage.terms)).click();
		driver.findElement(By.xpath(LoanPage.terms)).clear();
		driver.findElement(By.xpath(LoanPage.terms)).sendKeys("2");

		driver.findElement(By.xpath(LoanPage.repaymentTypeDropdwon)).click();
		driver.findElement(By.xpath(LoanPage.repaymentInterest)).click();

		driver.findElement(By.xpath(LoanPage.rateOfInterest)).click();
		driver.findElement(By.xpath(LoanPage.rateOfInterest)).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(By.xpath(LoanPage.rateOfInterest)).sendKeys("2");

		driver.findElement(By.xpath(LoanPage.clickOnCalculate)).click();

	}

	@Test(priority = 2)
	public void totalRepaymentCal() {

		String totalreplaymentamount = driver.findElement(By.xpath("//span[@data-tid='total-repayment']")).getText();
		String totalRepayemnt = "$103,087";
		Assert.assertEquals(totalRepayemnt, totalreplaymentamount);

	}

	
	 
	  @Test(priority =3) 
	  public void totalInterestCharged() {
	  String totalInterestCha_expected =
	  driver.findElement(By.xpath("//span[@data-tid='total-interest']")).getText(); 
	  String totalRepayemnt_Actual = "$3,087";
	  Assert.assertEquals(totalRepayemnt_Actual, totalInterestCha_expected);
	  
	  }
	 
	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
