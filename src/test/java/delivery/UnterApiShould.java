package delivery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnterApiShould {
    private final UnterProject unterProject = new UnterProject();
    private final UnterReadApi readApi = unterProject.unterReadApi();
    private final UnterWriteApi writeApi = unterProject.unterWriteApi();

    private final Username user = Username.of("user");

    @Test
    public void return_no_messages_just_after_having_signed_up() {
        writeApi.signUp(user);

        assertThat(readApi.timelineFor(user)).isEmpty();
    }

    @Test
    public void return_a_user_when_a_single_user_has_signed_up() {
        writeApi.signUp(user);

        Message hi = Message.havingContent("hi");
        writeApi.sendMessage(user, hi);

        assertThat(readApi.timelineFor(user)).contains(hi);
    }

}