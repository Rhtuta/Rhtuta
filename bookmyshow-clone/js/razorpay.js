/**
 * BookMyShow Clone - Razorpay Payment Handler
 */

const RazorpayHandler = {
  RAZORPAY_KEY: 'rzp_test_SleIdfeUkCWNs1',
  
  /**
   * Initialize Razorpay payment
   */
  async initiatePayment(bookingData, onSuccess, onFailure) {
    const { razorpayOrderId, razorpayKey, razorpayAmount, bookingNumber } = bookingData;
    
    // Load Razorpay script if not already loaded
    if (!window.Razorpay) {
      await this.loadRazorpayScript();
    }
    
    const options = {
      key: razorpayKey || this.RAZORPAY_KEY,
      amount: razorpayAmount,
      currency: 'INR',
      name: 'BookMyShow',
      description: `Booking: ${bookingNumber}`,
      order_id: razorpayOrderId,
      handler: async (response) => {
        try {
          Utils.showLoader('Processing payment...');
          
          // Update payment status on backend
          await API.payments.updateOrder(
            response.razorpay_payment_id,
            response.razorpay_order_id,
            'SUCCESS',
            'RAZORPAY'
          );
          
          Utils.hideLoader();
          
          if (onSuccess) {
            onSuccess(response);
          } else {
            // Default success behavior
            Utils.setSession('lastBooking', {
              bookingNumber,
              paymentId: response.razorpay_payment_id,
              amount: razorpayAmount / 100
            });
            window.location.href = '/payment-success.html';
          }
        } catch (error) {
          Utils.hideLoader();
          Utils.showToast('Payment verification failed', 'error');
          if (onFailure) onFailure(error);
        }
      },
      modal: {
        ondismiss: async () => {
          // Handle payment modal dismissal
          try {
            await API.payments.updateOrder(
              '',
              razorpayOrderId,
              'FAILED',
              'RAZORPAY'
            );
          } catch (e) {
            console.error('Failed to update cancelled payment', e);
          }
          
          Utils.showToast('Payment cancelled', 'warning');
          if (onFailure) onFailure(new Error('Payment cancelled'));
        }
      },
      prefill: {
        email: localStorage.getItem('email') || '',
        contact: ''
      },
      theme: {
        color: '#f84464'
      }
    };
    
    const razorpay = new Razorpay(options);
    
    razorpay.on('payment.failed', async (response) => {
      try {
        await API.payments.updateOrder(
          response.error.metadata.payment_id || '',
          razorpayOrderId,
          'FAILED',
          'RAZORPAY'
        );
      } catch (e) {
        console.error('Failed to update failed payment', e);
      }
      
      Utils.showToast(`Payment failed: ${response.error.description}`, 'error');
      if (onFailure) onFailure(response.error);
    });
    
    razorpay.open();
  },
  
  /**
   * Load Razorpay script dynamically
   */
  loadRazorpayScript() {
    return new Promise((resolve, reject) => {
      if (window.Razorpay) {
        resolve();
        return;
      }
      
      const script = document.createElement('script');
      script.src = 'https://checkout.razorpay.com/v1/checkout.js';
      script.async = true;
      script.onload = resolve;
      script.onerror = reject;
      document.head.appendChild(script);
    });
  }
};

// Export for module usage
if (typeof module !== 'undefined' && module.exports) {
  module.exports = RazorpayHandler;
}
