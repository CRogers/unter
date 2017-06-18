package unter;

import unter.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CommandBus {
    private List<Consumer> handlers = new ArrayList<>();

    public void submit(Command command) {
        handlers.forEach(handler -> handler.accept(command));
    }

    public <T extends Command> void listenFor(Class<T> commandClass, Consumer<T> handler) {
        handlers.add(handler);
    }
}
