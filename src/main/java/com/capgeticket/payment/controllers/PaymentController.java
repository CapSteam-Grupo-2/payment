package com.capgeticket.payment.controllers;

import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import com.capgeticket.payment.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        var result = service.pay(payment);
        if ("200".equals(result.getStatus())) {
            result.setStatus(null);
            return ResponseEntity.ok().body(result);
        } else if ("400".equals(result.getStatus())) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.internalServerError().body(result);
    }
}


