<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="alert alert-danger">
                <p>${message}</p>
            </div>
            <p>You will be redirected to the home page in <span id="countdown">5</span> seconds...</p>
        </div>
    </div>
</div>

<script>
    var countdownElement = document.getElementById('countdown');
    var countdown = 5;
    var interval = setInterval(function() {
        countdown--;
        countdownElement.innerHTML = countdown;
        if (countdown === 0) {
            clearInterval(interval);
            window.location.href = "/";
        }
    }, 1000);
</script>
</body>
</html>
