package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

    public static  WebDriver driver;
    public Properties prop;
   
    public WebDriver initializeDriver() throws IOException
    {

    	loadProperties();
         //mvn test -Dbrowser=chrome

        String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
        System.out.println(browserName);

        if(browserName.contains("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
            //execute in chrome driver
            driver= new ChromeDriver();
        }
        else if (browserName.equals("safari"))
        {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;

    }
    
    public void loadProperties() throws IOException  
    {
    	 prop= new Properties();
         FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
         prop.load(fis);
    }
    
   public void verifyAndClick(WebDriver driver, WebElement element)
   {     WebDriverWait wait = new WebDriverWait(driver,30);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	  if(element.isDisplayed())
	  {
		  element.click();
		  System.out.println(element+"is clicked");
	  }
	  else 
	  {
		  System.out.println(element+"is not displayed");
	  }
   }
   public String getTextFromElement(WebElement element)
   {   
	  if(element.isDisplayed())
	  {
		 return element.getText();
	  }
	  else 
	  {
		  System.out.println(element+"is not displayed");
		  return null;
	  }
	
   }
}
