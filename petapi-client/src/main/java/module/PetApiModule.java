package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scope;
import com.google.inject.internal.SingletonScope;
import config.PetApiConfig;
import io.swagger.client.ApiClient;
import org.aeonbits.owner.ConfigFactory;
import provider.PetApiProvider;

public class PetApiModule extends AbstractModule {

    private static final Scope SINGLETON = new SingletonScope();

    @Override
    protected void configure() {
        bind(ApiClient.class).toProvider(PetApiProvider.class).in(SINGLETON);
    }

    @Provides
    public PetApiConfig providePetApiConfig() {
        return ConfigFactory.create(PetApiConfig.class, System.getProperties(), System.getenv());
    }
}
