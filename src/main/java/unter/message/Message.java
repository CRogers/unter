package unter.message;

public class Message {
    private String content;

    public void apply(SendMessage sendMessage) {
        this.content = sendMessage.contents();
    }
}
