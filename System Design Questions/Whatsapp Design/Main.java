import messageformat.*;
import model.User;
import singleton.*;

public class Main {
    public static void main(String[] args) {
        // Getting instance of MessageManager
        MessageManager messageManager = MessageManager.getInstance();

        // Sender, receiver
        User msgSender = new User("6392179108", "Ram");
        User msgReceiver = new User("6392179109", "Shyam");

        // Message
        Message msgToSend = new TextMessage(msgSender, msgReceiver, "Hi, This is Ram!");
        System.out.println(messageManager.sendMessage(msgToSend));
    }
}