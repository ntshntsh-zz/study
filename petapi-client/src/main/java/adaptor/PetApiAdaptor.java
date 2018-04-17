package adaptor;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import io.swagger.client.ApiClient;
import io.swagger.client.model.User;

import static io.swagger.client.ResponseSpecBuilders.shouldBeCode;
import static io.swagger.client.ResponseSpecBuilders.validatedWith;

public class PetApiAdaptor extends AbstractModule {

    @Inject
    ApiClient api;

    public void setUpUser(User user) {
        api.user().createUser().body(user)
                .execute(validatedWith(shouldBeCode(200)));
    }

    public User getUser(String username) {
        return api.user().getUserByName()
                .usernamePath(username)
                .execute(validatedWith(shouldBeCode(200)))
                .as(User.class);
    }

    public void deleteUser(String username) {
        api.user().deleteUser()
                .usernamePath(username)
                .execute(validatedWith(shouldBeCode(200)));
    }

    @Override
    public void configure() {
    }
}
