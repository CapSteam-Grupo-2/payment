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

	/**
	 * Metodo para enviar pago y recibir una validacion
	 * 
	 * @param payment
	 * @return PaymentResponse
	 */
	@Override
	public PaymentResponse pay(Payment payment) {

		return payFeing.payValidation(payment);
	}

}
