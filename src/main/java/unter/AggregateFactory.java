package unter;

public interface AggregateFactory<T> {
    T create(ResourceId resourceId);
}
