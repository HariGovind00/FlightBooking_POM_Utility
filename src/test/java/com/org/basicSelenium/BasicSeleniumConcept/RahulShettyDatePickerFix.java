/**
 * 
 */
package com.org.basicSelenium.BasicSeleniumConcept;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RahulShettyDatePickerFix {
    public static void main(String[] args) {
        // --- Setup (change path or use WebDriverManager if preferred) ---
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

            // Open datepicker
            WebElement dateInput = driver.findElement(By.id("ctl00_mainContent_view_date1"));
            dateInput.click();

            // Target date
            String targetMonth = "April";
            String targetYear  = "2020";
            String targetDay   = "20";

            // Wait for the datepicker to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datepicker")));

            // Safety max attempts to avoid infinite loops
            int maxTries = 60;
            int tries = 0;
            boolean monthFound = false;

            while (tries < maxTries) {
                tries++;

                // Read displayed month and year from the calendar (first calendar)
                String displayedMonth = driver.findElement(By.cssSelector(".ui-datepicker .ui-datepicker-month")).getText();
                String displayedYear  = driver.findElement(By.cssSelector(".ui-datepicker .ui-datepicker-year")).getText();

                if (displayedMonth.equalsIgnoreCase(targetMonth) && displayedYear.equals(targetYear)) {
                    monthFound = true;
                    break;
                } else {
                    // Try clicking the Next button (use the jQuery UI next class)
                    try {
                        WebElement next = driver.findElement(By.cssSelector(".ui-datepicker-next"));
                        next.click();
                    } catch (Exception e) {
                        // Fallback selector if it differs on the page
                        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                    }
                    // small wait after clicking next for calendar to update
                    Thread.sleep(300);
                }
            }

            if (!monthFound) {
                throw new RuntimeException("Could not navigate to " + targetMonth + " " + targetYear + " after " + maxTries + " attempts.");
            }

            // Now select the day from the visible calendar table
            List<WebElement> days = driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a"));
            boolean dayClicked = false;
            for (WebElement d : days) {
                if (d.getText().equals(targetDay)) {
                    d.click();
                    dayClicked = true;
                    break;
                }
            }

            if (!dayClicked) {
                throw new RuntimeException("Day " + targetDay + " not found in the visible calendar for " + targetMonth + " " + targetYear);
            }

            System.out.println("Selected date: " + targetDay + " " + targetMonth + " " + targetYear);

            // (Continue other automation steps as needed...)

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // cleanup (comment out if you want browser to remain open while debugging)
            driver.quit();
        }
    }
}
