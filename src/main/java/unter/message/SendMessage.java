package unter.message;

import org.immutables.value.Value;
import unter.Command;
import unter.user.UserId;

@Value.Immutable
public abstract class SendMessage implements Command {
    public abstract MessageId messageId();
    public abstract UserId userId();
    public abstract String contents();

    public static SendMessage havingContent(String contents) {
        return ImmutableSendMessage.builder().contents(contents).build();
    }
}
