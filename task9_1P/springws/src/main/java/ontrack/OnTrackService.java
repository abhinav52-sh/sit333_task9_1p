package ontrack.fail;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OnTrackService {

    // A thread-safe list to store all messages
    private final List<String> messages = Collections.synchronizedList(new ArrayList<>());

    // Add a message to the list
    public void addMessage(String message) {
    	if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        messages.add(message.trim());
    }

    // Return a copy of the current message list
    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
    
    // Add this method inside OnTrackService.java
    public void clearMessages() {
        messages.clear();
    }

}
