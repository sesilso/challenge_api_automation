package starter.assertions;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.pojo.Country;
import starter.util.DataSource;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CountryLayerAssertions {

    @Steps
    DataSource dataSource;

    @Step("Validate Response Status Code")
    public void validateStatusCode(String code){
        restAssuredThat(response -> response.statusCode(Integer.parseInt(code)));
    }

    @Step("Validate Country By Alpha Code Response")
    public void countryByAlphaCodeResponseComparison(String code) throws IOException {
        Country expectedCountry = dataSource.getDSCountryByAlphaCode(code);
        restAssuredThat(response -> response.body("name", equalTo(expectedCountry.getName())));
        restAssuredThat(response -> response.body("topLevelDomain", equalTo(expectedCountry.getTopLevelDomain())));
        restAssuredThat(response -> response.body("alpha2Code", equalTo(expectedCountry.getAlpha2Code())));
        restAssuredThat(response -> response.body("alpha3Code", equalTo(expectedCountry.getAlpha3Code())));
        restAssuredThat(response -> response.body("callingCodes", equalTo(expectedCountry.getCallingCodes())));
        restAssuredThat(response -> response.body("capital", equalTo(expectedCountry.getCapital())));
        restAssuredThat(response -> response.body("altSpellings", equalTo(expectedCountry.getAltSpellings())));
        restAssuredThat(response -> response.body("region", equalTo(expectedCountry.getRegion())));
    }

}
