package unter.user;

import delivery.Username;
import org.immutables.value.Value;
import unter.Event;

@Value.Immutable
public abstract class NewUserCreated implements Event {
    public abstract Username username();
    public abstract UserId userId();

    @Override
    public String type() {
        return "NewUserCreated";
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder extends ImmutableNewUserCreated.Builder {}
}
