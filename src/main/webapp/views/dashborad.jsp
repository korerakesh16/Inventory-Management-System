<%@ page import="com.telecominv.model.User" %>
<%@ page session="false" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("currentUser") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    User currentUser = (User) session.getAttribute("currentUser");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Telecom Inventory</title>
</head>
<body>
    <h2>Welcome, <%= currentUser.getFullName() %>!</h2>
    <p>Username: <%= currentUser.getUsername() %></p>
    <p>Role: <%= currentUser.getRole() %></p>
    <a href="../logout">Logout</a>
</body>
</html>
