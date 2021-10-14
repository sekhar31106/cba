package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoanPage {
	
	public static String homeLoanTab="(//a[text()='Home loans'])[1]";
	
	public static String repaymentsCalculator="//a[text()='Repayments calculator']";
	
	public static String calculatorAndTools="//a/span[text()='Calculators & tools']";
	
	public static String clickOnCalculteNowINHomeLoanRepayment="//a[@data-tracker-locationid='calc_repayments']";
	
	public static String inputInterestRate="(//a[text()='input interest rate'])[1]";
	
	public static String borrowAmount="//div[@class='form-group']//input[@id='amount']";
	
	public static String terms="//div[@class='input-group']//input[@id='term']";

	public static String repaymentTypeDropdwon="//span[@class='custom-drop-down']//select[@id='interestOnly']";
	
	public static String rateOfInterest="//div[@class='input-group']//input[@id='customRate']";
	
	public static String repaymentInterest="//span[@class='custom-drop-down']//select[@id='interestOnly']/option[text()='Interest only 1 year']";
	
	public static String clickOnCalculate="//button[@id='submit']";
	
	
	public static String totalLoanRepayment="//span[@data-tid='total-repayment']";
	
	public static String totalInterest="//span[@data-tid='total-interest']";
	
	
	WebDriver driver = new ChromeDriver();		
	

}
