package delivery;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Username {
    public abstract String username();

    public static Username of(String username) {
        return ImmutableUsername.builder()
                .username(username)
                .build();
    }
}
