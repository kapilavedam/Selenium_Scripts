package AmazonPackage;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
public class AmazonClass {

    public static void main(String[] args) {
    	
    	try {
        // declaration and instantiation of objects/variables
    	WebDriver driver ;

    	System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
    	driver = new FirefoxDriver();
        String baseUrl = "https://www.amazon.com/";
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = "";
    //    String expectedSortedText = "Showing most relevant results sorted by Price: High to Low.See all sorted results.";
                
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        //driver.manage().window().maximize();

        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        
        /*
         * compare the actual title of the page with the expected one and prin
         * the result as "TitleMatched!" or "TitleDifferentThanExpected"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("TitleMatched!");
        } else {
            System.out.println("TitleDifferentThanExpected");
        }
        
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
        System.out.println("After enterd Nikon value");
        
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("After Clicked on search button ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select SortBy = new Select(driver.findElement(By.id("sort")));
        //SortBy.deselectAll();
        System.out.println("After click sort  ");
       //SortBy.selectByIndex(3);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       SortBy.selectByVisibleText("Price: High to Low");
        
        System.out.println("After 3rd is selected  ");
        
       //WebElement textSorted= driver.findElement(By.xpath("//div[@id='centerPlus']/h3"));
        
      //  String actualTextSorted = textSorted.getText();        
        
      //  System.out.println(actualTextSorted);
        
        /*
         * compare whether this is the correct page or not and print
         * the result as "CorrectPage" or "NotCorrectPage"
         */  
/*        if(actualTextSorted.contentEquals(expectedSortedText)){
        	System.out.println("CorrectPage");
        } else {
        	System.out.println("NotCorrectPage");
        }   */
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        System.out.println("window Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10);
        
        WebElement elem = driver.findElement(By.xpath("//li[@id ='result_1']//h2"));
        
        Thread.sleep(20);
        
        System.out.println("Web element Object is initiated, need to click ");
        try {
        elem.click();} catch (Exception ex){ System.out.println("In Eliment click exception block");}
        
        System.out.println("Web element Object is initiated, and clicked");
        
        Thread.sleep(20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Web element show more Object before declaration ");
        try {
        WebElement showMore = driver.findElement(By.xpath("//div[@id='feature-bullets']//span[@class='a-expander-prompt']"));
        Thread.sleep(20);
        System.out.println("Web element show more Object after declaration ");       
        showMore.click();
        }catch (Exception ey){System.out.println("In showMore object declarion failure ");}
        
        System.out.println("Web element show more Object is initiated, need to click ");
        

        
        System.out.println("Web element Show more Object is initiated, and clicked");
                      
        System.out.println("clicked on Show mor");
        
        String foo = driver.findElement(By.xpath("//div[@id='feature-bullets']")).getText();
        
       // System.out.println(foo);
        
        String expectedSearchedText = "Nokia D3X";

        try {
        assertTrue("Verification failed: Element1 and Element2 are not same." , foo.contains(expectedSearchedText));
        }catch (Exception ez){System.out.println("AssertExceptionFailure");}
        
        System.out.println("Able to find search text");
        
       // driver.FindElement(By.LinkText("Google")).Click();
        
        //assertTrue(strng.contains(“Search”));

        //close Fire fox
      // driver.close();
       
        // exit the program explicitly
        System.exit(0);
    }
    	catch (Exception e) {
        	System.out.println("I'm out of try-catch block in Java.");
        }
    }
    
    

}

