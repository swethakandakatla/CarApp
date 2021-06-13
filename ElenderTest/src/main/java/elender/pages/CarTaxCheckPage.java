package elender.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.PageObjectUtils.assertElement;

public class CarTaxCheckPage {

    @FindBy(css = "#vrm-input")
    WebElement regInput;

    @FindBy(xpath = "//button[contains(.,'Free Car Check')]")
    WebElement freeCarCheck;

    @FindBy(css = "#m > div.jsx-79705764 > div.jsx-2427602283.modal-bg.visible > div > div > dl > div > h5 > span")
    WebElement vehicleNotFound;

    @FindBy(css = "#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(1) > dd")
    WebElement carReg;

    @FindBy(css = "#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd")
    WebElement make;

    @FindBy(css = "#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd")
    WebElement model;

    @FindBy(css = "#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd")
    WebElement colour;

    @FindBy(css = "#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd")
    WebElement year;


    private WebDriver driver;

    public CarTaxCheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isVehicleNotFound() {
        boolean isVehicleNotFoundPresent = false;
        try {
            vehicleNotFound.isDisplayed();
            isVehicleNotFoundPresent = true;
        } catch (NoSuchElementException e) {

        }
        return isVehicleNotFoundPresent;
    }

    public void enterCarRegistration(String registration) {
        regInput.clear();
        regInput.sendKeys(registration);
    }

    public void clickFreeCarCheckButton() {
        assertElement(freeCarCheck);
        freeCarCheck.click();
    }

    public String getRegistration() {
        return carReg.getText();
    }

    public String getMake() {
        return make.getText();
    }

    public String getModel() {
        return model.getText();
    }

    public String getColour() {
        return colour.getText();
    }

    public String getYear() {
        return year.getText();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

}
