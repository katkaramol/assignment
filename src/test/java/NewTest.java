import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	
	
  @Test()
  public void createLogin() throws MalformedURLException, InterruptedException  {
	    System.setProperty("webdriver.chrome.driver", "D://Automationfiles//Chromedriver//chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click(); 
		Random email = new Random();
		int randomno = email.nextInt(10000);
		driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys("Test"+randomno+"@gmail.com");
		driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='id_gender1']")).click();
	
		driver.findElement(By.xpath(".//*[@id='customer_firstname']")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='customer_lastname']")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("Tester123");
		driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='address1']")).sendKeys("Road123");
		driver.findElement(By.xpath(".//*[@id='city']")).sendKeys("London");
		WebElement stateddl= driver.findElement(By.xpath(".//*[@id='id_state']"));
		
		Select state =new Select(stateddl);
		state.selectByVisibleText("Alaska");
		driver.findElement(By.xpath(".//*[@id='postcode']")).sendKeys("56478");
		driver.findElement(By.xpath(".//*[@id='phone_mobile']")).sendKeys("78962357");
		driver.findElement(By.xpath(".//*[@id='alias']")).sendKeys("Testadd2");
		driver.findElement(By.xpath(".//*[@id='submitAccount']")).click();
		driver.close();
		
		
			}
  
  @Test ()
  public void transactionSignin() throws MalformedURLException, InterruptedException  {
	    System.setProperty("webdriver.chrome.driver", "D://Automationfiles//Chromedriver//chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click(); 
	    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("amoltest@gmail.com");
	    driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("Tester123");
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
		WebElement womenlinlk=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
		womenlinlk.click();
		WebElement product =driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"));
		product.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement quantity = driver.findElement(By.xpath(".//*[@id='quantity_wanted']"));
		quantity.clear();
		quantity.sendKeys("2");
		WebElement addtocardbtn=driver.findElement(By.xpath(".//*[@id='add_to_cart']/button"));
		addtocardbtn.click();
		WebElement productprice= driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[1]/span"));
		String getproductprice=productprice.getText().substring(1);
		float price1= Float.parseFloat(getproductprice);
		
		WebElement shipping = driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[2]/span"));
		String shippingcharges= shipping.getText().substring(1);
		float price2=Float.parseFloat(shippingcharges);
		
		WebElement total= driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[3]/span"));
		String totalprice =total.getText().substring(1);
		float price3=Float.parseFloat(totalprice);
		
		float addingPrice= price1+price2;
		
		System.out.println("addition:"+addingPrice);
		System.out.println("total:"+price3);
		
		assertEquals(price3, addingPrice, "Price is not correct after adding shipping charges");
		
		Thread.sleep(3000);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement payment =driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
		wait2.until(ExpectedConditions.elementToBeClickable(payment));
		payment.click();
		WebElement totalPrice= driver.findElement(By.xpath(".//*[@id='total_price']"));
		String totalamount=totalPrice.getText();
		WebElement checkout =driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span"));
		checkout.click();
		WebElement proceedcheckout =driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button"));
		proceedcheckout.click();
		WebElement iagreeckbx =driver.findElement(By.xpath(".//*[@id='cgv']"));
		iagreeckbx.click();
		WebElement proceedlastcheckout =driver.findElement(By.xpath(".//*[@id='form']/p/button"));
		proceedlastcheckout.click();	
		WebElement payment1 = driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
		payment1.click();
		WebElement confirmorderbtn =driver.findElement(By.xpath(".//*[@id='cart_navigation']/button"));
		confirmorderbtn.click();
		WebElement orderconfirmation =driver.findElement(By.xpath(".//*[@id='center_column']/p/a"));
		orderconfirmation.click();
		WebElement totalpriceonorderhistroy =driver.findElement(By.xpath(".//*[@id='order-list']/tbody/tr[1]/td[3]"));
		String priceorderhistorypage= totalpriceonorderhistroy.getText();
		System.out.println("Order page amount:"+priceorderhistorypage);
		System.out.println("Total amount:"+totalamount);
		assertEquals(totalamount, priceorderhistorypage, "Price not same in order history page");
		driver.close();
  }
}
