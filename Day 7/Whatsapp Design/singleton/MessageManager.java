package singleton;

import java.util.*;
import messageformat.*;

public class MessageManager {
    private static MessageManager instance;
    private List<Message> messages;

    // private constructor
    private MessageManager() {
        messages = new ArrayList<>();
    }

    // Method that will create single instance of this class
    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
        }
        return instance;
    }

    // Method for sending message
    public String sendMessage(Message message) {
        messages.add(message); // always store first

        if (message instanceof TextMessage) {
            return "Text msg sent successfully: " + ((TextMessage) message).getContent();
        } else if (message instanceof AudioMessage) {
            return "Audio msg sent successfully: " + ((AudioMessage) message).getContent();
        } else if (message instanceof VideoMessage) {
            return "Video msg sent successfully: " + ((VideoMessage) message).getContent();
        } else {
            return "Invalid form of message";
        }
    }


    // Method to read a message
    public List<Message> getMessages() {
        return messages;
    }
}
