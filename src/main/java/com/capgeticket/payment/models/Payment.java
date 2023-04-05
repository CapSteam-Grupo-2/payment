package com.capgeticket.payment.models;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @NotEmpty(message = "El nombre es un campo obligatorio")
    private String nombreTitular;

    @NotEmpty(message = "El numero de la tarjeta es un campo obligatorio")
    private String numeroTarjeta;

    @NotEmpty(message = "El mes de caducidad de la tarjeta es un campo obligatorio")
    private String mesCaducidad;

    @NotEmpty(message = "El año de caducidad de la tarjeta es un campo obligatorio")
    private String yearCaducidad;

    @NotEmpty(message = "El cvv de la tarjeta es un campo obligatorio")
    private String cvv;

    @NotEmpty(message = "El emisor del pago es un campo obligatorio")
    private String emisor;

    @NotEmpty(message = "El concepto del pago es un campo obligatorio")
    private String concepto;

    @NotEmpty(message = "La cantidad del pago es un campo obligatorio")
    private String cantidad;
}
