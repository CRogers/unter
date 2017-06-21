package unter.user;

import delivery.Username;
import org.immutables.value.Value;
import unter.Event;

@Value.Immutable
public abstract class CreateNewUser implements Event {
    public abstract Username username();
    public abstract UserId userId();

    public static Builder with() {
        return new Builder();
    }

    public static class Builder extends ImmutableCreateNewUser.Builder {}
}
