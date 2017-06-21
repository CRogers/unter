package unter.user.handlers;

import unter.user.UserRepository;
import unter.user.commands.SignUp;

public class SignUpHandler {
    private final UserRepository userRepository;

    public SignUpHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(SignUp signUp) {
        userRepository.newUserWithUsername(signUp.username());
    }
}
