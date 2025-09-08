<%@
        page import="fit.iuh.se.bai02_JSP_MVC.entity.User"
%>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<body>
<h2>Registered User</h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthday</th>
    </tr>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null && !users.isEmpty()) {
        for (User u : users) {
%>
    <tr>
        <td><%= u.getFirstname() %></td>
        <td><%= u.getLastname() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getGender() %></td>
        <td><%= u.getDob() %></td>
    </tr>
<%      }
} else { %>
    <tr>
        <td colspan="5" style="color: red;">No users registered yet.</td>
    </tr>
<% } %>
</table>
</body>
</html>

