package statusformat;

import model.*;

// status type -> text
public class TextStatus extends Status {
    private String text;

    public TextStatus(User user, String text) {
        super(user);
        this.text = text;
    }

    // implementing the abstract method
    public String showStatus() {
        return text;
    }
}