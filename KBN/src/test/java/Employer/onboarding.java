package Employer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class onboarding extends BaseClass{
	
	@Test
	public void testOnboarding() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Boolean flag = true;
		Boolean loginBtn = driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).isDisplayed();
		if(flag==loginBtn) {
			System.out.println("Login Button is displayed");
		}
		else {
			System.out.println("Login Button is not displayed");
		}
		Boolean contactSupport = driver.findElement(By.linkText("Contact Support")).isDisplayed();
		if(flag==contactSupport) {
			System.out.println("Contact Support Link is displayed");
		}
		else {
			System.out.println("Contact Support Link is not displayed");
		}
		Boolean Logo = driver.findElement(By.className("logo-large")).isDisplayed();
		if(flag==Logo) {
			System.out.println("Logo is Present");
		}
		else {
			System.out.println("Logo is not present");
		}
		String heading = driver.findElement(By.tagName("h1")).getText();
		System.out.println(heading);
		String description = driver.findElement(By.tagName("p")).getText();
		System.out.println(description);
		WebElement Corporation = driver.findElement(By.id("questions-0-choice-0"));
		Corporation.click();
		NextBtn();
		WebElement Qns1 = driver.findElement(By.id("questions-1-choice-0"));
		Qns1.click();
		BackBtn();
		NextBtn();
		validateYesisSelectedorNot();
		NextBtn();
		WebElement Qns2 = driver.findElement(By.id("questions-2-choice-0"));
		Qns2.click();
		BackBtn();
		validateYesisSelectedorNot();
		NextBtn();
		NextBtn();
		String heading1 = driver.findElement(By.tagName("h1")).getText();
		System.out.println(heading1);
		String description1 = driver.findElement(By.tagName("p")).getText();
		System.out.println(description1);
		WebElement Company_Name = driver.findElement(By.id("contact_maybe_company_name"));
		Company_Name.sendKeys("FedBank Inc");
		WebElement Full_Name = driver.findElement(By.id("contact_maybe_full_name"));
		Full_Name.sendKeys("Nithish Kumar");
		WebElement Email = driver.findElement(By.id("contact_maybe_email"));
		Email.sendKeys("test@mailinator.com");
		String Submit = driver.findElement(By.id("maybe-contact-button")).getAttribute("type");
		System.out.println(Submit);
		WebElement Submit1 = driver.findElement(By.id("maybe-contact-button"));
		Submit1.click();
		Thread.sleep(3000);
		String Thanksmessage=driver.findElement(By.tagName("p")).getText();
		System.out.println(Thanksmessage);
		String Back= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).getText();
		System.out.println(Back);
	WebElement	Back1= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']"));
	Back1.click();
	String RedirectUrl = driver.getCurrentUrl();
	System.out.println(RedirectUrl);
	}
	
	public static void validateYesisSelectedorNot() {
		Boolean flag = true;
		Boolean YesisSelected = driver.findElement(By.id("questions-1-choice-0")).isSelected();
		if(flag==YesisSelected) {
			System.out.println("Radio Button is selected on Yes");
		}
		else {
			System.out.println("Radio button not selected on Yes");
		}
	}
	public static void BackBtn() {
		Boolean flag = true;
		Boolean Back = driver.findElement(By.xpath("//button[@class='mr-4 btn btn-light btn-lg']")).isEnabled();
		if(flag==Back) {
			driver.findElement(By.xpath("//button[@class='mr-4 btn btn-light btn-lg']")).click();
		}
		else {
			System.out.println("Back Button is not enabled");
		}
	}
	public static void NextBtn() {
		Boolean flag = true;
		Boolean Next = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).isEnabled();
		if(flag==Next) {
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();
		}
		else {
			System.out.println("Next Button is not enabled");
		}
	}
}
