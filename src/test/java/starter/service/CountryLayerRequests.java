package starter.service;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class CountryLayerRequests {

    @Step("Get all countries from service")
    public void fetchAllCountries() {
        SerenityRest.given()
                .param("access_key", Parameters.getKey())
                .get(Parameters.urlGetAll());
    }

    @Step("Get country by alpha code from service")
    public void fetchCountryByAlphaCode(String code) {
        SerenityRest.given()
                .pathParam("code", code)
                .param("access_key", Parameters.getKey())
                .get(Parameters.urlGetByCode());
    }

    @Step("Add new country via service")
    public void addNewCountry(String name, String alpha2_code, String alpha3_code) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", name);
        jsonAsMap.put("alpha2_code", alpha2_code);
        jsonAsMap.put("alpha3_code", alpha3_code);
        SerenityRest.given()
                .param("access_key", Parameters.getKey())
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonAsMap)
                .when()
                .post(Parameters.urlAddNew());
    }


}
