package unter.entity;

import org.immutables.value.Value;
import unter.UnterImmutableStyle;

import java.util.UUID;

@Value.Immutable
@UnterImmutableStyle
public abstract class EntityId {
    @Value.Parameter
    protected abstract String id();

    public static EntityId random() {
        return ImmutableEntityId.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }
}
