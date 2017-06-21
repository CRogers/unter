package unter.user;

import delivery.Username;
import unter.EventBus;

public class UserRepository {
    private final EventBus eventBus;

    public UserRepository(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void newUserWithUsername(Username username) {
        UserId userId = UserId.random();
        eventBus.submitEvent(CreateNewUser.with()
                .userId(userId)
                .username(username)
                .build()
        );
    }
}
