<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
        <jsp:useBean id="user" type="org.itstep.mywebapp.model.User" scope="request"/>

        <form method="post" action="users">

            <input type="hidden" name="id" value="${user.id}">

            <dl>
                <dt>Name:</dt>
                <dd><input type="text" value="${user.name}" size=40 name="name"></dd>
            </dl>

            <button type="submit">Save</button>
        </form>
</body>
</html>
