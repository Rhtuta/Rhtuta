/**
 * BookMyShow Clone - Authentication Handler
 */

const Auth = {
  /**
   * Initialize auth state
   */
  init() {
    this.updateNavbar();
    this.setupEventListeners();
  },
  
  /**
   * Update navbar based on auth state
   */
  updateNavbar() {
    const authNav = document.getElementById('auth-nav');
    const userNav = document.getElementById('user-nav');
    const adminNav = document.getElementById('admin-nav');
    
    if (!authNav || !userNav) return;
    
    if (API.auth.isLoggedIn()) {
      authNav.classList.add('hidden');
      userNav.classList.remove('hidden');
      
      // Show admin link if admin
      if (adminNav) {
        if (API.auth.isAdmin()) {
          adminNav.classList.remove('hidden');
        } else {
          adminNav.classList.add('hidden');
        }
      }
      
      // Update user avatar
      const email = localStorage.getItem('email');
      const avatarEl = document.getElementById('user-avatar');
      if (avatarEl && email) {
        avatarEl.textContent = Utils.getInitials(email.split('@')[0]);
      }
    } else {
      authNav.classList.remove('hidden');
      userNav.classList.add('hidden');
      if (adminNav) adminNav.classList.add('hidden');
    }
  },
  
  /**
   * Setup event listeners
   */
  setupEventListeners() {
    // Logout button
    const logoutBtn = document.getElementById('logout-btn');
    if (logoutBtn) {
      logoutBtn.addEventListener('click', (e) => {
        e.preventDefault();
        API.auth.logout();
      });
    }
    
    // User menu toggle
    const userMenu = document.querySelector('.user-menu');
    if (userMenu) {
      const avatar = userMenu.querySelector('.user-avatar');
      const dropdown = userMenu.querySelector('.dropdown-menu');
      
      if (avatar && dropdown) {
        avatar.addEventListener('click', (e) => {
          e.stopPropagation();
          dropdown.classList.toggle('active');
        });
        
        document.addEventListener('click', () => {
          dropdown.classList.remove('active');
        });
      }
    }
  },
  
  /**
   * Handle login form submission
   */
  async handleLogin(e) {
    e.preventDefault();
    
    const form = e.target;
    const email = form.querySelector('[name="email"]').value.trim();
    const password = form.querySelector('[name="password"]').value;
    const submitBtn = form.querySelector('button[type="submit"]');
    
    // Validate
    if (!email || !password) {
      Utils.showToast('Please fill in all fields', 'error');
      return;
    }
    
    if (!Utils.isValidEmail(email)) {
      Utils.showToast('Please enter a valid email', 'error');
      return;
    }
    
    // Disable button
    submitBtn.disabled = true;
    submitBtn.innerHTML = '<span class="spinner"></span> Signing in...';
    
    try {
      await API.auth.login(email, password);
      Utils.showToast('Login successful!', 'success');
      
      // Redirect based on role
      setTimeout(() => {
        if (API.auth.isAdmin()) {
          window.location.href = '/admin-dashboard.html';
        } else {
          window.location.href = '/user-dashboard.html';
        }
      }, 500);
    } catch (error) {
      Utils.showToast(error.message || 'Login failed', 'error');
      submitBtn.disabled = false;
      submitBtn.textContent = 'Sign In';
    }
  },
  
  /**
   * Handle registration form submission
   */
  async handleRegister(e) {
    e.preventDefault();
    
    const form = e.target;
    const name = form.querySelector('[name="name"]').value.trim();
    const email = form.querySelector('[name="email"]').value.trim();
    const phoneNumber = form.querySelector('[name="phoneNumber"]').value.trim();
    const password = form.querySelector('[name="password"]').value;
    const confirmPassword = form.querySelector('[name="confirmPassword"]').value;
    const submitBtn = form.querySelector('button[type="submit"]');
    
    // Validate
    if (!name || !email || !phoneNumber || !password || !confirmPassword) {
      Utils.showToast('Please fill in all fields', 'error');
      return;
    }
    
    if (!Utils.isValidEmail(email)) {
      Utils.showToast('Please enter a valid email', 'error');
      return;
    }
    
    if (!Utils.isValidPhone(phoneNumber)) {
      Utils.showToast('Please enter a valid 10-digit phone number', 'error');
      return;
    }
    
    if (password.length < 6) {
      Utils.showToast('Password must be at least 6 characters', 'error');
      return;
    }
    
    if (password !== confirmPassword) {
      Utils.showToast('Passwords do not match', 'error');
      return;
    }
    
    // Disable button
    submitBtn.disabled = true;
    submitBtn.innerHTML = '<span class="spinner"></span> Creating account...';
    
    try {
      await API.auth.register({ name, email, phoneNumber, password });
      Utils.showToast('Registration successful! Please login.', 'success');
      
      setTimeout(() => {
        window.location.href = '/login.html';
      }, 1500);
    } catch (error) {
      Utils.showToast(error.message || 'Registration failed', 'error');
      submitBtn.disabled = false;
      submitBtn.textContent = 'Create Account';
    }
  }
};

// Initialize on DOM ready
document.addEventListener('DOMContentLoaded', () => {
  Auth.init();
});
