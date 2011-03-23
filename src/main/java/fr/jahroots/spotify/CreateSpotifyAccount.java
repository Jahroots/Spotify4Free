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
 * @author RBO
 * @version 1.0
 */
public class CreateSpotifyAccount {
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_NEW_ID = "password_new";
    private static final String PASSWORD_CHECK_ID = "password_check";
    private static final CharSequence PASSWORD = "azerty";
    private static final String POSTAL_CODE_ID = "postal_code";
    private static final String GENDER_ID = "gender";
    private static final String BIRTHDAY_ID = "birth_day";
    private static final String BIRTHMONTH_ID = "birth_month";
    private static final String BIRTHYEAR_ID = "birth_year";
    private static final String IAGREE_ID = "iagree";
    private static final String EMAIL_ID = "email";


//    private static final String MY_PROXY = "192.168.10.2:8080";


    private WebDriver driver;

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

    public CreateSpotifyAccount() {
    	final FirefoxProfile profile = FFProfile();
        driver = new FirefoxDriver(profile);
    }

    /**
     * Create an account
     * @param username
     * @param email
     * @param codePostal
     */
    public void createAccount(final String username, final String email, final String codePostal){
    	 driver.get("https://www.spotify.com/fr/get-spotify/go/open/#1");

         final WebElement usernameElement = driver.findElement(By.id(USERNAME_ID));
         usernameElement.sendKeys(username);

         final WebElement passwordNewElement = driver.findElement(By.id(PASSWORD_NEW_ID));
         passwordNewElement.sendKeys(PASSWORD);

         final WebElement passwordCheckElement = driver.findElement(By.id(PASSWORD_CHECK_ID));
         passwordCheckElement.sendKeys(PASSWORD);

         final WebElement nextStepElement = driver.findElement(By.xpath("//button[@type='submit']"));
         nextStepElement.click();

         final WebElement emailElement = driver.findElement(By.id(EMAIL_ID));
         emailElement.sendKeys(email);

         final WebElement codePostalElement = driver.findElement(By.id(POSTAL_CODE_ID));
         codePostalElement.sendKeys(codePostal);

         final WebElement genderElement = driver.findElement(By.id(GENDER_ID));
         final List<WebElement> genderElements = genderElement.findElements(By.tagName("option"));
         genderElements.get(2).setSelected();

         final WebElement birthDayElement = driver.findElement(By.id(BIRTHDAY_ID));
         final List<WebElement> bDayElements = birthDayElement.findElements(By.tagName("option"));
         bDayElements.get(1).setSelected();

         final WebElement birthMonthElement = driver.findElement(By.id(BIRTHMONTH_ID));
         final List<WebElement> bDayMonthElements = birthMonthElement.findElements(By.tagName("option"));
         bDayMonthElements.get(3).setSelected();

         final WebElement birthYearElement = driver.findElement(By.id(BIRTHYEAR_ID));
         final List<WebElement> bDayYearhElements = birthYearElement.findElements(By.tagName("option"));
         final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
         final int myAge = currentYear - 1982;
         bDayYearhElements.get(myAge).setSelected();

         final WebElement iagreeElement = driver.findElement(By.id(IAGREE_ID));
         iagreeElement.click();

         final WebElement nextStep2Element = driver.findElement(By.xpath("//div[@id='new_user_step_2_button']/button"));
         nextStep2Element.click();

         driver.findElement(By.id("continue")).click();
    }

    /**
     * Create x accounts
     * @param username
     * @param email
     * @param codePostal
     * @param numberOfAccounts
     */
    public void createXAccounts(final String username, final String email, final String codePostal, final int numberOfAccounts){
    	for (int i = 0; i<numberOfAccounts; i++){
    		createAccount(username + "_" + i, email, codePostal);
    	}
    }

    public static void main(String[] args) {
    	new CreateSpotifyAccount().createAccount("BetaTest_1", "BetaTest_1@beta.fr", "75009");
    }

}
