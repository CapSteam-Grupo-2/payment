package com.capgeticket.payment.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;

@FeignClient (name="pasarela", url="http://proyectorestbanco-env.eba-2xzwedvv.eu-west-3.elasticbeanstalk.com")
public interface PayFeingPasarela {
	
	/**
	 * Solicita la validación del pay al microservicio pasarela
	 * @param payment
	 * @return
	 */
	@PostMapping("/pasarela/compra/")
	public PaymentResponse payValidation(@RequestBody Payment payment);

}
