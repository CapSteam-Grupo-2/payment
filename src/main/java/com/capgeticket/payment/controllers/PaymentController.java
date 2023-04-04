package com.capgeticket.payment.controllers;

import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/new")
    public ResponseEntity<PaymentResponse> pay(@Valid @RequestBody Payment payment) {
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
