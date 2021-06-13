package elender.steps;

import elender.pages.CarTaxCheckPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import utils.InputFileReader;
import utils.OutputFileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.waitAtMost;

public class CarTaxCheckSteps extends BasePage {

    CarTaxCheckPage carTaxCheckPage;
    InputFileReader inputFileReader;
    OutputFileReader outputFileReader;
    List<String> carNumbers;

    public CarTaxCheckSteps() {
        super();
        inputFileReader = new InputFileReader();
        outputFileReader = new OutputFileReader();

        WebDriver driver = getDriver();
        carTaxCheckPage = new CarTaxCheckPage(driver);
    }

    @Before(order = 1)
    public void openHotelBooking(Scenario scenario) {
        getHost();
    }

    @After(order = 1)
    public void teardown() {
        quitDriver();
    }

    @Given("^I am on the car tax check page$")
    public void iAmOnTheCarTaxCheckPage() {
        Assert.assertEquals("Title not matched.", "Car Tax Check | Free Car Check", carTaxCheckPage.getPageTitle());
    }

    @When("^I read the car registration numbers from ([^\"]*) input file$")
    public void readCarRegNumbers(String inputFileName) {
        carNumbers = inputFileReader.extractCarRegs(inputFileName);
        Assert.assertNotNull("Input file dint contain any valid car registration numbers", carNumbers);
    }

    @Then("^I enter the car numbers and validate the vehicle data from ([^\"]*) output file$")
    public void enterCarNumberAndValidateDataAppearedOnScreen(String outputFileName) {
        String carData = null;
        for (String carNumber : carNumbers) {

            carNumber = carNumber.replace(" ", "");
            carTaxCheckPage.enterCarRegistration(carNumber);
            carTaxCheckPage.clickFreeCarCheckButton();
            waitAtMost(3, TimeUnit.SECONDS);

            if (carTaxCheckPage.isVehicleNotFound()) {
                System.out.println("Vehicle not found, Registration: "+carNumber);
                carTaxCheckPage.navigateBack();
                continue;
            }

            carData = outputFileReader.getCarData(outputFileName, carNumber);
            Assert.assertNotNull("Output file dint contain any data for " + carNumber, carData);
            Assert.assertEquals("Car Registration not matched", carData.split(",")[0], carTaxCheckPage.getRegistration());
            Assert.assertEquals("Car Make not matched", carData.split(",")[1], carTaxCheckPage.getMake());
            Assert.assertEquals("Car Model not matched", carData.split(",")[2], carTaxCheckPage.getModel());
            Assert.assertEquals("Car Colour not matched", carData.split(",")[3], carTaxCheckPage.getColour());
            Assert.assertEquals("Car Year not matched", carData.split(",")[4], carTaxCheckPage.getYear());

            carData = null;
            carTaxCheckPage.navigateBack();
        }
    }

}

