package com.capgeticket.payment.controllers;

import com.capgeticket.payment.error.BadRequestException;
import com.capgeticket.payment.error.InternalServerException;
import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import com.capgeticket.payment.services.PaymentService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/new")
    public ResponseEntity<PaymentResponse> pay(@RequestBody Payment payment) {
        var response = service.pay(payment);
        if ("200.0001".equals(response.getStatus())) {
            response.setError(null);
            response.setStatus(null);
            return ResponseEntity.ok(response);
        }
        if (response.getStatus().contains("400")) {
            response.setStatus("400");
            throw new BadRequestException(response.getMessage().toString());
        }
        if ("500.0001".equals(response.getStatus())) { //inestable
            response.setStatus("500");
            throw new InternalServerException();
        }

        return null;
    }
}
