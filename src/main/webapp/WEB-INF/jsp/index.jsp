<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="#">About</a>
            <button class="btn-popup">Login</button>
        </nav>
    </header>

    <!--left nav-->
<div class="nav-contact">
    <ul class="nav-contact">
      <li><a href="#"><i class="fab fa-facebook-f"></i><span>Facebook</span></a></li>
      <li><a href="#"><i class="fab fa-twitter"></i><span>Twitter</span></a></li>
      <li><a href="#"><i class="fab fa-instagram"></i><span>Instagram</span></a></li>
      <li><a href="#"><i class="fab fa-linkedin-in"></i><span>Linkedin</span></a></li>
      <li><a href="#"><i class="fab fa-github"></i><span>Github</span></a></li>
      <li><a href="#"><i class="fab fa-youtube"></i><span>Youtube</span></a></li>
      </ul>
  </div>

    <div class="welcome-section">
        <h1>Welcome to Hi-Fi CarPortal</h1>
    </div>

    <div class="wrapper-login">
        <span class="icon-close">
            <ion-icon name="close"></ion-icon>
        </span>
        <div class="form-box login">
            <h2>Login</h2>
            <form action="/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
                <!--Email-->
                <div class="input-box">
                    <span class="icon"><ion-icon name="mail"></ion-icon></span>
                    <input type="email" id="email" name="email" required>
                    <label for="email">Email</label>
                  </div>
                  <!--Password-->
                  <div class="input-box">
                    <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                    <input type="password" id="password" name="password" required>
                    <label for="password">Password</label>
                  </div>
                  <!--Check Box-->
                <div class="remember-me">
                    <label><input type="checkbox">
                    Remember me</label>
                    <a href="#">Forget Password</a>
                </div>
                <!--submit button-->
                <button type="submit" class="btn-login">Login
                </button>
                <!--Register Link-->
                <div class="register">
                    <p>Don't have an account?
                        <a href="#" class="register-link">Register</a>
                    </p>
                </div>
            </form>
        </div>

        <div class="form-box register">
            <h2>Registration</h2>
            <form id="myForm" action="/process_signup" method="post" modelattribute="user" onsubmit="registerUser(); return false;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <!--Username-->
                <div class="input-box">
                    <span class="icon"><ion-icon name="person"></ion-icon></span>
                    <input type="text" id="user2" name="username" required>
                    <label for="user">Username</label>
                  </div>
                  <!--Email-->
                <div class="input-box">
                    <span class="icon"><ion-icon name="mail"></ion-icon></span>
                    <input type="email" id="email2" name="email" required>
                    <label for="email">Email</label>
                    <div th:if="${message}">
                        <p th:text="${message}" class="alert alert-danger"></p>
                    </div>
                    
                  </div>
                  <!--Password-->
                  <div class="input-box">
                    <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                    <input type="password" id="password2" name="password" required>
                    <label for="password">Password</label>
                  </div>

                  <!--check box-->
                <div class="remember-me">
                    <label><input type="checkbox">
                    I agree to the terms & condition</label>
                </div>
                <!--Register button-->
                <button type="submit" class="btn-login">Register
                </button>
                <!--login link-->
                <div class="register">
                    <p>Already have an account?
                        <a href="#" class="login-link">Login Now</a>
                    </p>
                </div>
            </form>
        </div>
        <div th:if="${param.message}">
            <div class="alert alert-danger">
              <p th:text="${param.message}"></p>
            </div>
          </div>          

    </div>

<!-- Footer -->
<footer class="footer">
    <p>Copyright &copy; OSG Sdn. Bhd</p>
    <p>Created by Garry</p>
</footer>
      

    <!--scripts-->
    <script src="assets/js/main.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
</body>

</html>