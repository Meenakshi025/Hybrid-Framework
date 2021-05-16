package testApps;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import datatable.Xlfile_Reader;


import testReports.TestReports;
import util.DbManager;
import util.ErrorCollectors;
import util.TestConfig;
import util.TestUtil;
import util.monitoringMail;





public class KeywordsApp extends DriverApp {
	
	   public static Random randomGenerator = new Random();
	   public static Calendar cal = new GregorianCalendar();  //used for adding current date in variable and then used in paths
	   public static int date = cal.get(Calendar.DATE);  //used for adding current date in variable and then used in paths
	   public static int month = cal.get(Calendar.MONTH);  //used for adding current date in variable and then used in paths
	   public static int year = cal.get(Calendar.YEAR);  //used for adding current date in variable and then used in paths
	   public static int sec =cal.get(Calendar.SECOND);  //used for adding current date in variable and then used in paths
	   public static int day =cal.get(Calendar.HOUR_OF_DAY);  //used for adding current date in variable and then used in paths
	   public static int hour=cal.get(Calendar.HOUR);  //used for adding current date in variable and then used in paths
	   public static int min=cal.get(Calendar.MINUTE);  //used for adding current date in variable and then used in paths
	   public static String sMin = new Integer(randomGenerator.nextInt(60)).toString(); //Converted Integer value to String and then used in paths
	   public static String sSec=new Integer(randomGenerator.nextInt(60)).toString(); //Converted Integer value to String and then used in paths
	   public static String sHour=new Integer(randomGenerator.nextInt(24)).toString();  //Converted Integer value to String and then used in paths
	   public static String sDate=new Integer(date).toString();  //Converted Integer value to String and then used in paths
	   /*public static String sMin = new Integer(min).toString(); //Converted Integer value to String and then used in paths
	   public static String sSec=new Integer(sec).toString(); //Converted Integer value to String and then used in paths
	   public static String sHour=new Integer(hour).toString();  //Converted Integer value to String and then used in paths
	   */
	   
	   public static String call_id ; //Used in GetText() and DBQuerycheck() to store the call id to be used for Eval UI
	   public static String sUser=null;
	   public static String sUser_Name;
	   public static Xlfile_Reader datareader=null;
	   public static Xlfile_Reader datawriter=null;
	   public static float round;
	   public static float round1;

	   public static String script_error=null;
	   public static int globalwait;
	   
	//Navigate to the current URL
	public static String navigate() throws Throwable{
		APPLICATION_LOGS.debug("Executing Navigate");
		try{
			driver.get(CONFIG.getProperty(object));
		}catch(Throwable t){
		
			APPLICATION_LOGS.debug("Error while navigating -"+ object + t.getMessage());		   
		}
		return "Pass";
	}
	
	//Clicking on a link or an Object
	
