package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import steps.HacebSteps;


public class BuscadorProductoStepDefinition {

    @Steps
    HacebSteps HacebSteps = new HacebSteps();

    @Given("^que me encuentro en la pagina de Haceb con la url (.*)$")
    public void queMeEncuentroEnLaPaginaDeHacebConLaUrl(String url) {
        SeleniumWebDriver.ChromeWebDriver(url);
    }

    @When("^busco el producto en el buscador$")
    public void buscoElProductoEnElBuscador() {
        HacebSteps.buscarPalabraEnHaceb();
    }

    @Then("^podre ver el producto deseado$")
    public void podreVerElProductoDeseado() {
        SeleniumWebDriver.driver.quit();
    }

}

