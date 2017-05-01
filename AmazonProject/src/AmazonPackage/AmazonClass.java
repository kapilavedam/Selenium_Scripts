package AmazonPackage;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonClass {

    public static void main(String[] args) {
    	
    	try {
        // declaration and instantiation of objects/variables
    	String UsrInput;
    	String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = "";
        String expectedSortedText = "Showing most relevant results sorted by Price: High to Low.See all sorted results.";
        
    	WebDriver driver ;
    	System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	
    	// https://amazon.com is entered by the user
    	
    	UsrInput =JOptionPane.showInputDialog("Enter Input");
    	driver.switchTo().defaultContent();
    	    	
       	OpeningWebPage(driver, UsrInput);
    	         
    
       	// get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "TitleMatched!" or "TitleDifferentThanExpected"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("TitleMatched!");
        } else {
            System.out.println("TitleDifferentThanExpected");
        }
        
        //Enter Nikon in the search text box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
               
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("After Nikon is entered and clicked on search button ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //Sorting the results by Price:High to Low
        Select SortBy = new Select(driver.findElement(By.id("sort")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SortBy.selectByVisibleText("Price: High to Low");
        
        System.out.println("Sorted as Price:High to Low");
        
       WebElement textSorted= driver.findElement(By.xpath("//div[@id='centerPlus']/h3"));
        
       String actualTextSorted = textSorted.getText();        
        
       System.out.println(actualTextSorted);
        
        /*
         * compare whether this is the correct page or not and print
         * the result as "CorrectPage" or "NotCorrectPage"
         */  
        if(actualTextSorted.contentEquals(expectedSortedText)){
        	System.out.println("CorrectPage");
        } else {
        	System.out.println("NotCorrectPage");
        }   
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
         
        // selecting the second item in the results 
        WebElement elem = driver.findElement(By.xpath("//li[@id ='result_1']//h2"));
        elem.click();
        
        // Clicked on Show more to have whole details        
        
        WebElement showMore = driver.findElement(By.xpath("//div[@id='feature-bullets']//span[@class='a-expander-prompt']"));
        showMore.click();
        System.out.println("clicked on Show mor");
        
        //getting the whole details in a string
        String actualdetails = driver.findElement(By.xpath("//div[@id='feature-bullets']")).getText();
        
       // System.out.println(foo);
        
        String expectedSearchedText = "Nokia D3X";
        // Verifying Nokia D3X text in the captured details
        try {
        assertTrue("Verification failed: actual text doesnt contain Nokia D3X." , actualdetails.contains(expectedSearchedText));
        }catch (Exception ez){System.out.println("AssertExceptionFailure");}
        
        System.out.println("Able to find search text");
        
      
        //close Fire fox
       driver.close();
       
        // exit the program explicitly
        System.exit(0);
    }
    	catch (Exception e) {
        	System.out.println("I'm out of try-catch block in Java.");
        }
    

    }

	public static void OpeningWebPage(WebDriver drv, String baseurl)
	{
		drv.get(baseurl);
	}
    
  		
}
    
    



