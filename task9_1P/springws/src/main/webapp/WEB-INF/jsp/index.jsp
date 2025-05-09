<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message Sender</title>
</head>
<body>
    <h1>Send a Message</h1>

    <!-- Show error or success messages -->
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
    <c:if test="${not empty success}">
        <p style="color:green">${success}</p>
    </c:if>

    <!-- Form to submit a message -->
    <form action="/messages/add" method="POST">
        <input type="text" name="message" placeholder="Enter your message" required />
        <button type="submit">Send Message</button>
    </form>
	
	<!-- Form to clear all messages -->
	<form action="/messages/clear" method="POST" style="margin-top: 10px;">
	    <button type="submit">Clear All Messages</button>
	</form>


    <h2>All Messages:</h2>
    <ul>
        <c:forEach var="msg" items="${messages}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</body>
</html>
