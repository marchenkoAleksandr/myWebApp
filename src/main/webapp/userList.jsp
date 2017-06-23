<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>REGISTERED</th>
        </tr>
        <c:forEach var="user" items="${userList}">
        <jsp:useBean id="user" type="org.itstep.mywebapp.model.User"/>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getRegistered()%></td>
            <td><a href="users?action=update&id=${user.id}">UPDATE</a></td>
            <td><a href="users?action=delete&id=${user.id}">DELETE</a></td>
        </tr>
        </c:forEach>
    </table>

    <a href="users?action=create">ADD</a>
</body>
</html>