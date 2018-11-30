package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Node1 {
	static WebDriver driver;
	static String nodeUrl;

	@Test
	public void execution() {
		try {
			nodeUrl = "http://192.168.28.1:5556/wd/hub";
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeUrl), dc);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/");
			System.out.println("The title of the page is: " + driver.getTitle());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void tearDown() {
		System.out.println("browser closed!!");
		driver.close();
	}

}
