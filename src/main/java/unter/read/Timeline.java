package unter.read;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import delivery.Message;
import delivery.Username;
import unter.message.SendMessage;
import unter.user.CreateNewUser;
import unter.user.UserId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timeline {
    private final Map<Username, UserId> userMapping = Maps.newHashMap();

    private final ListMultimap<UserId, Message> messages = Multimaps.newListMultimap(
            new HashMap<>(),
            ArrayList::new
    );

    public void accept(SendMessage sendMessage) {
        messages.put(sendMessage.userId(), Message.havingContent(sendMessage.contents()));
    }

    public void accept(CreateNewUser createNewUser) {
        userMapping.put(createNewUser.username(), createNewUser.userId());
    }

    public List<Message> timelineFor(Username username) {
        UserId userId = userMapping.get(username);
        return messages.get(userId);
    }
}
