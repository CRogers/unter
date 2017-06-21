package unter.message;

import unter.EventBus;
import unter.entity.EntityId;

public class MessageRepository {
    private final EventBus eventBus;

    public MessageRepository(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void newMessage() {
        EntityId messageId = EntityId.random();


    }
}
