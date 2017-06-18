package unter.commands;

import delivery.Username;
import org.immutables.value.Value;

@Value.Immutable
public abstract class SignUp implements Command {
    public abstract Username username();
}
