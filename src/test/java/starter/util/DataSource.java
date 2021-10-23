package starter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.thucydides.core.annotations.Step;
import starter.pojo.Country;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    public List<Country> getDSCountries() throws IOException {
        List<Country> countries = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        Country[] response = mapper.readValue(new File("src/test/resources/datasource/data.json"), Country[].class);
        Arrays.stream(response).forEach(x->{
            countries.add(x);
        });
        return countries;
    }

    @Step("Get country by alpha code from datasource")
    public Country getDSCountryByAlphaCode(String code) throws IOException {
        List<Country> countries = new ArrayList<>();
        getDSCountries().stream().filter(x-> {
           return x.getAlpha2Code().equals(code);
        }).forEach(x->{
            countries.add(x);
        });
        return  countries.stream().findFirst().get();
    }

}
