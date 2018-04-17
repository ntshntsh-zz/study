package provider;

import config.PetApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.swagger.client.ApiClient;

import javax.inject.Inject;
import javax.inject.Provider;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.restassured.http.ContentType.JSON;
import static io.swagger.client.GsonObjectMapper.gson;

public class PetApiProvider implements Provider<ApiClient> {

    @Inject
    private PetApiConfig petApiConfig;

    @Override
    public ApiClient get() {
        ApiClient.Config apiConfig = ApiClient.Config
                .apiConfig()
                .reqSpecSupplier(
                        () -> new RequestSpecBuilder().setContentType(JSON)
                                .setBaseUri(petApiConfig.getPetApiUri())
                                .setConfig(config().objectMapperConfig(objectMapperConfig()
                                        .defaultObjectMapper(gson())))
                                .addFilter(new ErrorLoggingFilter()));

        return ApiClient.api(apiConfig);
    }
}
