package com.bmi.commontest;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;



public class ReadPropertyFile {
	public Properties prop=null;
	public File file=null;
	public FileInputStream fis=null;
	
	public ReadPropertyFile() throws Exception
	{
		prop=new Properties();
		file=new File("./src/test/resources/properties/config.properties");
		fis=new FileInputStream(file);
		
	}
	
	public String getUsername() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("username");
		
	}
	
	public String getPassword() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("password");
		
	}
	
	public String getUrl() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("url");
		
	}
	
	public String getArea() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("area");
		
	}
	
	public String getDivision() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("division");
		
	}
	
	public String getInfoProDivisionAccount() throws Exception
	{
		prop.load(fis);
		return prop.getProperty("infoproDivisionAccount");
		
	}
	
}
