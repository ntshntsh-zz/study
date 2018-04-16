package config;

import org.aeonbits.owner.Config;

import java.net.URI;

@Config.Sources("classpath:testing.properties")
public interface PetApiConfig extends Config {

    @Key("pet.api.uri")
    @DefaultValue("http://petstore.swagger.io/v2")
    URI getPetApiUri();
}
