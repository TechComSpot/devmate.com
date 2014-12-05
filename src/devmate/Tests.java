package devmate;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.uiautomation.ios.client.uiamodels.impl.RemoteIOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Tests {
	private WebDriver driver;

	@Before public void PreTests () {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("browserName", "safari");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		//System.setProperty("RemoteIOSDriver", "D://DIST/ios-server-0.6.5-jar-with-dependencies.jar");

		//driver = new ios simulator();
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//������� �������� http://devmate.com
		driver.get("http://devmate.com");
		
	}
	
	@Test public void FirstScenario () throws Exception
	{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//�������� �� ������ Sign Up Now
			driver.findElement(By.xpath(".//a[@class='nav-signup']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//�� �������� http://devmate.com/signup �������� ������� I'm selling or considering selling outside the Mac App Store.
			driver.findElement(By.xpath(".//input[@name='selling_outside_app_store']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//��������� ��������� ����� solution
			driver.findElement(By.xpath(".//input[@name='solution']")).isDisplayed();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println("�������� ��������� ����� solution: " +driver.findElement(By.xpath("//*[@id='form-signup']/input[5]")).getText());
				
	}
	
	@Test public void SecondScenario () throws Exception
	{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//�������� �� FEATURES
			driver.findElement(By.xpath(".//nav/a[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//��������� ��� ��������� �� http://devmate.com/features/frameworks
			driver.getTitle();
			driver.findElement(By.xpath(".//img[@alt='Sparkle-based updates framework']")).getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//��������� ����������� �������� (��. ��������)
			System.out.println("�������� ����������� ��������: " +driver.findElement(By.xpath(".//img[@alt='Sparkle-based updates framework']")).getText());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//������� �������� ��������, ���������� ��� � �������
			File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File("D:\\screenshot1.jpg"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//������� �� http://devmate.com/features/appmanagement
			driver.findElement(By.xpath(".//a[@class='head-slider-tab on']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//��������� ��� ��������� �� http://devmate.com/features/appmanagement
			driver.getTitle();
			System.out.println("�������� ���������� �� ��������: " + driver.getTitle());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//��������� ����������� �������� (��. ��������)
			driver.findElement(By.xpath(".//div[@class='visual-slider-img on']")).getText();
		//������� �������� ��������, ���������� ��� � �������
			File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot2, new File("D:\\screenshot2.jpg"));
	}
	
	@After public void Quit (){
		driver.quit();
	}
}
