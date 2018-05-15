package com.flipkart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class Database_conn {
	
	
	
	public static ArrayList<String []> getDbdatast3(final String query) throws Throwable{
		
		//database comnnection steup
			
	ArrayList<String[]> records=new ArrayList<String[]>();	
	Class.forName("net.sourceforge.jtds.jdbc.Driver");
	Connection	 conn = DriverManager.getConnection("jdbc:sqlserver://IS-SOLUTION:1434;databaseName=Proh_Kyoor_QA","Proh_Kyoor","prohkyoor123");
	Statement smt=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs=smt.executeQuery(query);
	ResultSetMetaData rsmetdata=rs.getMetaData();
	int cols=rsmetdata.getColumnCount();
	
	while(rs.next()){
		
		String[] fields=new String [cols];
		int col=0;
		for(int colxid=1;colxid<=cols;colxid++){
			
			  fields[col]=rs.getString(colxid);
			  
			  col++;
		}
		
		records.add(fields);
	}
		
	rs.close();
	smt.close();
	conn.close();		
	return records;	
	}
	
	
	
	
	

}
