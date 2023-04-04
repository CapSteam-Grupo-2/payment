package com.capgeticket.payment.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String nombreTitular;
    private String numeroTarjeta;
    private String mesCaducidad;
    private String yearCaducidad;
    private String cvv;
    private String emisor;
    private String concepto;
    private String cantidad;
}
