<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
</head>
<body>
    <h1>Edit Profile</h1>
    <form:form method="post" modelAttribute="user" action="/update-profile">
        <input type="hidden" name="user_id" value="${user.id}" />
        <div>
            <label for="username">Username:</label>
            <form:input path="username" id="username" value="${user.username}" />
        </div>
        <div>
            <label for="email">Email:</label>
            <form:input path="email" id="email" value="${user.email}" />
        </div>
        <div>
            <button type="submit">Save</button>
        </div>
    </form:form>
</body>
</html>
