package Employer;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FillingBusinessDetails extends BaseClass {
	protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	@Test()
	public void testFillingBusinessDetails() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement Login = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
		Login.click();
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys("test27@mailinator.com");
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("xyz@1241");
		WebElement Remember = driver.findElement(By.cssSelector("#remember.form-check-input"));
		Remember.click();
		WebElement LoginBtn = driver.findElement(By.id("login-form-button"));
		LoginBtn.click();
		
		//Step 1 Business Details
		WebElement BizName = driver.findElement(By.id("name"));
		BizName.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		BizName.sendKeys("test business");
		WebElement Address1 = driver.findElement(By.id("billing_address_line1"));
		Address1.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		Address1.sendKeys("Address Line 1 here...");
		WebElement Address2 = driver.findElement(By.id("billing_address_line2"));
		Address2.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		Address2.sendKeys("Address Line 2 here....");
		WebElement City = driver.findElement(By.id("billing_city"));
		City.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		City.sendKeys("Calgary");
		WebElement Province = driver.findElement(By.xpath("(//div[@class=' css-rjaker-control'])[1]"));
		Province.click();
		WebElement Alberta = driver.findElement(By.xpath("//div[contains(text(),'Alberta')]"));
		Alberta.click();
		WebElement postalCode = driver.findElement(By.id("billing_postal_code"));
		postalCode.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		postalCode.sendKeys("T1X0L5");
		WebElement phNumber = driver.findElement(By.id("billing_phone_number"));
		phNumber.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		phNumber.sendKeys("9502627001");
		WebElement website = driver.findElement(By.name("billing_address.website "));
		website.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		website.sendKeys("www.calgary.com");
		Boolean flag=true;
		Boolean mailAddress = driver.findElement(By.cssSelector("input.form-check-input")).isSelected();
		if(flag==mailAddress) {
			System.out.println("mailing address same as address is selected");
		}
		else {
			driver.findElement(By.xpath("//label[@for='same_address']")).click();
		}
		NextBtn();
		
		//steps 2 Account Settings
		Boolean PrepaidAcc = driver.findElement(By.cssSelector("#account_type_upfront")).isSelected();
		if(flag==PrepaidAcc) {
			System.out.println("Prepaid Account is by default selected");
		}
		else{
			System.out.println("Prepaid Account not selected");
		}
		BackBtn();
		String step1form = driver.findElement(By.tagName("form")).getText();
		System.out.println(step1form);
		NextBtn();
		WebElement PeriodStartDate = driver.findElement(By.cssSelector("div.react-datepicker__input-container"));
		PeriodStartDate.click();
		WebElement previousMonth = driver.findElement(By.cssSelector("button.react-datepicker__navigation--previous"));
		previousMonth.click();
		WebElement MonthsDrdw = driver.findElement(By.cssSelector("span.react-datepicker__month-read-view--down-arrow"));
		MonthsDrdw.click();
		WebElement Select2ndMonth = driver.findElement(By.cssSelector("div.react-datepicker__month-option:nth-child(2)"));
		Select2ndMonth.click();
		String step2form = driver.findElement(By.tagName("form")).getText();
		System.out.println(step2form);
		WebElement rollOver = driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[1]"));
		rollOver.click();
		WebElement GracePeriod = driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[2]"));
		GracePeriod.click();
		WebElement monthlyAccount = driver.findElement(By.cssSelector("#account_type_monthly"));
		monthlyAccount.click();
		NextBtn();
		
		//Step 3 Add Employees and classes
		createClass();
		addNewEmployees();
		addNewEmployees();
		Thread.sleep(5000);
		JavascriptExecutor js =((JavascriptExecutor) driver);
		Actions a = new Actions(driver);
		WebElement tickEmp = driver.findElement(By.xpath("(//input[@class='form-check-input ml-0'])[2]"));
		a.moveToElement(tickEmp).click().build().perform();
		Thread.sleep(3000);
		WebElement Edit = driver.findElement(By.cssSelector("button.ml-1.px-4.btn.btn-secondary:nth-child(1)"));
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		Edit.click();
		WebElement firstName1 = driver.findElement(By.cssSelector("#employee_first_name"));
		firstName1.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		firstName1.sendKeys("test");
		WebElement LastName1 = driver.findElement(By.cssSelector("#employee_last_name"));
		LastName1.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		LastName1.sendKeys("test");
		WebElement email1 = driver.findElement(By.cssSelector("#email"));
		email1.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		email1.sendKeys(getSaltString()+"@mailinator.com");
		WebElement clClass1 = driver.findElement(By.cssSelector("div.css-rjaker-control"));
		clClass1.click();
		WebElement slClass1 = driver.findElement(By.xpath("//div[contains(text(),'Executives')]"));
		slClass1.click();
		WebElement Prorate1 = driver.findElement(By.cssSelector("#employee_prorate"));
		js.executeScript("arguments[0].scrollIntoView(true);", Prorate1);
		Prorate1.click();
		WebElement Update = driver.findElement(By.xpath("//span[text()='Update']"));
		js.executeScript("arguments[0].scrollIntoView(true);",Update);
		Update.click();
		Thread.sleep(2000);
		try {
			String UserExists = driver.findElement(By.xpath("//div[contains(text(),'User with this email')]")).getText();
			System.out.println(UserExists);
			WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", Cancel);
			Cancel.click();
		}
		catch(Exception e) {
			System.out.println("User details Updated");
		}
		Thread.sleep(5000);
		//delete employee
		WebElement tickEmp1 = driver.findElement(By.xpath("(//input[@class='form-check-input ml-0'])[2]"));
		a.moveToElement(tickEmp1).click().build().perform();
		Thread.sleep(2000);
		WebElement delEmp = driver.findElement(By.cssSelector("button.ml-1.px-4.btn.btn-secondary:nth-child(3)"));
		js.executeScript("arguments[0].scrollIntoView(true);", delEmp);
		delEmp.click();
		WebElement typeDel = driver.findElement(By.cssSelector("#delete"));
		typeDel.sendKeys("DELETE");
		WebElement Del = driver.findElement(By.cssSelector("#delete-confirm-button"));
		Del.click();
		
		//Add emp details whose is already added
		WebElement addEmp1 = driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]"));
		addEmp1.click();
		WebElement firstName2= driver.findElement(By.cssSelector("#employee_first_name"));
		firstName2.sendKeys("test");
		WebElement LastName2 = driver.findElement(By.cssSelector("#employee_last_name"));
		LastName2.sendKeys("test");
		WebElement email2 = driver.findElement(By.cssSelector("#email"));
		email2.sendKeys("mathan@mailinator.com");
		WebElement clClass2 = driver.findElement(By.cssSelector("div.css-rjaker-control"));
		clClass2.click();
		WebElement slClass2 = driver.findElement(By.xpath("//div[contains(text(),'Executives')]"));
		slClass2.click();
		WebElement Prorate2 = driver.findElement(By.cssSelector("#employee_prorate"));
		js.executeScript("arguments[0].scrollIntoView(true);", Prorate2);
		Prorate2.click();
		WebElement Add1 = driver.findElement(By.cssSelector("#admin-claims-return-button"));
		js.executeScript("arguments[0].scrollIntoView(true);", Add1);
		Add1.click();
		Thread.sleep(5000);
		try {
			String UserExists = driver.findElement(By.xpath("//div[contains(text(),'User with this email')]")).getText();
			System.out.println(UserExists);
			WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", Cancel);
			Cancel.click();
		}
		catch(Exception e) {
			System.out.println("emp added");
		}
		
		//import employees
		WebElement importEmp = driver.findElement(By.xpath("//button[contains(text(),'Import Employees')]"));
		importEmp.click();
		WebElement no_Employeecl1 = driver.findElement(By.name("classes[0].count"));
		no_Employeecl1.sendKeys("1");
		WebElement no_Employeecl2 = driver.findElement(By.name("classes[1].count"));
		no_Employeecl2.sendKeys("1");
		WebElement Export = driver.findElement(By.xpath("//button[contains(text(),'Export')]"));
		Export.click();
		WebElement ImportSave = driver.findElement(By.xpath("//span[text()='Save']"));
		ImportSave.click();
		try {
			String failedImport = driver.findElement(By.xpath("//div[contains(text(),'Failed to update business')]")).getText();
			System.out.println(failedImport);
			WebElement close = driver.findElement(By.xpath("(//button[@aria-label='Close'])[2]"));
			close.click();
		}catch(Exception e) {
			System.out.println("Imported File Successfully");
		}
		Thread.sleep(3000);
		//Edit Class
		WebElement EditCl = driver.findElement(By.xpath("(//button[contains(text(),'Edit')])[1]"));
		EditCl.click();
		WebElement clName = driver.findElement(By.cssSelector("#name"));
		clName.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		clName.sendKeys("Owner Name");
		WebElement clLimit = driver.findElement(By.cssSelector("#limit"));
		clLimit.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		clLimit.sendKeys("1500");
		WebElement Save1 = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		Save1.click();
		Thread.sleep(3000);
		WebElement searchEmployee = driver.findElement(By.xpath("//input[@placeholder='Search Employees']"));
		searchEmployee.sendKeys("test");
		Thread.sleep(2000);
		WebElement Next = driver.findElement(By.xpath("//button[text()='Next']"));
		Next.click();
		WebElement AcClaimAccess= driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(6) input"));
		AcClaimAccess.click();
		WebElement AcBillAccess = driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(7) input"));
		AcBillAccess.click();
	}
	public static void NextBtn() {
		Boolean flag = true;
		Boolean Next = driver.findElement(By.cssSelector("#onboarding-step-1-submit")).isEnabled();
		if(flag==Next) {
			driver.findElement(By.cssSelector("#onboarding-step-1-submit")).click();
		}
		else {
			System.out.println("Next Button is not enabled");
		}
	}
	public static void BackBtn() {
		Boolean flag = true;
		Boolean Back = driver.findElement(By.cssSelector("button.btn-secondary")).isEnabled();
		if(flag==Back) {
			driver.findElement(By.cssSelector("button.btn-secondary")).click();
		}
		else {
			System.out.println("Back Button is not enabled");
		}
	}
	public static void createClass() throws InterruptedException {
		Boolean flag = true;
		Thread.sleep(3000);
		Boolean crClass = driver.findElement(By.xpath("//button[contains(text(),'Create Class')]")).isEnabled();
		if(flag==crClass) {
			driver.findElement(By.xpath("//button[contains(text(),'Create Class')]")).click();
			WebElement className = driver.findElement(By.cssSelector("#name"));
			className.sendKeys("Executives");
			WebElement classLimit = driver.findElement(By.cssSelector("#limit"));
			classLimit.sendKeys("1000");
			WebElement Save = driver.findElement(By.cssSelector("#admin-claims-return-button"));
			Save.click();
		}else {
			System.out.println("element not enabled");
		}
		
	}
	public static void addNewEmployees() throws InterruptedException {
		Thread.sleep(5000);
		//add emp whose email not added earlier -- non exisitng
		WebElement addEmp = driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]"));
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", addEmp);
		Thread.sleep(1000);
		addEmp.click();
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#employee_first_name"));
		js.executeScript("arguments[0].scrollIntoView(true);", firstName);
		firstName.sendKeys("test");
		WebElement LastName = driver.findElement(By.cssSelector("#employee_last_name"));
		LastName.sendKeys("test");
		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys(getSaltString()+"@mailinator.com");
		WebElement clClass = driver.findElement(By.cssSelector("div.css-rjaker-control"));
		clClass.click();
		WebElement slClass = driver.findElement(By.xpath("//div[contains(text(),'Executives')]"));
		slClass.click();
		WebElement Prorate = driver.findElement(By.xpath("//label[contains(text(),'Prorate Annual Limit')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Prorate);
		Prorate.click();
		WebElement Add = driver.findElement(By.cssSelector("#admin-claims-return-button"));
		js.executeScript("arguments[0].scrollIntoView(true);", Add);
		Add.click();
		Thread.sleep(2000);
		try {
		String UserExists = driver.findElement(By.xpath("//div[contains(text(),'User with this email')]")).getText();
		System.out.println(UserExists);
		WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Cancel);
		Cancel.click();
		}
		catch(Exception e) {
			System.out.println("Added details of new employee");
		}
	}
	
}
