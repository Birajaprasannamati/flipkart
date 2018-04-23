package com.flipkat.pagefactory;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.browser.Call_browser;


public class Page_factory {


	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) Call_browser.driver();
	String data;

	public Page_factory(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public WebElement close;

	@FindBy(xpath="//a[@title='Home & Furniture']/span")
	public WebElement home_and_homefurniture;

	@FindBy(xpath="//a[@title='Lighting']/span[1]")
	public WebElement lighting;

	@FindBy(xpath="//a[text()='Pigeon Equino Emergency Lights']")
	public WebElement pigeon_illume_light;


	@FindBy(xpath="//div[a[text()='Pigeon RADIANCE Emergency Lights']]/div/div/div[1]")
	public WebElement pigeon_illume_light_rrs;


	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	public WebElement _Addtocart;

	@FindBy(xpath="//span[text()='Continue shopping']")
	public WebElement continueshopping;

	// webelement for 2nd testcase
	@FindBy(name="q")
	public WebElement search;
	
	@FindBy(name=".//*[@id='container']/div/header/div[1]/div/div/div/div[1]/form/ul")
	public WebElement search_mobiles_data;

	@FindBy(xpath="//div[text()='Redmi 5A (Rose Gold, 16 GB)']")
	public WebElement redmi5a;

	//div[div[div[text()='Redmi 5A (Rose Gold, 16 GB)']]]//div[4]
	@FindBy(xpath="//div[div[div[text()='Redmi 5A (Rose Gold, 16 GB)']]]//div[4]")
	public WebElement redme5adata;

	//div[text()='₹5,999']

	@FindBy(xpath="//div[text()='?5,999']")
	public WebElement redme5aprice;

	//div[text()='Coming Soon']
	@FindBy(xpath="//div[@class='_3xgqrA']")
	public WebElement commingsoon;

	public void gethome_and_homefurniture(WebDriver driver){
        try{
		Actions act=new Actions(Call_browser.driver());

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", home_and_homefurniture);

		act.moveToElement(home_and_homefurniture).click(home_and_homefurniture).build().perform();
        }
        catch(Exception e){
        	
        	Actions act=new Actions(Call_browser.driver());

    		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", home_and_homefurniture);

    		act.moveToElement(home_and_homefurniture).click(home_and_homefurniture).build().perform();
        }
	}

	public void clicklightining(WebDriver driver){

		Actions act=new Actions(driver);

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", lighting);
		act.moveToElement(lighting).click(lighting).build().perform();

	}

	public void clickpigeon(WebDriver driver) throws InterruptedException{


		/*WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(pigeon_illume_light));*/
		driver.navigate().refresh(); 
		Thread.sleep(2000);
		try{


			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", pigeon_illume_light);
			js.executeScript("arguments[0].scrollIntoView(true);",pigeon_illume_light);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pigeon_illume_light);
		}
		catch(Exception e){

			Thread.sleep(2000);

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", pigeon_illume_light);
			js.executeScript("arguments[0].scrollIntoView(true);",pigeon_illume_light);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pigeon_illume_light);


		}

	}

	public String getpigeon(WebDriver driver) throws Exception{
try{
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", pigeon_illume_light);
		act.moveToElement(pigeon_illume_light).build().perform();
		String data;
		data=pigeon_illume_light.getText();
		System.out.println(data);
		return data;
}
catch(Exception e){
	Thread.sleep(5000);
	Actions act=new Actions(driver);
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", pigeon_illume_light);
	act.moveToElement(pigeon_illume_light).build().perform();
	String data;
	data=pigeon_illume_light.getText();
	System.out.println(data);
	return data;
	
}


	}


	public String getpigeonrss(WebDriver driver){

		Actions act=new Actions(driver);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", pigeon_illume_light_rrs);
		act.moveToElement(pigeon_illume_light_rrs).build().perform();
		String data;
		data=pigeon_illume_light_rrs.getText();
		String data1=charRemoveAt(data, 0);
		System.out.println(data1);
		return data1;

	}

	public static String charRemoveAt(String str, int p) {  
		return str.substring(0, p) + str.substring(p + 1);  
	}  

	public void clickaddtocart(WebDriver driver){

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", _Addtocart);
		Actions act=new Actions(driver);
		act.moveToElement(_Addtocart).click(_Addtocart).build().perform();

	}	

	public void clickcontinueshopping(WebDriver driver){


		Actions act=new Actions(driver);
		act.moveToElement(continueshopping).build().perform();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", continueshopping);
		continueshopping.click();
	}	
	public void clickclose() throws Exception{
		
        try{
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", close);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(close).click(close).build().perform();
        }
        catch(Exception e){
        	
        	Call_browser.driver().navigate().refresh();
        	Thread.sleep(5000);
        	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", close);
    		Actions act=new Actions(Call_browser.driver());
    		act.moveToElement(close).click(close).build().perform();
        	
        }


	}	

	//methods for second testcase


	public void enterdata_searchfield(String data){

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",search);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(search).build().perform();
		search.sendKeys(data);

	}


	public void redme5aclick() throws InterruptedException{
        try{
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",redmi5a);
		js.executeScript("arguments[0].scrollIntoView(true);",redmi5a);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",redmi5a);
        }
        catch(Exception e){
        	Thread.sleep(2000);
    		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",redmi5a);
    		js.executeScript("arguments[0].scrollIntoView(true);",redmi5a);
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();",redmi5a);
        }

	}

	public String redme5aGetdata() throws Exception{
        
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",redmi5a);
		js.executeScript("arguments[0].scrollIntoView(true);",redmi5a);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(redmi5a).build().perform();
		data=redmi5a.getText();
		return data;

	}

	public ArrayList<String> redme5aGetdetaildata(){
		ArrayList<String>al=new ArrayList<String>();

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",redme5adata);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(redme5adata).build().perform();
		List<WebElement> lst =driver.findElements(By.xpath("//div[div[div[text()='Redmi 5A (Rose Gold, 16 GB)']]]//div[4]/ul/li"));
		System.out.println("The no of webelement are"+lst.size());
		for(int i=0;i<lst.size();i++ ){

			data=lst.get(i).getText();
			al.add(data);
		}
		return al ;
	}


	public String redme5arsgetdata() throws InterruptedException{
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",redme5aprice);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(redme5aprice).build().perform();
		data=redme5aprice.getText();

		return data;

	}	

	public String commingsoonGetdata() throws Exception{
         try{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",commingsoon);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",commingsoon);
		Actions act=new Actions(Call_browser.driver());
		act.moveToElement(commingsoon).build().perform();
		data=commingsoon.getText();

		return data;
         }
         catch(Exception e){
        	 
        	 Thread.sleep(2000);
     		js.executeScript("arguments[0].scrollIntoView(true);",commingsoon);
     		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",commingsoon);
     		Actions act=new Actions(Call_browser.driver());
     		act.moveToElement(commingsoon).build().perform();
     		data=commingsoon.getText();

     		return data; 
         }


	}
	
	public void get_data__from_mobile(String expectedata){
	
		WebElement ele=Call_browser.driver().findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div/div/div[1]/form/ul"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",ele);
		String data=ele.getText();
	     System.out.println("The data are in search box : "+data);
	     String [] s=data.split("\n");
	     System.out.println(s.length);
	    // System.out.println(s.toString());
	     
	     for(int i=0;i<s.length;i++){
	    	 
	    	if(s[i].equalsIgnoreCase(expectedata)) {
	    		
	    		js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid green;');",search);
	    		search.clear();
	    		search.sendKeys(s[i]);
	    		search.sendKeys(Keys.ENTER);
	    	}
	    	else{
	    		
	    		System.out.println("the "+expectedata+" is not present");
	    	}
	    	 
	     }
			
			
		
	}

} 
