package fr.jahroots.spotify;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Create a free Spotify Account
 *
 * @author rbondel
 * @version 1.0
 */
public class CreateSpotifyAccount {
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_NEW_ID = "password_new";
    private static final String PASSWORD_CHECK_ID = "password_check";
    private static final CharSequence PASSWORD = "azerty";
//    private static final String MY_PROXY = "192.168.10.2:8080";

    /**
     * Method Main
     * @param args
     */
    public static final FirefoxProfile FFProfile(){
        FirefoxProfile profile = new FirefoxProfile();
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy(MY_PROXY);
//        proxy.setSslProxy(MY_PROXY);
//        proxy.setNoProxy("localhost, 127.0.0.1");
//        profile.setProxyPreferences(proxy );
        return profile;
    }

    public static void main(String[] args) {
        FirefoxProfile profile = FFProfile();
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("https://www.spotify.com/fr/get-spotify/go/open/#1");
        final String username = "Ruddy972_3";
        final String email    = username + "@gmail.com";
        final String codePostal = "92400";

        final WebElement usernameElement = driver.findElement(By.id(USERNAME_ID));
        usernameElement.sendKeys(username);

        final WebElement passwordNewElement = driver.findElement(By.id(PASSWORD_NEW_ID));
        passwordNewElement.sendKeys(PASSWORD);

        final WebElement passwordCheckElement = driver.findElement(By.id(PASSWORD_CHECK_ID));
        passwordCheckElement.sendKeys(PASSWORD);

        final WebElement nextStepElement = driver.findElement(By.xpath("//button[@type='submit']"));
        nextStepElement.click();

        final WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);

        final WebElement codePostalElement = driver.findElement(By.id("postal_code"));
        codePostalElement.sendKeys(codePostal);

        final WebElement genderElement = driver.findElement(By.id("gender"));
        final List<WebElement> genderElements = genderElement.findElements(By.tagName("option"));
        genderElements.get(2).setSelected();

        final WebElement birthDayElement = driver.findElement(By.id("birth_day"));
        final List<WebElement> bDayElements = birthDayElement.findElements(By.tagName("option"));
        bDayElements.get(1).setSelected();

        final WebElement birthMonthElement = driver.findElement(By.id("birth_month"));
        final List<WebElement> bDayMonthElements = birthMonthElement.findElements(By.tagName("option"));
        bDayMonthElements.get(3).setSelected();

        final WebElement birthYearElement = driver.findElement(By.id("birth_year"));
        final List<WebElement> bDayYearhElements = birthYearElement.findElements(By.tagName("option"));
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        final int myAge = currentYear - 1982;
        bDayYearhElements.get(myAge).setSelected();

        final WebElement iagreeElement = driver.findElement(By.id("iagree"));
        iagreeElement.click();

        final WebElement nextStep2Element = driver.findElement(By.xpath("//div[@id='new_user_step_2_button']/button"));
        nextStep2Element.click();

        driver.findElement(By.id("continue")).click();
    }

}
