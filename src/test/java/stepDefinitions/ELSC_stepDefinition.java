package stepDefinitions;           

import cucumber.api.PendingException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ExcelDriver;

@RunWith(Cucumber.class)
public class ELSC_stepDefinition {
	
	WebDriver driver;
	ExcelDriver exObj = new ExcelDriver();
	
	@Given("^User launches the application \"([^\"]*)\" and logs in as an admin$")
    public void user_launches_the_application_something_and_logs_in_as_an_admin(String strArg1) throws Throwable {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\GagandeepPanesar\\Downloads\\chromedriver_win32\\chromedriver.exe");
      
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GagandeepPanesar\\eclipse-workspace\\AutomationFramework\\src\\test\\java\\utilities\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get(strArg1);
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin@123");
		driver.findElement(By.cssSelector("#form-login_submitAuth")).click();		
    }

    @When("^Users clicks on Administration tab$")
    public void users_clicks_on_administration_tab() throws Throwable {
    	driver.findElement(By.linkText("Administration")).click();
    }    

    @And("^Clicks on Add users to course link$")
    public void clicks_on_add_users_to_course_link() throws Throwable {
    	driver.findElement(By.linkText("Add users to course")).click();        	
    }

    @And("^Selects user from the user list$")
    public void selects_user_from_the_user_list() throws Throwable {
    	driver.findElement(By.xpath("//option[@value='434']")).click();    	
    }

    @And("^Selects course from the course list$")
    public void selects_course_from_the_course_list() throws Throwable {
    	driver.findElement(By.xpath("//option[@value='528']")).click();	
    }

    @And("^Clicks on Add to the course button$")
    public void clicks_on_add_to_the_course_button() throws Throwable {    	
    	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); 
    }
    
    @Then("^The selected users are subscribed to the selected course message should get displayed$")
    public void the_selected_users_are_subscribed_to_the_selected_course_message_should_get_displayed() throws Throwable {
        String expAlert = "The selected users are subscribed to the selected course";      
        String actualAlert = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();	
        Assert.assertEquals(expAlert, actualAlert); 
        driver.close();
    }
        
        
    @And("^Clicks on Courses Categories link$")
    public void clicks_on_courses_categories_link() throws Throwable {
    	driver.findElement(By.linkText("Courses categories")).click();
    }

    @And("^Clicks on Add Category icon$")
    public void clicks_on_add_category_icon() throws Throwable {    	
    	driver.findElement(By.xpath("//img[@alt='Add category']")).click();
    }

    @And("^Enters valid credentials in Category Code textbox$")
    public void enters_valid_credentials_in_category_code_textbox() throws Throwable {
    	
    	String categoryCode = exObj.getDataFromExcel(1, 0);
    	driver.findElement(By.id("course_category_code")).sendKeys(categoryCode);
    }

    @And("^Enters valid credentials in Category name textbox$")
    public void enters_valid_credentials_in_category_name_textbox() throws Throwable {   
    	String categoryName = exObj.getDataFromExcel(1, 1);
    	driver.findElement(By.id("course_category_name")).sendKeys(categoryName);
    }

    @And("^Clicks on Yes radio button in Allow adding courses in this category\\? Section$")
    public void clicks_on_yes_radio_button_in_allow_adding_courses_in_this_category_section() throws Throwable {
    	driver.findElement(By.xpath("//input[@name='auth_course_child']")).click();
    }

    @And("^Clicks on Add Category button$")
    public void clicks_on_add_category_button() throws Throwable {    	
    	driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
    }
    
    @Then("^Added Category should get displayed in Courses categories$")
    public void added_category_should_get_displayed_in_courses_categories() throws Throwable {    	
    	String expAlert = "This category is already used";      
        String actualAlert = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();	
        Assert.assertEquals(expAlert, actualAlert); 
        driver.close();

    }

}