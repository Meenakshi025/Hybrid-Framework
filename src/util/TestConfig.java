package util;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import testApps.DriverApp;


public class TestConfig{


	
	
	public static String testSiteURL = "https://www.google.co.in";
	public static String testBrowser = "*firefox";
	//public static String server="172.207.185.112";
	public static String server="smtp.gmail.com";
	public static String from = "meenifsss@gmail.com";
	public static String password = "Meenu@676";
	public static String[] to ={"meenakshi.patil04@gmail.com"};
	public static String subject = "Test Report";
	public static String port="465";
	public static String username="bafd@gmail.com";
	public static String subjectattachment = "Selenium2.0 Database Validation report";
	public static String messageBody ="Level 2 monitoring script has been failed on production. Please check the logs report and attached screenshot for analyzing the root cause." +
			" <br><br><b>Link for this validation</b>"+"<br>"+"http://"+TestUtil.Handeler()+":8282"+"/htmlpages/index"+DriverApp.strDate+".html"+"<p> <b>To search for previous validation results</b><br>http://"+TestUtil.Handeler()+":8282"+"/ReportView.jsp </p>"+"<p> <b>Link to the CPV Guide</b><br></p>"+"<br>"+
	"<b>Thanks,</b><br>QA Automation";
	
		
		
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://172.168.150.127;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$qler!!1"; 
	
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "pasrd";
	public static String mysqlurl = "jdbc:mysql://172.16.150.111/monitor_dm";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/AutomationBvt_Hybrid/Reports.zip";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages/index"+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages/index"+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html";
	//public static String attachmentPath="C:/CMAutomation/tomcat-6.0/webapps/ROOT/screenshots/"+DriverScript.mailscreenshotpath+".jpeg";
	public static String attachmentPath=DriverApp.mailscreenshotpath+".jpeg";
	public static String attachmentName="Error.jpeg";
	//public static String filepath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages";
	
	
	
	
	
	
	
	
}
