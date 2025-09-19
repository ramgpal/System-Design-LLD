package messageformat;

import model.*;

// message type -> text
public class TextMessage extends Message {
    private String textContent;

    // constructor
    public TextMessage(User sender, User receiver, String textContent) {
        super(sender, receiver);
        this.textContent = textContent;
    }

    // overriding the send method
    public String getContent() {
        return textContent;
    }
}

