package unter.message;

import org.immutables.value.Value;
import unter.Event;
import unter.UnterImmutableStyle;
import unter.user.UserId;

@Value.Immutable
@UnterImmutableStyle
public abstract class MessageSent implements Event {
    public abstract MessageId messageId();
    public abstract UserId userId();
    public abstract String contents();

    @Override
    public String type() {
        return "MessageSent";
    }

    public static class Builder extends ImmutableMessageSent.Builder {}

    public static Builder builder() {
        return new Builder();
    }
}
