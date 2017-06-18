package unter;

import unter.commands.Command;

import java.util.Optional;
import java.util.function.Consumer;

public class CommandBus {
    private Optional<Consumer> handler = Optional.empty();

    public void submit(Command command) {
        handler.ifPresent(handler -> handler.accept(command));
    }

    public <T extends Command> void listenFor(Class<T> commandClass, Consumer<T> handler) {
        this.handler = Optional.of(handler);
    }
}
