const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const userInput = document.getElementById("user2");
const email2Input = document.getElementById("email2");
const password2Input = document.getElementById("password2");

emailInput.addEventListener("input", () => {
  if (emailInput.value !== "") {
    emailInput.classList.add("has-value");
  } else {
    emailInput.classList.remove("has-value");
  }
});

passwordInput.addEventListener("input", () => {
  if (passwordInput.value !== "") {
    passwordInput.classList.add("has-value");
  } else {
    passwordInput.classList.remove("has-value");
  }
});

userInput.addEventListener("input", () => {
    if (userInput.value !== "") {
      userInput.classList.add("has-value");
    } else {
      userInput.classList.remove("has-value");
    }
  });

  email2Input.addEventListener("input", () => {
    if (email2Input.value !== "") {
      email2Input.classList.add("has-value");
    } else {
      email2Input.classList.remove("has-value");
    }
  });
  
  password2Input.addEventListener("input", () => {
    if (password2Input.value !== "") {
      password2Input.classList.add("has-value");
    } else {
      password2Input.classList.remove("has-value");
    }
  });

  const wrapper = document.querySelector('.wrapper-login')
  const loginLink = document.querySelector('.login-link')
  const registerLink = document.querySelector('.register-link')
  const btnPopup =document.querySelector('.btn-popup')
  const iconClose =document.querySelector('.icon-close')

  registerLink.addEventListener('click', () => {
    wrapper.classList.add('active');
  });

  loginLink.addEventListener('click', () => {
    wrapper.classList.remove('active');
  });

  btnPopup.addEventListener('click', () => {
    wrapper.classList.add('active-popup');
  });

  iconClose.addEventListener('click', () => {
    wrapper.classList.remove('active-popup');
  });


  const loginButton = document.querySelector('.btn-popup');
  const iconClose2 =document.querySelector('.icon-close')
  const welcomeSection = document.querySelector('.welcome-section');
  
  loginButton.addEventListener('click', () => {
    welcomeSection.classList.add('hide');
  });
  
  iconClose2.addEventListener('click', () => {
    welcomeSection.classList.remove('hide');
  });







  
