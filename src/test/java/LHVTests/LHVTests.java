package LHVTests;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class LHVTests {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void getPageProperties() throws MalformedURLException {
        driver.get("https://www.lhv.ee/et/liising#kalkulaator");
        assertEquals("https://www.lhv.ee/et/liising#kalkulaator", driver.getCurrentUrl());
        assertEquals("Liising · LHV", driver.getTitle());
    }


    @Test
    public void compareTest() {
        driver.get("https://www.lhv.ee/et/liising#kalkulaator");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();

        WebElement price=driver.findElement(By.name("price"));
        WebElement initial_percentage=driver.findElement(By.name("initial_percentage"));
        WebElement initial=driver.findElement(By.name("initial"));
        price.clear();
        price.sendKeys("7500");
        initial_percentage.clear();
        initial_percentage.sendKeys("10");

        System.out.println(initial.getAttribute("value"));

        if(initial.getAttribute("value").equals("750"))
        {
            System.out.println("Õige väärtus");
        }
        else
        {
            System.out.println("Vale väärtus");
        }
    }


}
