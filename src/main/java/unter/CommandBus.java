package unter;

import unter.commands.Command;

import java.util.function.Consumer;

public class CommandBus {
    private Consumer handler = null;

    public void submit(Command command) {
        handler.accept(command);
    }

    public <T extends Command> void listenFor(Class<T> commandClass, Consumer<T> handler) {
        this.handler = handler;
    }
}
