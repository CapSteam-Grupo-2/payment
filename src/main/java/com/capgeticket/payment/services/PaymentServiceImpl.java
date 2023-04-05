package com.capgeticket.payment.services;

import com.capgeticket.payment.feing.PayFeingPasarela;
import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PaymentResponse paym = payFeing.payValidation(payment);

        if ("200.0001".equals(paym.getStatus())) {
            paym.setError(null);
            paym.setStatus("200");
        } else if (paym.getStatus().contains("400")) {
            paym.setStatus("400");
            paym.setInfo(null);
            paym.setInfoadicional(null);
        } else if ("500.0001".equals(paym.getStatus())) {
            paym.setStatus("500");
            paym.setInfo(null);
            paym.setInfoadicional(null);
        }
        return paym;
    }

}
