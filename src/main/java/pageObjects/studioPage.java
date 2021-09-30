package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class studioPage {
	public WebDriver driver;
	private By studioIcon = By.className("studioIcon-2TdMR");
	private By searchBar = By.id("location-search");
	private By arrowButton = By.id("location-search-cta");
	private By locationArea = By.className("container-3SE46");
	private By locationName = By.className("linkUnderline-1_h4g");
	private By locationDistance = By.className("distance-OhP63");
	private By dropDownButton = By.className("title-3o8Pv");
	private By dayName = By.className("dayName-CTNC6");
	private By dayHours = By.className("times-fms3v");
	private By joinNowButton=By.id("signup-cta");

	public studioPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement studioIcon() {
		return driver.findElement(studioIcon);
	}

	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}

	public WebElement arrowButton() {
		return driver.findElement(arrowButton);
	}

	public List<WebElement> locationArea() {
		return driver.findElements(locationArea);
	}

	public WebElement location() {
		return locationArea().get(0);
	}

	public WebElement locationName() {
		return location().findElement(locationName);
	}

	public WebElement locationDistance() {
		return location().findElement(locationDistance);
	}
	public WebElement dropDownButton() {
		return driver.findElement(dropDownButton);
	}

	public List<WebElement> dayName() {
		return driver.findElements(dayName);
	}

	public List<WebElement> dayHours() {
		return driver.findElements(dayHours);
	}
	public WebElement joinNowButton() {
		return driver.findElement(joinNowButton);
	}

}
