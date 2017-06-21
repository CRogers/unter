package delivery;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Message {
    public abstract String content();

    public static Message havingContent(String content) {
        return ImmutableMessage.builder().content(content).build();
    }
}
