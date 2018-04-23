package com.flipkart.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;



import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.flipkart.browser.Call_browser;

public class Generic {

	WebDriver driver;

	public void setdata_excel(String path,int row,int cell,String data,int sheet) throws InvalidFormatException, IOException{


		FileInputStream fis=new FileInputStream(path);

		Workbook wb=WorkbookFactory.create(fis);

		Sheet sh=wb.getSheetAt(sheet);

		sh.getRow(row).createCell(cell).setCellValue(data);

		System.out.println("data got set");
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		fos.flush();
		fos.close();

	}

	public ArrayList<String> getcell_data_excel(String path,String sheet,int col) throws Exception{

		ArrayList<String> al=new ArrayList<String>();


		FileInputStream fis=new FileInputStream(path);

		Workbook wb=WorkbookFactory.create(fis);

		Sheet sh=wb.getSheet(sheet);

		Iterator <Row> it=sh.iterator();

		it.next();
		while(it.hasNext()){


			al.add(it.next().getCell(col).getStringCellValue());

		}

		return al;




	}


	public static void main(String[] args) throws Exception {

		ArrayList<String>a;
		Generic g=new Generic();

		//a=g.getcell_data_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx","flipkart", 0);
	//System.out.println(a.get(0));

     // g.setdata_excel("E:\\Selenium\\Flipkart\\src\\test\\resources\\flipkart.xlsx",1, 1,"buna",0);

		//g.getScreenshots("buna");

	}


	public void getScreenshots(String screenshotname) throws IOException{

		DateFormat dateformat=new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal=Calendar.getInstance();
		String datetime=dateformat.format(cal.getTime());
		String name_and_time=screenshotname+datetime;

		File scrFile = ((TakesScreenshot)Call_browser.driver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\Selenium\\Flipkart\\target"+"\\"+"Screenshot_"+name_and_time+".png"));



	}









}
