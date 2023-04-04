package com.capgeticket.payment;

import com.capgeticket.payment.controllers.PaymentController;
import com.capgeticket.payment.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    @MockBean
    private PaymentService service;

    @Autowired
    private PaymentController controller;

    @Test
    public void payTest_OK(){

    }
}
