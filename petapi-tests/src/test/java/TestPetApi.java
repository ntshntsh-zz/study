import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.google.inject.Inject;
import io.swagger.client.ApiClient;
import io.swagger.client.model.User;
import module.PetApiModule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceTestRunner.class)
@GuiceModules(PetApiModule.class)
public class TestPetApi {

    @Inject
    ApiClient api;

    @Test
    public void testPet() {
        User petUser = new User()
                .username("ntshnts")
                .firstName("Ntsh")
                .lastName("Nmv");
        api.user().createUser().body(petUser).execute(r -> r.getStatusCode());
    }


}