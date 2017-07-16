package com.bmi.rough;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SampleEmail {
	
	public static void main(String[] args) throws Exception{
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("manaspradhan.kumar@gmail.com", "devyani@123"));
		email.setSSLOnConnect(true);
		email.setFrom("manaspradhan.kumar@gmail.com");
		email.setSubject("SeleniumTestMail");
		email.setMsg("This is a test mail generated from selenium");
		email.addTo("manaspradhan.kumar@yahoo.com");
		email.send();
	}

}
