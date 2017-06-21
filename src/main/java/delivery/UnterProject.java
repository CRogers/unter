package delivery;

import org.immutables.value.Value;
import unter.event.EventBus;
import unter.read.Timeline;

@Value.Immutable
public class UnterProject {
    @Value.Lazy
    protected EventBus eventBus() {
        return new EventBus();
    }

    @Value.Lazy
    public UnterReadApi unterReadApi() {
        return new UnterReadApi(new Timeline(eventBus()));
    }

    @Value.Lazy
    public UnterWriteApi unterWriteApi() {
        return new UnterWriteApi();
    }

}
