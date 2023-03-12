<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
    <h1>Profile</h1>
    <p>Welcome, ${user.username}!</p>
    <p>Your email address is ${user.email}.</p>
    <p><a href="/update-profile?user_id=${user.id}">Edit Profile</a></p>
</body>
</html>
