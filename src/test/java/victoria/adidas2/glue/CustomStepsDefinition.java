package victoria.adidas2.glue;

import com.privalia.qa.specs.*;
import com.privalia.qa.utils.ThreadProperty;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.*;

/**
 * Glue code of your applications. Use this class to create your own
 * step definitions or cucumber hooks. For more info check:
 * https://cucumber.io/docs/cucumber/step-definitions/
 * https://cucumber.io/docs/cucumber/api/#hooks
 *
 * For more info on how to create your own steps, you can check:
 * https://github.com/veepee-oss/gingerspec/wiki/Creating-your-own-steps
 */
public class CustomStepsDefinition extends BaseGSpec {

    SeleniumGSpec seleniumGSpec;
    RestSpec restSpec;

    /**
     * Example of how to inherit the needed objects from GingerSpec.
     * @param spec the CommonGSpec class
     */
    public CustomStepsDefinition(CommonG spec) {

        this.commonspec = spec;

        /* Access all functions for working with selenium */
        seleniumGSpec = new SeleniumGSpec(this.commonspec);

        /* Access all functions for working with REST services */
        restSpec = new RestSpec(this.commonspec);
    }


    /**
     * This function allows user to accept pop-up's that appears in browser
     *
     */
    @Given("^I accept pop-up$")
    public void acceptPopUp() {
        /* Get access to the selenium driver instance like this */
        WebDriver driver = this.commonspec.getDriver();

        /* Accept pop-up by ENTER key */
        Alert okAlert = driver.switchTo().alert();
        okAlert.accept();
    }


    /**
     * This function allows user to accept pop-up's that appears in browser
     *
     */
    @Given("^I fill form with: name '(.+?)', country '(.+?)', city '(.+?)', credit card '(.+?)', month '(.+?)' and year '(.+?)'$")
    public void fillDataToPurchase(String userName, String userCountry, String userCity, String userCC, String userMonth, String userYear) {
        /* Get access to the selenium driver instance like this */
        WebDriver driver = this.commonspec.getDriver();

        try {

            /* Write the name */
            WebElement txtName = driver.findElement(By.id("name"));
            txtName.sendKeys(userName);

            /* Write the country */
            WebElement txtCountry = driver.findElement(By.id("country"));
            txtCountry.sendKeys(userCountry);

            /* Write the city */
            WebElement txtCity = driver.findElement(By.id("city"));
            txtCity.sendKeys(userCity);

            /* Write the credit card */
            WebElement txtCard = driver.findElement(By.id("card"));
            txtCard.sendKeys(userCC);

            /* Write the month */
            WebElement txtMonth = driver.findElement(By.id("month"));
            txtMonth.sendKeys(userMonth);

            /* Write the year */
            WebElement txtYear = driver.findElement(By.id("year"));
            txtYear.sendKeys(userYear);
        }catch (Exception e){
        }
    }


    /**
     *
     * @param attElem attribute of the element to get
     * @param pathElem xpath of the element
     * @param ind index of the element
     * @param envVariable environment to save the value
     */
    @Given("^I save attribute '(.+?)' from xpath '(.+?)' on index '(.+?)' in environment variable '(.+?)'$")
    public void saveAttributeInEnvVariable(String attElem, String pathElem, int ind, String envVariable){
        WebDriver d = this.commonspec.getDriver();
        try {
            ind=ind+1;
            String valueReturned;
            WebElement elem = d.findElement(By.xpath("(" + pathElem + ")[" + ind + "]"));
            valueReturned=elem.getAttribute(attElem);
            ThreadProperty.set(envVariable, valueReturned);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            this.commonspec.getLogger().error("Not found value in the element", e);
        }
    }
}