/**
 * BookMyShow Clone - API Service
 * Handles all HTTP requests to the backend
 */

const API = {
  BASE_URL: 'http://localhost:8080',
  
  /**
   * Get authorization headers
   */
  getHeaders(includeAuth = true) {
    const headers = {
      'Content-Type': 'application/json'
    };
    
    if (includeAuth) {
      const token = localStorage.getItem('token');
      if (token) {
        headers['Authorization'] = `Bearer ${token}`;
      }
    }
    
    return headers;
  },
  
  /**
   * Generic request handler
   */
  async request(endpoint, options = {}) {
    const url = `${this.BASE_URL}${endpoint}`;
    const config = {
      headers: this.getHeaders(options.auth !== false),
      ...options
    };
    
    // Remove custom properties
    delete config.auth;
    
    try {
      const response = await fetch(url, config);
      
      // Handle 401 Unauthorized
      if (response.status === 401) {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        localStorage.removeItem('email');
        window.location.href = '/login.html';
        throw new Error('Session expired. Please login again.');
      }
      
      // Handle 403 Forbidden
      if (response.status === 403) {
        throw new Error('You do not have permission to perform this action.');
      }
      
      // Handle no content
      if (response.status === 204) {
        return null;
      }
      
      const contentType = response.headers.get('content-type');
      let data;
      
      if (contentType && contentType.includes('application/json')) {
        data = await response.json();
      } else {
        data = await response.text();
      }
      
      if (!response.ok) {
        throw new Error(data.message || data || 'Request failed');
      }
      
      return data;
    } catch (error) {
      console.error('API Error:', error);
      throw error;
    }
  },
  
  // ==========================================
  // AUTH APIs
  // ==========================================
  auth: {
    async login(email, password) {
      const data = await API.request('/api/auth/login', {
        method: 'POST',
        body: JSON.stringify({ email, password }),
        auth: false
      });
      
      if (data.token) {
        localStorage.setItem('token', data.token);
        // Decode JWT to get role
        const payload = JSON.parse(atob(data.token.split('.')[1]));
        localStorage.setItem('role', payload.role || 'USER');
        localStorage.setItem('email', email);
      }
      
      return data;
    },
    
    async register(userData) {
      return API.request('/api/auth/register', {
        method: 'POST',
        body: JSON.stringify(userData),
        auth: false
      });
    },
    
    logout() {
      localStorage.removeItem('token');
      localStorage.removeItem('role');
      localStorage.removeItem('email');
      window.location.href = '/login.html';
    },
    
    isLoggedIn() {
      return !!localStorage.getItem('token');
    },
    
    getRole() {
      return localStorage.getItem('role');
    },
    
    isAdmin() {
      return this.getRole() === 'ADMIN';
    }
  },
  
  // ==========================================
  // USER APIs
  // ==========================================
  users: {
    async getProfile() {
      return API.request('/api/users/me');
    },
    
    async getById(id) {
      return API.request(`/api/admin/users/${id}`);
    },
    
    async getAll() {
      return API.request('/api/admin/users');
    },
    
    async update(id, userData) {
      return API.request(`/api/users/update?id=${id}`, {
        method: 'PATCH',
        body: JSON.stringify(userData)
      });
    },
    
    async delete(id) {
      return API.request(`/api/admin/users/delete/${id}`, {
        method: 'DELETE'
      });
    }
  },
  
  // ==========================================
  // MOVIE APIs
  // ==========================================
  movies: {
    async create(movieData) {
      return API.request('/api/admin/movies', {
        method: 'POST',
        body: JSON.stringify(movieData)
      });
    },
    
    async getById(id) {
      return API.request(`/api/movies/${id}`);
    },
    
    async getAll() {
      return API.request('/api/movies');
    },
    
    async getByLanguage(language) {
      return API.request(`/api/movies/language/${encodeURIComponent(language)}`);
    },
    
    async getByGenre(genre) {
      return API.request(`/api/movies/genre/${encodeURIComponent(genre)}`);
    },
    
    async getByTitle(title) {
      return API.request(`/api/movies/title/${encodeURIComponent(title)}`);
    },
    
    async update(id, movieData) {
      return API.request(`/api/admin/movies/update?id=${id}`, {
        method: 'PATCH',
        body: JSON.stringify(movieData)
      });
    },
    
    async delete(id) {
      return API.request(`/api/admin/movies/delete/${id}`, {
        method: 'DELETE'
      });
    }
  },
  
  // ==========================================
  // SHOW APIs
  // ==========================================
  shows: {
    async create(showData) {
      return API.request('/api/admin/shows', {
        method: 'POST',
        body: JSON.stringify(showData)
      });
    },
    
    async getById(id) {
  return API.request(`/api/shows/${id}`);
},
    
    async getAll() {
      return API.request('/api/shows');
    },
    
    async getByMovie(movieId) {
      return API.request(`/api/shows/movie?movieId=${movieId}`);
    },
    
    async getFiltered(movieId, city) {
      let url = '/api/shows/filter?';
      if (movieId) url += `movieId=${movieId}&`;
      if (city) url += `city=${encodeURIComponent(city)}`;
      return API.request(url);
    },
    
    async getByDateRange(startDate, endDate) {
      return API.request(`/api/shows/range?startDate=${startDate}&endDate=${endDate}`);
    }
  },
  
  // ==========================================
  // BOOKING APIs
  // ==========================================
  bookings: {
    async create(showId, seatIds) {
      return API.request('/api/bookings', {
        method: 'POST',
        body: JSON.stringify({ showId, seatIds })
      });
    },
    
    async getAll() {
      return API.request('/api/admin/bookings');
    },
    
    async getMyBookings() {
      return API.request('/api/bookings/my');
    },
    
    async getById(id) {
      return API.request(`/api/admin/bookings/${id}`);
    },
    
    async getByBookingNumber(bookingNumber) {
      return API.request(`/api/admin/bookings/bookingNumber/${bookingNumber}`);
    },
    
    async getByUser(userId) {
      return API.request(`/api/admin/bookings/user?userId=${userId}`);
    },
    
    async cancel(id) {
      return API.request(`/api/bookings/cancel/${id}`, {
        method: 'PATCH'
      });
    }
  },
  
  // ==========================================
  // PAYMENT APIs
  // ==========================================
  payments: {
    async updateOrder(paymentId, orderId, status, paymentMethod) {
      const params = new URLSearchParams({
        paymentId,
        orderId,
        status,
        paymentMethod
      });
      return API.request(`/api/payment/update-order?${params}`, {
        method: 'POST'
      });
    }
  },
  
  // ==========================================
  // THEATER APIs
  // ==========================================
  theaters: {
    async create(theaterData) {
      return API.request('/api/admin/theaters', {
        method: 'POST',
        body: JSON.stringify(theaterData)
      });
    },
    
    async getAll() {
      return API.request('/api/theaters');
    },
    
    async getById(id) {
      return API.request(`/api/admin/theaters/${id}`);
    },
    
    async getByCity(city) {
      return API.request(`/api/theaters/city/${encodeURIComponent(city)}`);
    },
    
    async update(id, theaterData) {
      return API.request(`/api/admin/theaters/update?id=${id}`, {
        method: 'PATCH',
        body: JSON.stringify(theaterData)
      });
    },
    
    async delete(id) {
      return API.request(`/api/admin/theaters/delete/${id}`, {
        method: 'DELETE'
      });
    }
  },
  
  // ==========================================
  // SCREEN APIs
  // ==========================================
  screens: {
    async create(screenData) {
      return API.request('/api/admin/screens', {
        method: 'POST',
        body: JSON.stringify(screenData)
      });
    },
    
    async getById(id) {
      return API.request(`/api/screens/${id}`);
    },
    
    async getAll() {
      return API.request('/api/screens');
    },
    
    async getByTheater(theaterId) {
      return API.request(`/api/screens/theater/${theaterId}`);
    },
    
    async update(id, screenData) {
      return API.request(`/api/admin/screens/update?id=${id}`, {
        method: 'PATCH',
        body: JSON.stringify(screenData)
      });
    },
    
    async delete(id) {
      return API.request(`/api/admin/screens/delete/${id}`, {
        method: 'DELETE'
      });
    }
  },
  
  // ==========================================
  // SEAT APIs
  // ==========================================
  seats: {
    async create(screenId, seatData) {
      return API.request(`/api/admin/seats/${screenId}`, {
        method: 'POST',
        body: JSON.stringify(seatData)
      });
    },
    
    async getByScreen(screenId) {
      return API.request(`/api/seats/screen/${screenId}`);
    }
  }
};

// Export for module usage
if (typeof module !== 'undefined' && module.exports) {
  module.exports = API;
}
