package starter.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.assertions.CountryLayerAssertions;
import starter.service.CountryLayerRequests;

import java.io.IOException;

public class CountryLayerStepDefinitions {

    @Steps
    CountryLayerRequests countryLayerRequests;

    @Steps
    CountryLayerAssertions countryLayerAssertions;

    private String code;

    @When("User send the API request to get all countries")
    public void user_send_the_API_request_to_get_all_countries() {
        countryLayerRequests.fetchAllCountries();
    }

    @When("User send the API request to get country by alpha code {string}")
    public void user_send_the_API_request_to_get_country_by_alpha_code(String value) throws IOException {
        code = value;
        countryLayerRequests.fetchCountryByAlphaCode(code);
    }

    @Then("He/She validates the body response")
    public void user_validates_body_response() throws IOException {
        countryLayerAssertions.countryByAlphaCodeResponseComparison(code);
    }

    @Then("He/She validates response status code is {string}")
    public void user_validates_response_status_code_is(String status) {
        countryLayerAssertions.validateStatusCode(status);
    }

    @When("User send the API request to add a new country {string}, {string}, {string}")
    public void user_send_the_API_request_to_add_a_new_country(String name, String alpha2_code, String alpha3_code) {
        countryLayerRequests.addNewCountry(name,alpha2_code,alpha3_code);
    }
}
