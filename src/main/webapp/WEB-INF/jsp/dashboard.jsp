<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <title>OneStop Grocery</title>
    <link rel="stylesheet" href="assets/css/main.css"> <!--css path-->
</head>

<body class="index">
  <header>
      <div class="logo-container">
          <h2 class="logo-white">Hi </h2>
          <h2 class="logo"> Fi</h2>
        </div>

          <!--nav-->
          <nav class="navigation">
            <a href="#">Home</a>
            <a href="#">About</a>
            <div class="dropdown">
              <a>Services</a>
              <div class="dropdown-content">
                <a href="/process-payment">process-payment</a>
                <a href="/cars">Car Posting</a>
              </div>
            </div>
              <a href="#">About</a>
              <div class="dropdown">
                <button class="btn-popup"><sec:authentication property="name" /></button>
                <div class="dropdown-content">
                  <a class="dropdown-item" href="/profile?user_id=${user_id}">Profile <ion-icon name="person-circle-outline"></ion-icon></a>
                  <a class="dropdown-item" href="/logout" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Logout <ion-icon name="exit-outline"></ion-icon></a>
                  <form id="logout-form" action="/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                </div>
              </div>
        </nav>
    </header>

    <!-- Footer -->
<footer class="footer">
  <p>Copyright &copy; OSG Sdn. Bhd</p>
  <p>Created by Garry</p>
</footer>
    

  <!--scripts-->
  <script src="assets/js/dashboard.js"></script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
</body>

</html>