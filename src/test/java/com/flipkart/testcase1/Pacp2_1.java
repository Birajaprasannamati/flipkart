package com.flipkart.testcase1;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*import org.apache.log4j.Logger;*/
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.beust.jcommander.Parameter;
import com.flipkart.browser.Call_browser;
import com.flipkart.generic.Generic;
/*import com.flipkart.logs.logs;*/
import com.flipkat.pagefactory.Page_factory;


public class Pacp2_1 /*extends logs*/{
	
	/*private static final Logger logger=	Logger.getLogger(Pacp2_1.class.getName());*/

	WebDriver driver;
	String data1;
	String data2;
	Page_factory pf;
	Generic g=new Generic();
	ArrayList<String> al;
	ArrayList<String> al1;
	String data;
	Robot r;
	
    @Parameters("sbrowser")
	@BeforeMethod
	public void invoke_url(String sbrowser){
		/*logger.info("browser is opeaning");*/
		driver= Call_browser.setupbrowser(sbrowser);
		/*logger.info("browser opeaned");*/
		/*logger.info("navigating to url");*/
		Call_browser.geturl("https://www.flipkart.com/");
		/*logger.info("url opeaned");*/
		pf=new Page_factory(driver);
		
	}
	@Test()
	public void flipkart_testcases1() throws Throwable {
		try{
			/*logger.info("navigating to close");*/
			pf.clickclose();
			/*logger.info("close to click");*/
		}
		catch(Exception e){
            
			Thread.sleep(2000);
			pf.clickclose();
			System.out.println("handeld");
		}
		
		g.getScreenshots("close");
		/*logger.info("navigating to home and furniture");*/
		pf.gethome_and_homefurniture(driver);
		/*logger.info("clicked home furniture");*/
		/*g.getScreenshots("homefurniture");*/
		Thread.sleep(5000);
		/*logger.info("navigating to lightning");*/
		pf.clicklightining(driver);
		/*logger.info("clicked lightning");*/
		g.getScreenshots("lightning");
		data1= pf.getpigeon(driver);
		Assert.assertEquals(data1,"Pigeon Equino Emergency Lights");
		/*data2=pf.getpigeonrss(driver);
		Assert.assertEquals(data2, "499");*/
		Thread.sleep(8000);
		/*logger.info("navigating to pigeon");*/
		pf.clickpigeon(driver);
	/*	logger.info("clicked on pigeon");*/
		g.getScreenshots("pigeon");
		Thread.sleep(5000);
		Set<String>set= driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		String parentid=itr.next();
		System.out.println(parentid+": parent id");
		String childid=itr.next();
		System.out.println(childid+": child id");
		driver.switchTo().window(childid);
		Thread.sleep(5000);
		/*logger.info("navigating to add to cart");*/
		pf.clickaddtocart(driver);
		/*logger.info("clicked on add to cart");*/
		g.getScreenshots("addtocart");
		Thread.sleep(5000);
		/*logger.info("navigating to continue shopping");*/
		pf.clickcontinueshopping(driver);
		/*logger.info("clicked on continue shopping");*/
		g.getScreenshots("contnueshopping");
		
		Thread.sleep(2000);

	}

	@Test()
	public void teatcase2() throws Exception{

		try{
			pf.clickclose();
		}
		catch(Exception e){
			
            Thread.sleep(2000);
			pf.clickclose();
			System.out.println("handeld");

		}
		g.getScreenshots("close1");
		
		Thread.sleep(5000);
		//expected
		al=g.getcell_data_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx","flipkart", 0);
		System.out.println(al);
		String mobile=al.get(0);
		System.out.println("first data in sheet"+mobile);
		Thread.sleep(2000);
		pf.enterdata_searchfield(mobile);
		g.getScreenshots("searchdata");
		/*r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		g.getScreenshots("searchdatamimobiles1");
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		g.getScreenshots("searchdatamimobiles2");
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		g.getScreenshots("searchdatamimobiles");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		*/
        
		Thread.sleep(5000);
		pf.get_data__from_mobile("redmi mobile");
		g.getScreenshots("Redme mobile");
		Thread.sleep(2000);
		//firstline
		String data=pf.redme5aGetdata();
		Assert.assertEquals(data,"Redmi 5A (Rose Gold, 16 GB)");
		System.out.println(data+"got verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",1, 1,data,0);
		System.out.println("setdata for"+data);
		//Actual
		al1=pf.redme5aGetdetaildata();
		//2nd line
		String row1=al.get(1);
		Assert.assertEquals(al1.get(0),row1);
		System.out.println(row1+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",2, 1,al1.get(0),0);
		System.out.println("setdata for"+row1);
		//3rd line
		String row2=al.get(2);
		Assert.assertEquals(al1.get(1),row2);
		System.out.println(row2+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",3, 1,al1.get(1),0);
		System.out.println("setdata for"+row2);
		//fourth line
		String row3=al.get(3);
		Assert.assertEquals(al1.get(2),row3);
		System.out.println(row3+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",4, 1,al1.get(2),0);
		System.out.println("setdata for"+row3);
		//fifth line
		String row4=al.get(4);
		Assert.assertEquals(al1.get(3),row4);
		System.out.println(row4+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",5, 1,al1.get(3),0);
		System.out.println("setdata for"+row4);
		//sixth line
		String row5=al.get(5);
		Assert.assertEquals(al1.get(4),row5);
		System.out.println(row5+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",6, 1,al1.get(4),0);
		System.out.println("setdata for"+row5);
		//seventh line
		String row6=al.get(6);
		Assert.assertEquals(al1.get(5),row6);
		System.out.println(row6+"is verified");
		g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",7, 1,al1.get(5),0);
		System.out.println("setdata for"+row6);

		/*String price=pf.redme5arsgetdata();
		Assert.assertEquals(price, al.get(7));
		System.out.println(price+"is verified");*/

		pf.redme5aclick();
		g.getScreenshots("clickredme5a");
		
		Thread.sleep(2000);
       
		Set<String>set= driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		String parentid=itr.next();
		System.out.println(parentid+": parent id");
		String childid=itr.next();
		System.out.println(childid+": child id");
		driver.switchTo().window(childid);
      
       
		//Thread.sleep(8000);
		
		Call_browser.driver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		String commingsoon= pf.commingsoonGetdata();
		Assert.assertEquals(commingsoon, "Coming Soon");
		System.out.println(commingsoon+"is verified");
		
		

	}


	@AfterMethod
	public void close() {

		//driver.close();
		/*logger.info("closing the driver");*/
		 Call_browser.closedriver();
		/* logger.info("driver closed");*/
	}


	@AfterTest
	public void closesetup() {

    // Call_browser.closedriver();


	}
}
