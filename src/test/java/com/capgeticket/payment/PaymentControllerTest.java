package com.capgeticket.payment;

import com.capgeticket.payment.controllers.PaymentController;
import com.capgeticket.payment.models.Payment;
import com.capgeticket.payment.responses.PaymentResponse;
import com.capgeticket.payment.services.PaymentService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    private Payment payment;
    private PaymentResponse response;
    @MockBean
    private PaymentService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentController controller;

    @BeforeEach
    private void addData(){
        payment = Payment.builder()
                .nombreTitular("alba")
                .numeroTarjeta("4011009633298385")
                .cvv("134")
                .mesCaducidad("06")
                .yearCaducidad("2026")
                .emisor("bbva")
                .cantidad("12344")
                .concepto("nomina")
                .build();
        response = PaymentResponse.builder()
                .timestamp("05/04/2023 08:05:01")
                .error("Bad Request")
                .info(payment)
                .infoadicional("")
                .message(List.of("hola hola"))
                .status("200")
                .build();
    }

    @Test
    public void payTest_responseOK(){
        Mockito.when(service.pay(payment)).thenReturn(response);
        assertThat(ResponseEntity.ok(response)).isEqualTo(controller.pay(payment));
    }
    @Test
    public void payTest_responseBadRequest(){
        response.setStatus("400");
        Mockito.when(service.pay(payment)).thenReturn(response);
        assertThat(ResponseEntity.badRequest().body(response)).isEqualTo(controller.pay(payment));
    }

    @Test
    public void payTest_responseError(){
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);
        assertThat(ResponseEntity.internalServerError().body(response)).isEqualTo(controller.pay(payment));
    }

    @Test
    public void payTest_withoutNombre_responseError() throws Exception {
        payment.setNombreTitular(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }

    @Test
    public void payTest_withoutTajeta_responseError() throws Exception {
        payment.setNumeroTarjeta(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }

    @Test
    public void payTest_withoutCVV_responseError() throws Exception {
        payment.setCvv(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }

    @Test
    public void payTest_withoutYear_responseError() throws Exception {
        payment.setYearCaducidad(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }

    @Test
    public void payTest_withoutMes_responseError() throws Exception {
        payment.setNumeroTarjeta(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }

    @Test
    public void payTest_withoutCantidad_responseError() throws Exception {
        payment.setCantidad(null);
        response.setStatus("500");
        Mockito.when(service.pay(payment)).thenReturn(response);

        var result = controller.pay(payment);
        assertThat(result).isEqualTo(ResponseEntity.internalServerError().body(response));
    }


}
