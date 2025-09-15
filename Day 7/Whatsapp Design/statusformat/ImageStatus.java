package statusformat;

import model.*;

// status type -> image
public class ImageStatus extends Status {
    private String imageUrl;

    // Construtor
    public ImageStatus(User user, String imageUrl) { 
        super(user);
        this.imageUrl = imageUrl; 
    }

    // implementing the abstract method
    public String showStatus() { 
        return imageUrl; 
    }
}
