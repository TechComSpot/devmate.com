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
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Tests {
	private WebDriver driver;

	@Before public void Discovery () {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Открыть страницу http://devmate.com
		driver.get("http://devmate.com");
		
	}
	
	@Test public void FirstScenario () throws Exception
	{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Кликнуть на кнопку Sign Up Now
			driver.findElement(By.xpath("/html/body/header/div/nav/a[5]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//На странице http://devmate.com/signup отметить чекбокс I'm selling or considering selling outside the Mac App Store.
			driver.findElement(By.xpath("//*[@id='form-signup']/div/label[2]/input")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Проверить появление формы solution
			driver.findElement(By.xpath("//*[@id='form-signup']/input[5]")).getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Проверка появления формы solution: " +driver.findElement(By.xpath("//*[@id='form-signup']/input[5]")).getText());
				
	}
	
	@Test public void SecondScenario () throws Exception
	{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Кликнуть на FEATURES
			driver.findElement(By.xpath("/html/body/header/div/nav/a[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.getTitle();
		//Проверить что находимся на http://devmate.com/features/frameworks
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div/img")).getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Проверить отображение элемента (см. скриншот)
			System.out.println("Проверка Отображения элемента: " +driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div/img")).getText());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Сделать скриншот страницы, прикрепить его к репорту
			File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File("D:\\screenshot1.jpg"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Перейти на http://devmate.com/features/appmanagement
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/a[2]/span[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Проверить что находимся на http://devmate.com/features/appmanagement
			driver.getTitle();
			System.out.println("Проверка нахождения на странице: " + driver.getTitle());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Проверить отображение элемента (см. скриншот)
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[1]/div/div/div/div/div/img")).getText();
		//Сделать скриншот страницы, прикрепить его к репорту
			File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot2, new File("D:\\screenshot2.jpg"));
	}
	
	@After public void Quit (){
		driver.quit();
	}
}
