package unter;

import org.junit.Test;
import unter.commands.Command;

import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandBusShould {
    private final CommandBus commandBus = new CommandBus();

    interface FooCommand extends Command {}

    @Test
    public void call_command_handler_when_command_of_the_correct_type_is_registered() {
        Consumer<FooCommand> fooCommandHandler = mock(Consumer.class);
        commandBus.listenFor(FooCommand.class, fooCommandHandler);

        FooCommand fooCommand = mock(FooCommand.class);
        commandBus.submit(fooCommand);

        verify(fooCommandHandler).accept(fooCommand);
    }
}