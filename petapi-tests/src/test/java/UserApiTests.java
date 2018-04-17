import adaptor.PetApiAdaptor;
import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.google.inject.Inject;
import io.swagger.client.ApiClient;
import io.swagger.client.model.ModelApiResponse;
import io.swagger.client.model.User;
import module.PetApiModule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.swagger.client.ResponseSpecBuilders.shouldBeCode;
import static io.swagger.client.ResponseSpecBuilders.validatedWith;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceTestRunner.class)
@GuiceModules(PetApiModule.class)
public class UserApiTests {

    @Inject
    ApiClient api;

    @Inject
    PetApiAdaptor adaptor;

    private User petUser = new User()
            .id(0L)
            .username("ntshntsh")
            .firstName("Ntsh")
            .lastName("Nmv")
            .userStatus(0);

    private User updatedUser = new User()
            .id(0L)
            .username("updated_username")
            .firstName("Updated!")
            .userStatus(0);

    @Test
    public void shouldCreateUser() {
        api.user().createUser()
                .body(petUser)
                .execute(validatedWith(shouldBeCode(200)));

        assertThat(adaptor.getUser(petUser.getUsername()))
                .isEqualTo(petUser);
    }

    @Test
    public void shouldGetUserByUsername() {

        adaptor.setUpUser(petUser);

        User getUser = api.user().getUserByName()
                .usernamePath(petUser.getUsername())
                .execute(validatedWith(shouldBeCode(200)))
                .as(User.class);

        assertThat(getUser).isEqualTo(petUser);
    }

    @Test
    public void shouldUpdateUser() {

        adaptor.setUpUser(petUser);

        api.user().updateUser()
                .usernamePath(petUser.getUsername())
                .body(updatedUser)
                .execute(validatedWith(shouldBeCode(200)));

        assertThat(adaptor.getUser(updatedUser.getUsername())).isEqualTo(updatedUser);
    }

    @Test
    public void should404WhenUserNotFound(){

        adaptor.setUpUser(petUser);
        adaptor.deleteUser(petUser.getUsername());

        ModelApiResponse response = api.user().getUserByName()
                .usernamePath(petUser.getUsername())
                .execute(validatedWith(shouldBeCode(404)))
                .as(ModelApiResponse.class);

        assertThat(response.getMessage()).isEqualTo("User not found");
    }


}