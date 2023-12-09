package DMSApplication.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Objectcode {
	public static WebDriver driver;
	
    public static void Browserlaunch(String Browser) {
        if (Browser.equalsIgnoreCase("Chrome") == true || Browser.equalsIgnoreCase("") == true) {
        	System.setProperty("webdriver.chrome.driver", "Drivers\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome browser Launched");
        } else if (Browser.equalsIgnoreCase("Firefox") == true) {
            System.setProperty("webdriver.firefox.driver", "Drivers\\gekodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("Firefox browser Launched");
        } else if (Browser.equalsIgnoreCase("Edge") == true) {
            System.setProperty("webdriver.Edge.driver", "Drivers\\msedgedriver\\msedgedriver.exe");
            driver = new EdgeDriver();
            System.out.println("Edge browser Launched");
        }
    }
    
    public static void URLlaunch(String url) {
        // closing the browser
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(url + "is Launched successfully");
    }
    

    public static void webDriverWait(String locatortype, String locator, long timeDuration) { 
    	if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.id(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.name(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.cssSelector(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.xpath(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.className(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement for the field you want to wait for
            WebElement field = driver.findElement(By.linkText(locator));
            // Create a WebDriverWait instance with a timeout
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
            // Wait until the field is visible
            wait1.until(ExpectedConditions.visibilityOf(field));
        }
    }

    public static void InputField(String locatortype, String locator, String value) {
        if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.id(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.name(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.cssSelector(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.xpath(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.className(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement
            WebElement Field = driver.findElement(By.linkText(locator));
            Field.clear();
            // Pass the value into the field
            Field.sendKeys(value);
        }
    }

    public static void ButtonClick(String locatortype, String locator) {
        if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.id(locator));
            // Click on the button
            button.click();
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.name(locator));
            // Click on the button
            button.click();
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.cssSelector(locator));
            // Click on the button
            button.click();
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.xpath(locator));
            // Click on the button
            button.click();
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.className(locator));
            // Click on the button
            button.click();
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement
            WebElement button = driver.findElement(By.linkText(locator));
            // Click on the button
            button.click();
        }
    }

    public static void closebrowser() {
        // closing the browser
        driver.quit();
    }

    public static void Selectdropdownvalue(String locatortype, String locator, CharSequence[] i) {
        if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.id(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.name(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.cssSelector(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.xpath(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.className(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement
            WebElement Dropdownbox = driver.findElement(By.linkText(locator));
            // Select the value in dropdown
            Dropdownbox.clear();
            Dropdownbox.sendKeys(i);
            Dropdownbox.sendKeys(Keys.TAB);
        }
    }

    public static void Checkbox(String locatortype, String locator) {
        if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.id(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.name(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.cssSelector(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.xpath(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.className(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement
            WebElement Checkbox = driver.findElement(By.linkText(locator));
            // Select the checkbox
            Boolean bool1 = Checkbox.isDisplayed();
            if (bool1 == true) {
                Checkbox.click();
            }
        }
    }

    public static void Togglebutton(String locatortype, String locator) {
        if (locatortype.equalsIgnoreCase("id") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.id(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
        if (locatortype.equalsIgnoreCase("name") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.name(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
        if (locatortype.equalsIgnoreCase("CSSselector") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.cssSelector(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
        if (locatortype.equalsIgnoreCase("Xpath") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.xpath(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
        if (locatortype.equalsIgnoreCase("Class") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.className(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
        if (locatortype.equalsIgnoreCase("LinkText") == true) {
            // Find the WebElement
            WebElement togglebutton = driver.findElement(By.linkText(locator));
            // Click on the togglebutton
            togglebutton.click();
        }
    }

    public void ResetKendoDropdown(String locatortype, String locator, String value) {
        WebElement kendoElement = driver.findElement(By.id(locator));
        kendoElement.click();
        WebElement options = kendoElement.findElement(By.linkText(value));
        options.click();
    }
	
}
