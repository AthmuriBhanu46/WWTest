package Studio;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import StudioScreen.StudioSearchScreen;
import resources.base;

public class StudioSearchTest extends base {
	public WebDriver driver;
	// creating object to that class and invoke methods of it
	StudioSearchScreen screen = new StudioSearchScreen();

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test
	public void findWWStudioHours() throws IOException, InterruptedException {

		screen.launchappication(driver);
		screen.vaidateTitle(driver);
		screen.findAStudio(driver);
		screen.printBusinessHours(driver);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
