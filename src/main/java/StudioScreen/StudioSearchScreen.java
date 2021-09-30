package StudioScreen;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.io.IOException;
import pageObjects.studioPage;
import resources.base;

public class StudioSearchScreen extends base {
	enum Day {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
	}

	public void launchappication(WebDriver driver) throws IOException {
		loadProperties();
		driver.get(prop.getProperty("url"));
	}

	public void vaidateTitle(WebDriver driver) throws IOException {
		loadProperties();
		String actualTitle = driver.getTitle();
		String expectedTitle = prop.getProperty("title");
		System.out.println("Actual Title is:" + actualTitle);
		System.out.println("Expected Title is:" + expectedTitle);
		Assert.assertEquals(actualTitle.trim(), expectedTitle.trim());
	}

	public void findAStudio(WebDriver driver) throws IOException, InterruptedException {
		loadProperties();
		studioPage page = new studioPage(driver);
		verifyAndClick(driver,page.studioIcon());
		verifyAndClick(driver,page.searchBar());
		String zipCode = (String) prop.get("zipCode");
		page.searchBar().sendKeys(zipCode);
		verifyAndClick(driver,page.arrowButton());
		if (page.locationName().isDisplayed()) {
			String locationName = getTextFromElement(page.locationName());
			String locationDistance = getTextFromElement(page.locationDistance());
			System.out.println("location Name is:" + locationName);
			System.out.println("location Distance is:" + locationDistance);
			verifyAndClick(driver,page.locationName());
			try {
			WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOf(page.joinNowButton()));
		    } catch (Exception e){	
		    }
			
		} else {
			System.out.println("custom message");
		}

	}

	public void printBusinessHours(WebDriver driver) throws IOException, InterruptedException {
		loadProperties();
		studioPage page = new studioPage(driver);
		verifyAndClick(driver,page.dropDownButton());
		Hashtable<String, String> ht = new Hashtable<String, String>();
		List<String> days = new ArrayList<>();
		for (int i = 0; i < page.dayName().size(); i++) {
			String day = page.dayName().get(i).getText();
			String time = page.dayHours().get(i).getText();
			ht.put(day, time);
			days.add(day);

		}

		for (String day : days) {
			System.out.println(day + "    " + ht.get(day.toString()));
		}

	}
}
