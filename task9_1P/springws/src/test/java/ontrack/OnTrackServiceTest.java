package ontrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OnTrackServiceTest {

    private OnTrackService service;

    // This method will run before each test, initializing the service instance.
    @BeforeEach
    void setUp() {
        service = new OnTrackService(); // Instantiate the OnTrackService to run tests
    }

    // Test to check adding a single message and its correctness
    @Test
    void testAddSingleMessage() {
        service.addMessage("Hello"); // Add a message
        List<String> messages = service.getMessages(); // Get the list of messages

        // Assert that the list contains 1 message and that message is "Hello"
        assertEquals(1, messages.size());
        assertEquals("Hello", messages.get(0));
    }

    // Test to check adding multiple messages and their order
    @Test
    void testAddMultipleMessages() {
        service.addMessage("Hello"); // Add the first message
        service.addMessage("How are you?"); // Add the second message
        service.addMessage("Bye"); // Add the third message

        List<String> messages = service.getMessages(); // Retrieve the list of messages

        // Assert that the list contains 3 messages and verify their content and order
        assertEquals(3, messages.size());
        assertEquals("Hello", messages.get(0));
        assertEquals("How are you?", messages.get(1));
        assertEquals("Bye", messages.get(2));
    }

    // Test to check if the returned list is independent of the original list
    @Test
    void testMessageListIsIndependentCopy() {
        service.addMessage("Original"); // Add a message

        List<String> messages = service.getMessages(); // Get the list of messages
        messages.add("Fake message"); // Modify the returned list (it should not affect the original)

        // Assert that the original list still contains only 1 message, not the added "Fake message"
        assertEquals(1, service.getMessages().size());
    }

    // Test to check adding an empty message (should be allowed)
    @Test
    void testEmptyMessageDoesNotThrowError() {
        assertDoesNotThrow(() -> service.addMessage("")); // Should not throw an error even for an empty message
        assertEquals(1, service.getMessages().size()); // The list should contain one empty string
        assertEquals("", service.getMessages().get(0)); // The first message should be empty
    }

    // Test to ensure that adding a null message throws an exception
    @Test
    void testNullMessageThrowsException() {
        // Assert that adding a null message throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> service.addMessage(null));
    }

    // Test to check if the message is trimmed before being added (removes leading/trailing whitespaces)
    @Test
    void testMessageTrimming() {
        service.addMessage("   Hello   "); // Add a message with extra spaces around it

        // Assert that the message is stored without leading or trailing spaces
        assertEquals("Hello", service.getMessages().get(0)); 
    }

    // Test to verify the functionality of clearing all messages
    @Test
    void testClearMessages() {
        service.addMessage("One"); // Add a message
        service.addMessage("Two"); // Add another message

        service.clearMessages(); // Clear all messages

        // Assert that the list is now empty after clearing
        assertTrue(service.getMessages().isEmpty());
    }

    // Test to check that clearing an empty list does not cause any issues
    @Test
    void testClearOnEmptyList() {
        service.clearMessages(); // Clear the list when it's already empty

        // Assert that the list remains empty
        assertTrue(service.getMessages().isEmpty());
    }
}
