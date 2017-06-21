package unter.message;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public abstract class MessageId {
    protected abstract String messageId();

    public static MessageId random() {
        return ImmutableMessageId.builder()
                .messageId(UUID.randomUUID().toString())
                .build();
    }
}
