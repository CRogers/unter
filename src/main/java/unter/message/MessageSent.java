package unter.message;

import org.immutables.value.Value;
import unter.UnterImmutableStyle;

@Value.Immutable
@UnterImmutableStyle
public abstract class MessageSent {
    @Value.Parameter
    public abstract String content();

    public static MessageSent havingContent(String content) {
        return ImmutableMessageSent.of(content);
    }
}
