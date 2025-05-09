package ontrack;

/**
 * A simple model for a message.
 */
public class Message {

    private String content;

    // Constructor
    public Message(String content) {
        this.content = content;
    }

    // Getter and Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
