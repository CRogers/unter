package unter;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import unter.commands.Command;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CommandBus {
    private final Multimap<Class, Consumer> handlers = Multimaps.newListMultimap(
            Maps.newHashMap(),
            ArrayList::new
    );

    public void submit(Command command) {
        handlers.forEach((commandClass, handler) -> {
            if (commandClass.isAssignableFrom(command.getClass())) {
                handler.accept(command);
            }
        });
    }

    public <T extends Command> void listenFor(Class<T> commandClass, Consumer<T> handler) {
        handlers.put(commandClass, handler);
    }
}
