package com.capgeticket.payment.services;

import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse pay(Payment payment);
	
	
}
