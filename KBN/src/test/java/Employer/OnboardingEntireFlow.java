package Employer;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OnboardingEntireFlow extends BaseClass {
	public static final String currentDir = System.getProperty("user.dir");
@Test(dataProvider ="Create Account")
public void testOnboardingEntireFlow(String FN,String LN,String Email,String cEmail,String Passkey,String cPasskey,String exp,String landingPg,String act) throws InterruptedException, IOException {
	driver.navigate().to("https://develop.diaf1ue54hor1.amplifyapp.com/check_eligibility"); 
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement Corporation = driver.findElement(By.id("questions-0-choice-0"));
	Corporation.click();
	NextBtn();
	WebElement Qns1 = driver.findElement(By.id("questions-1-choice-0"));
	Qns1.click();
	NextBtn();
	WebElement Qns2 = driver.findElement(By.id("questions-2-choice-1"));
	Qns2.click();
	NextBtn();
	String SuccessMsg = driver.findElement(By.tagName("h2")).getText();
	System.out.println(SuccessMsg);
	WebElement FirstName = driver.findElement(By.id("first_name"));
	FirstName.sendKeys(FN);
	WebElement SecondName = driver.findElement(By.id("last_name"));
	SecondName.sendKeys(LN);
	WebElement EmailID = driver.findElement(By.id("email"));
	EmailID.sendKeys(Email);
	WebElement confirmEmail = driver.findElement(By.id("confirm_email"));
	confirmEmail.sendKeys(cEmail);
	WebElement Password = driver.findElement(By.id("password"));
	Password.sendKeys(Passkey);
	WebElement confirmPassword = driver.findElement(By.id("re_password"));
	confirmPassword.sendKeys(cPasskey);
	WebElement CreateAccount = driver.findElement(By.id("admin-eligible-button"));
	CreateAccount.click();
	Thread.sleep(5000);
	String actPage = driver.getCurrentUrl();
	int i=Integer.parseInt(act);
	String path=currentDir+"\\dataFiles\\CreateAccount.xlsx";
	ExcelUtils excel = new ExcelUtils(path);
	if(exp.equals("Pass"))
	 {
		 if(landingPg.equals(actPage)) {
			 excel.setCellData("Sheet1", i, 8, "Pass");
			 Assert.assertTrue(true);
		   }
		 else{
			 excel.setCellData("Sheet1", i, 8, "Fail");
			 Assert.assertTrue(false); 
		    }
		 }
		 else if(exp.equals("Fail"))
		 {
			 try {
				Boolean existingUser = driver.findElement(By.xpath("//div[contains(text(),'User with this email address already exists.')]")).isDisplayed();
				 System.out.println(existingUser);
			 }catch(NoSuchElementException e) {
				 System.out.println(e);
			 }
			 if(landingPg.equals(actPage)) {
				 excel.setCellData("Sheet1", i, 8, "Pass");
				 
			 }
			 else
			 {
				 excel.setCellData("Sheet1", i, 8, "Fail");
				
			 }
		 }
	 System.out.println();

}
@DataProvider(name="Create Account")
public String[][] getData() throws IOException {

	String path=currentDir+"\\dataFiles\\CreateAccount.xlsx";
	ExcelUtils excel = new ExcelUtils(path);
	int totalrows= excel.getRowCount("Sheet1");
	int totalcols= excel.getCellCount("Sheet1",1);

	String loginData[][]=new String[totalrows][totalcols];
	for(int i=1;i<=totalrows;i++) //1
	{
		for(int j=0;j<totalcols;j++) //0
		{
			loginData[i-1][j]=excel.getCellData("Sheet1", i, j);
		}
	}	
	return loginData;	
}

public static void NextBtn() {
	WebElement Next = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']"));
	Next.click();
}
	
}
