package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra
{
	@Test
	public void Myntra() throws InterruptedException
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mango man",Keys.ENTER);
		driver.findElement(By.xpath("//div[@id='desktopSearchResults']/div[2]/descendant::ul[1]/li[7]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='SELECT SIZE ']/../following-sibling::div/descendant::button[2]"))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sizeButtonsContainer']/descendant::p[text()='40']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/descendant::p[text()='40']")).click();
		//By.xpath("//h4[.='SELECT SIZE ']/../following-sibling::div/descendant::button[2]"))).click();
	//	driver.findElement(By.xpath("//h4[.='SELECT SIZE ']/../following-sibling::div/descendant::button[2]")).click();
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='SELECT SIZE ']/../following-sibling::div/descendant::button[2]"))).click();	
	}
	
	
	@Test
	public void myntra1()
	{   
        // Initialize the ChromeDriver
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
        
        // Open the Myntra website
        driver.get("https://www.myntra.com/");
        
        // Find the search bar and enter "mango man"
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
        searchInput.sendKeys("mango man");
        searchInput.sendKeys(Keys.RETURN);
        
        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-base")));
        
        // Click on the first product icon (you can change the index if needed)
        WebElement productIcon = driver.findElements(By.className("product-base")).get(6);
        productIcon.click();
        
        // Wait for the size selection to be visible and select any size (you can change the size index)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("size-buttons-container")));
        WebElement sizeButton = driver.findElements(By.className("size-buttons-container")).get(1);
        sizeButton.click();
        
        // Perform any additional actions you want
        
        // Close the browser when you're done
        driver.quit();
    }
	
	@Test
	public void spicejet() throws Throwable
	{
		int c=0;
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mango man",Keys.ENTER);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		try {
		int a=driver.findElement(By.xpath("//a[@rel='next']")).getLocation().getY();
		System.out.println(a);
		for(int i=0;i<a;i++) {
			Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400);");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		List<WebElement> img=driver.findElements(By.xpath("//img"));
		
		System.out.println(img.size());
	}
	
	@Test// can't do anything
	public void calendar() 
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mango man",Keys.ENTER);
 //       List<WebElement> allImg=driver.findElements(By.xpath("//div[@id='desktopSearchResults']/div[2]/descendant::ul[@class='results-base']/li[@class='product-base']"));
        List<WebElement> allImg=driver.findElements(By.xpath("//div[@id='desktopSearchResults']/div[@class='search-searchProductsContainer row-base']/descendant::ul[@class='results-base']/li[@class='product-base']"));
        System.out.println(allImg.size());
  //      driver.quit();
    }

	@Test
	public void calendar1() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mango man",Keys.ENTER);
//   driver.findElement(By.xpath("//div[@id='desktopSearchResults']/div[@class='search-searchProductsContainer row-base']/descendant::ul[@class='results-base']/li[position()=7]")).click();
//   driver.findElement(By.xpath("(//div[@class='search-searchProductsContainer row-base']//ul[@class='results-base']/li)[position()=7]")).click();)
        driver.findElement(By.xpath("(//div[@class='search-searchProductsContainer row-base']//ul[@class='results-base']/li)[position()=7]")).click();
        
        //*window switching*/
     Thread.sleep(5000);
     String mainId=driver.getWindowHandle();
     Set<String> allId=driver.getWindowHandles();
 
	for(String id:allId)
	{
		if(!(mainId.equals(allId)))
		{
			driver.switchTo().window(id);
		}
	}
    driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[@class='size-buttons-size-buttons']/descendant::p[position()=4]")).click();
    driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
    driver.findElement(By.xpath("//span[text()='Bag']/..")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//a[@class='desktop-cart']")).click();
	}
	
	@Test// robot class keyboard handling
	public void upload() throws AWTException, InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		WebElement user=driver.findElement(By.name("q"));
		Actions act=new Actions(driver);
		act.keyDown(Keys.SHIFT).sendKeys(user,"cricket").perform();
		act.keyUp(Keys.SHIFT).sendKeys(user,"cricket").perform();
		act.keyDown(Keys.CONTROL).sendKeys("a").perform();
	}
}








	