document.addEventListener('DOMContentLoaded', function() {
    const dropdownToggles = document.querySelectorAll('.dropdown-toggle');
    
    dropdownToggles.forEach(toggle => {
      toggle.addEventListener('click', function(e) {
        e.preventDefault();
        this.classList.toggle('active');
        const submenu = this.nextElementSibling;
        submenu.classList.toggle('active');
      });
    });
  });