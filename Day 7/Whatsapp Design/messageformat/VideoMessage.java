package messageformat;

import model.*;

// message type -> video
public class VideoMessage extends Message {
    private String videoUrl;

    // constructor
    public VideoMessage(User sender, User receiver, String videoUrl) {
        super(sender, receiver);
        this.videoUrl = videoUrl;
    }

    // implementing the getContent
    public String getContent() {
        return videoUrl;
    }
}
