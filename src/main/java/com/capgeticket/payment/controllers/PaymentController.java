package com.capgeticket.payment.controllers;

import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import com.capgeticket.payment.services.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Realiza un pago", description = "Realiza un pago", tags = {"payment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pago realizado correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Fallo en los datos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Servicio inestable", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))})})
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
