package starter.service;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Parameters {
    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getKey(){
        return variables.getProperty("api.key");
    }

    public static String urlGetAll(){
        return variables.getProperty("url.get.all");
    }

    public static String urlGetByCode(){
        return variables.getProperty("url.get.by.code");
    }

    public static String urlAddNew(){
        return variables.getProperty("url.add.country");
    }
}