	public static String clickLink() throws AddressException, MessagingException{
		APPLICATION_LOGS.debug("Executing clickLink");
		try{
		driver.findElement(By.xpath(Objects.getProperty(object))).click();
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
			script_error = "Timed out after "+globalwait+" miliseconds";
			
		   return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	
	public static String click() throws AddressException, MessagingException{
		APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
		
		try{
			
		
			driver.findElement(By.xpath(Objects.getProperty(object))).click();
			
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while searching and clicking -"+ object + t.getMessage());
				
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}

	
	//Input data Keyword
	
		public static String input() throws Exception{
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			String message = "pass";
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			try{
					System.out.println("Input keyword data :"+data);
			   driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
				}catch(Exception t){
					// report error
				APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
					
				script_error = "Timed out after "+globalwait+" miliseconds";
				
				return "Fail - "+t.getMessage();
				
				}
				return "Pass";
		}
		
	public static String softAssertTrue() throws Exception{
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			String message = "pass";
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			
			try{
					System.out.println("Assert keyword data :"+data);
					System.out.println(driver.findElement(By.xpath(Objects.getProperty(object))).getText());
					ErrorCollectors.verifyEquals(driver.findElement(By.xpath(Objects.getProperty(object))).getText(), data);
					System.out.println("Data matches expected was : "+driver.findElement(By.xpath(Objects.getProperty(object))).getText());
				}catch(Exception t){
					// report error
					System.out.println("Inside catch");
					APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
					
					script_error = "Timed out after "+globalwait+" miliseconds";
					
					return "Fail - "+t.getMessage();
								
				}
			
				return "Pass";
		}
	public static String waitfor() throws NumberFormatException, InterruptedException, AddressException, MessagingException{
	     APPLICATION_LOGS.debug("Executing wait Keyword");
	  // extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			try{
				 
				float test = (Float.parseFloat(data));
				int test1 = (int) test;
				Thread.sleep(test1);
				globalwait = test1/1000;
			}catch(Throwable t){
				APPLICATION_LOGS.debug("Error while waiting -"+ object + t.getMessage());
			    return "Fail - "+t.getMessage();
							}
	     return "Pass";
	}
	
		//Verifying text presence 
		
		  public static String verifyText(){
		         APPLICATION_LOGS.debug("Executing verifyText");
		         String expected=APPTEXT.getProperty(object);
		         String actual=driver.findElement(By.xpath(Objects.getProperty(object))).getText();
		         APPLICATION_LOGS.debug(expected);
		         APPLICATION_LOGS.debug(actual);
		         try{
		             Assert.assertEquals(actual.trim() , expected.trim());
		         }catch(Throwable t){
		             // error
		             APPLICATION_LOGS.debug("Error in text - "+object);
		             APPLICATION_LOGS.debug("Actual - "+actual);
		             APPLICATION_LOGS.debug("Expected -"+ expected);
		             return "Fail -"+ t.getMessage();
		            
		         }
		        
		         return "Pass";
		 
	        }
		
		//verifyTextOnThePage
		public void verifyTextOnThePage (String expected) throws InterruptedException{
			final WebDriverException exception =new WebDriverException();
			try{
			if(driver.findElement(By.xpath(Objects.getProperty(object))).getText().contains(expected)){
			System.out.println(expected +" text is on this page");
			}
			else{
			System.out.println(expected +" text is NOT on this page");
			throw new WebDriverException(exception.getMessage());
			}
			
			}
			catch (WebDriverException e) {
			throw new WebDriverException(e.getMessage());
			}
			
		} 
		
		
		public void ElementVerify(String expected) throws InterruptedException{
			final WebDriverException exception =new WebDriverException();
			try{
			if(driver.findElement(By.xpath(Objects.getProperty(object))).getText().contains(expected)){
			System.out.println(expected +" text is on this page");
			}
			else{
			System.out.println(expected +" text is NOT on this page");
			throw new WebDriverException(exception.getMessage());
			}
			
			}
			catch (WebDriverException e) {
			throw new WebDriverException(e.getMessage());
			}
			
		} 
		
		
		public static String clickButton(){
			APPLICATION_LOGS.debug("Executing clickButton Keyword");
			
			
			try{
				driver.findElement(By.xpath(Objects.getProperty(object))).click();
				}catch(Throwable t){
					// report error
					APPLICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				
				return "Pass";
		}
		
		
		public static String select(){
			APPLICATION_LOGS.debug("Executing select Keyword");
			// extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			try{
				driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
				}catch(Throwable t){
					// report error
					APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				
				return "Pass";
		}
		
		public static String typekeys() throws AddressException, MessagingException{
			APPLICATION_LOGS.debug("Executing typekeys() Keyword");
			
			// extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
					
			try{
			
				driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
				
			}catch(Throwable t){
					// report error
					APPLICATION_LOGS.debug("Error while typing data -"+ object + t.getMessage());
			
					return "Fail - "+t.getMessage();
				}
				
				return "Pass";
		}
		public static String Refresh(){
			APPLICATION_LOGS.debug("Executing select Keyword");
			// extract the test data	
			try{
				
				driver.navigate().refresh();
				Thread.sleep(10000);
				
			}catch(Throwable t){
					APPLICATION_LOGS.debug("Error while refreshing -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				return "Pass";
		}
		
		public static String Back(){
			APPLICATION_LOGS.debug("Executing back to the webpage");
			// extract the test data	
			try{
				
				driver.navigate().back();
				Thread.sleep(10000);
				
			}catch(Throwable t){
					APPLICATION_LOGS.debug("Error while going to back -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				return "Pass";
		}
		public static String ElementIsDisplayed(){
			APPLICATION_LOGS.debug("Executing Isdisplayed Keyword");
			// extract the test data	
			try{
				
				driver.findElement(By.xpath(Objects.getProperty(object))).isDisplayed();
				Thread.sleep(10000);
				
			}catch(Throwable t){
					APPLICATION_LOGS.debug("Error while element not displayed -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				return "Pass";
		}
		
		public static String ElementIsPresent(){
			APPLICATION_LOGS.debug("Executing Is Element Present Keyword");
			// extract the test data	
			try{
				
				if(driver.findElement(By.xpath(Objects.getProperty(object))).isDisplayed() == true){
					System.out.println("Element is present on the webpage");
	    	     }
	    		else  {  
	    			System.out.println("Element is not present on the page");
	    		}
			}catch(Throwable t){
					APPLICATION_LOGS.debug("Error while element not displayed -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				return "Pass";
		}
	
		//Getting text from an object and executing it based on the object
		
		public static String GetText() throws AddressException, MessagingException{
			APPLICATION_LOGS.debug("Executing GetText Keyword");
					
			try{
				
				String Text = driver.findElement(By.xpath(Objects.getProperty(object))).getText();
				System.out.println(driver.getTitle()+" text :- "+Text);
				APPLICATION_LOGS.debug("Got the text for:  "+object+"----"+ driver.findElement(By.xpath(Objects.getProperty(object))).getText());

			}catch(Throwable t){
				
					// report error
					APPLICATION_LOGS.debug("Error while fetching text -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				
				return "Pass";
		}
		
		public static String GetLink() throws AddressException, MessagingException{
			APPLICATION_LOGS.debug("Executing GetLink Keyword");
					
			try{
				
				WebElement element = driver.findElement(By.xpath(Objects.getProperty(object)));
				List<WebElement> links = element.findElements(By.tagName("a"));
				System.out.println(" total number of links on webpage = "+links.size());
				for (WebElement link : links) 
				{
					System.out.println(link.getText());
					Thread.sleep(2000);
				}
			
			}catch(Throwable t){
					// report error
					APPLICATION_LOGS.debug("Error while fetching Links -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				
				return "Pass";
		}
		
		public static String GetTitle() throws AddressException, MessagingException{
			APPLICATION_LOGS.debug("Executing the page title Keyword");
					
			try{
			    System.out.println("Page Title:- "+driver.getTitle());
			}catch(Throwable t){    
					// report error
					APPLICATION_LOGS.debug("Error while fetching title -"+ object + t.getMessage());
					return "Fail - "+t.getMessage();
				}
				return "Pass";
			}

}
