package unter.read;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import delivery.Message;
import delivery.Username;
import unter.Event;
import unter.event.EventBus;
import unter.message.MessageSent;
import unter.user.NewUserCreated;
import unter.user.UserId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Timeline {
    private final Map<Username, UserId> userMapping = Maps.newHashMap();

    private final ListMultimap<UserId, Message> messages = Multimaps.newListMultimap(
            new HashMap<>(),
            ArrayList::new
    );

    private <T extends Event> Predicate<T> isOfType(Class<T> type) {
        return value -> value.getClass().isAssignableFrom(type);
    }

    public Timeline(EventBus eventBus) {
        eventBus.registerListener(isOfType(MessageSent.class), this::accept);
        eventBus.registerListener(isOfType(NewUserCreated.class), this::accept);
    }

    private void accept(MessageSent messageSent) {
        messages.put(messageSent.userId(), Message.havingContent(messageSent.contents()));
    }

    private void accept(NewUserCreated newUserCreated) {
        userMapping.put(newUserCreated.username(), newUserCreated.userId());
    }

    public List<Message> timelineFor(Username username) {
        UserId userId = userMapping.get(username);
        return messages.get(userId);
    }
}
