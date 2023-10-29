package raf.dsw.classycraft.app.core.MessageGenerator;


import java.time.LocalDateTime;

public class Message {
    private String text;
    private MessageType type;
    private LocalDateTime timestamp;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Message(String text, MessageType type, LocalDateTime timestamp) {
        this.text = text;
        this.type = type;
        this.timestamp = timestamp;
    }
}
