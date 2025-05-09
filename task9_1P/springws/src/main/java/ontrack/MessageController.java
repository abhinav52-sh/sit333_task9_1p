package ontrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @Autowired
    private OnTrackService onTrackService;

    // Show form and current messages
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", onTrackService.getMessages()); // Add all messages to the model
        return "index";
    }

    // Handle message submission
    @PostMapping("/messages/add")
    public String addMessage(@RequestParam String message, Model model) {
        if (message.isEmpty()) {
            model.addAttribute("error", "Message cannot be empty.");
        } else {
            onTrackService.addMessage(message); // Add to list
            model.addAttribute("success", "Message added successfully!");
        }

        model.addAttribute("messages", onTrackService.getMessages()); // Show updated list
        return "index";
    }
    
    // Add this method to MessageController.java
    @PostMapping("/messages/clear")
    public String clearMessages(Model model) {
        onTrackService.clearMessages(); // Clear all messages
        model.addAttribute("success", "All messages cleared.");
        model.addAttribute("messages", onTrackService.getMessages()); // Empty list
        return "index";
    }

}
