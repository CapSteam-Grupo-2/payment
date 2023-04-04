package com.capgeticket.payment.responses;

import com.capgeticket.payment.models.Payment;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private String timestamp;
    private String status;
    private String error;
    private List<String> message;
    private Payment info;
    private String infoadicional;
}
