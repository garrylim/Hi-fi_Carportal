const dropdowns = document.querySelectorAll('.dropdown');
dropdowns.forEach(function(dropdown) {
  const dropdownContent = dropdown.querySelector('.dropdown-content');

  dropdown.addEventListener('click', function() {
    dropdownContent.classList.toggle('active');
  });

  document.addEventListener('click', function(event) {
    if (!dropdown.contains(event.target)) {
      dropdownContent.classList.remove('active');
    }
  });
});
