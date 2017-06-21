package unter.user;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public abstract class UserId {
    protected abstract String userId();

    public static UserId random() {
        return ImmutableUserId.builder()
                .userId(UUID.randomUUID().toString())
                .build();
    }
}
