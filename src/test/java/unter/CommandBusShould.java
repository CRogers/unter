package unter;

import org.junit.Test;
import unter.commands.Command;

import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandBusShould {
    private final CommandBus commandBus = new CommandBus();

    private final Consumer<FooCommand> fooCommandHandler1 = mock(Consumer.class, "fooHandler1");
    private final Consumer<FooCommand> fooCommandHandler2 = mock(Consumer.class, "fooHandler2");
    private final FooCommand fooCommand = mock(FooCommand.class, "fooCommand");

    interface FooCommand extends Command {}

    @Test
    public void not_error_when_a_command_is_submitted_but_no_handlers_have_been_registered() {
        commandBus.submit(fooCommand);
    }

    @Test
    public void call_command_handler_when_command_of_the_correct_type_is_submitted() {
        commandBus.listenFor(FooCommand.class, fooCommandHandler1);
        commandBus.submit(fooCommand);

        verify(fooCommandHandler1).accept(fooCommand);
    }

    @Test
    public void call_all_command_handlers_when_command_of_the_correct_type_is_submitted() {
        commandBus.listenFor(FooCommand.class, fooCommandHandler1);
        commandBus.listenFor(FooCommand.class, fooCommandHandler2);
        commandBus.submit(fooCommand);

        verify(fooCommandHandler1).accept(fooCommand);
        verify(fooCommandHandler2).accept(fooCommand);
    }
}