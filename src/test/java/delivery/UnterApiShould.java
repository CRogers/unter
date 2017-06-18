package delivery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnterApiShould {
    private final UnterReadApi readApi = new UnterReadApi();
    private final UnterWriteApi writeApi = new UnterWriteApi();

    @Test
    public void return_no_users_when_no_users_have_signed_up() {
        assertThat(readApi.allUsers()).isEmpty();
    }

    @Test
    public void return_a_user_when_a_single_user_has_signed_up() {
        Username user = Username.of("user");
        writeApi.signUp(user);
        assertThat(readApi.allUsers()).contains(user);
    }
}