package com.capgeticket.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.payment.feing.PayFeingPasarela;
import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PayFeingPasarela payFeing;

	@Override
	public PaymentResponse pay(Payment payment) {
		
		final PaymentResponse paymentResponse = payFeing.payValidation(payment);
		return paymentResponse;
	}
	
	

}
