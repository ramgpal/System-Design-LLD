package messageformat;

import model.*;

// message type -> audio
public class AudioMessage extends Message {
    private String audioUrl;

    // constructor
    public AudioMessage(User sender, User receiver, String audioUrl) {
        super(sender, receiver);
        this.audioUrl = audioUrl;
    }

    // overriding the getContent method
    public String getContent() {
        return audioUrl;
    }
}

