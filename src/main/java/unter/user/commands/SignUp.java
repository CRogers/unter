package unter.user.commands;

import delivery.Username;
import org.immutables.value.Value;
import unter.Command;

@Value.Immutable
public abstract class SignUp implements Command {
    public abstract Username username();
}
