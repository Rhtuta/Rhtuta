/**
 * BookMyShow Clone - Utility Functions
 */

const Utils = {
  /**
   * Show toast notification
   */
  showToast(message, type = 'info', duration = 4000) {
    let container = document.getElementById('toast-container');
    if (!container) {
      container = document.createElement('div');
      container.id = 'toast-container';
      container.className = 'toast-container';
      document.body.appendChild(container);
    }
    
    const icons = {
      success: '✓',
      error: '✕',
      warning: '⚠',
      info: 'ℹ'
    };
    
    const titles = {
      success: 'Success',
      error: 'Error',
      warning: 'Warning',
      info: 'Info'
    };
    
    const toast = document.createElement('div');
    toast.className = `toast ${type}`;
    toast.innerHTML = `
      <span class="toast-icon">${icons[type]}</span>
      <div class="toast-content">
        <div class="toast-title">${titles[type]}</div>
        <div class="toast-message">${message}</div>
      </div>
      <button class="toast-close">&times;</button>
    `;
    
    container.appendChild(toast);
    
    const closeBtn = toast.querySelector('.toast-close');
    closeBtn.addEventListener('click', () => {
      toast.remove();
    });
    
    setTimeout(() => {
      toast.style.animation = 'slideIn 0.3s ease reverse';
      setTimeout(() => toast.remove(), 300);
    }, duration);
  },
  
  /**
   * Show loader
   */
  showLoader(text = 'Loading...') {
    let loader = document.getElementById('global-loader');
    if (!loader) {
      loader = document.createElement('div');
      loader.id = 'global-loader';
      loader.className = 'loader-overlay';
      loader.innerHTML = `
        <div class="text-center">
          <div class="loader"></div>
          <div class="loader-text">${text}</div>
        </div>
      `;
      document.body.appendChild(loader);
    } else {
      loader.querySelector('.loader-text').textContent = text;
      loader.style.display = 'flex';
    }
  },
  
  /**
   * Hide loader
   */
  hideLoader() {
    const loader = document.getElementById('global-loader');
    if (loader) {
      loader.style.display = 'none';
    }
  },
  
  /**
   * Format date
   */
  formatDate(dateString, options = {}) {
    const date = new Date(dateString);
    const defaultOptions = {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
      ...options
    };
    return date.toLocaleDateString('en-US', defaultOptions);
  },
  
  /**
   * Format time
   */
  formatTime(dateString) {
    const date = new Date(dateString);
    return date.toLocaleTimeString('en-US', {
      hour: '2-digit',
      minute: '2-digit',
      hour12: true
    });
  },
  
  /**
   * Format date and time
   */
  formatDateTime(dateString) {
    return `${this.formatDate(dateString)} ${this.formatTime(dateString)}`;
  },
  
  /**
   * Format currency
   */
  formatCurrency(amount) {
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: 'INR',
      minimumFractionDigits: 0
    }).format(amount);
  },
  
  /**
   * Format duration in minutes to hours and minutes
   */
  formatDuration(minutes) {
    const hours = Math.floor(minutes / 60);
    const mins = minutes % 60;
    if (hours > 0) {
      return `${hours}h ${mins}m`;
    }
    return `${mins}m`;
  },
  
  /**
   * Get initials from name
   */
  getInitials(name) {
    if (!name) return '?';
    return name
      .split(' ')
      .map(word => word[0])
      .join('')
      .toUpperCase()
      .substring(0, 2);
  },
  
  /**
   * Debounce function
   */
  debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
      const later = () => {
        clearTimeout(timeout);
        func(...args);
      };
      clearTimeout(timeout);
      timeout = setTimeout(later, wait);
    };
  },
  
  /**
   * Check if user is authenticated
   */
  requireAuth(redirectUrl = '/login.html') {
    if (!API.auth.isLoggedIn()) {
      window.location.href = redirectUrl;
      return false;
    }
    return true;
  },
  
  /**
   * Check if user is admin
   */
  requireAdmin(redirectUrl = '/user-dashboard.html') {
    if (!API.auth.isAdmin()) {
      window.location.href = redirectUrl;
      return false;
    }
    return true;
  },
  
  /**
   * Get URL parameters
   */
  getUrlParams() {
    return Object.fromEntries(new URLSearchParams(window.location.search));
  },
  
  /**
   * Set URL parameter
   */
  setUrlParam(key, value) {
    const url = new URL(window.location);
    url.searchParams.set(key, value);
    window.history.pushState({}, '', url);
  },
  
  /**
   * Remove URL parameter
   */
  removeUrlParam(key) {
    const url = new URL(window.location);
    url.searchParams.delete(key);
    window.history.pushState({}, '', url);
  },
  
  /**
   * Escape HTML to prevent XSS
   */
  escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
  },
  
  /**
   * Generate random ID
   */
  generateId() {
    return Math.random().toString(36).substring(2, 15);
  },
  
  /**
   * Store data in session storage
   */
  setSession(key, value) {
    sessionStorage.setItem(key, JSON.stringify(value));
  },
  
  /**
   * Get data from session storage
   */
  getSession(key) {
    const data = sessionStorage.getItem(key);
    return data ? JSON.parse(data) : null;
  },
  
  /**
   * Remove data from session storage
   */
  removeSession(key) {
    sessionStorage.removeItem(key);
  },
  
  /**
   * Validate email format
   */
  isValidEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  },
  
  /**
   * Validate phone number (Indian format)
   */
  isValidPhone(phone) {
    const re = /^[6-9]\d{9}$/;
    return re.test(phone.replace(/\D/g, ''));
  },
  
  /**
   * Truncate text with ellipsis
   */
  truncate(text, maxLength = 100) {
    if (text.length <= maxLength) return text;
    return text.substring(0, maxLength) + '...';
  },
  
  /**
   * Open modal
   */
  openModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
      modal.classList.add('active');
      document.body.style.overflow = 'hidden';
    }
  },
  
  /**
   * Close modal
   */
  closeModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
      modal.classList.remove('active');
      document.body.style.overflow = '';
    }
  },
  
  /**
   * Close all modals
   */
  closeAllModals() {
    document.querySelectorAll('.modal-overlay.active').forEach(modal => {
      modal.classList.remove('active');
    });
    document.body.style.overflow = '';
  },
  
  /**
   * Confirm dialog
   */
  async confirm(message, title = 'Confirm') {
    return new Promise((resolve) => {
      const modalId = 'confirm-modal-' + this.generateId();
      const modal = document.createElement('div');
      modal.id = modalId;
      modal.className = 'modal-overlay active';
      modal.innerHTML = `
        <div class="modal">
          <div class="modal-header">
            <h3>${title}</h3>
          </div>
          <div class="modal-body">
            <p>${message}</p>
          </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" data-action="cancel">Cancel</button>
            <button class="btn btn-primary" data-action="confirm">Confirm</button>
          </div>
        </div>
      `;
      document.body.appendChild(modal);
      
      modal.querySelector('[data-action="cancel"]').addEventListener('click', () => {
        modal.remove();
        resolve(false);
      });
      
      modal.querySelector('[data-action="confirm"]').addEventListener('click', () => {
        modal.remove();
        resolve(true);
      });
    });
  }
};

// Export for module usage
if (typeof module !== 'undefined' && module.exports) {
  module.exports = Utils;
}
