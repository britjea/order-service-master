package br.com.fiap.orderservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Order {

    private Long id;

    private String fullName;

    private String email;

    private String shippingAddress;

    private List<Item> items = new ArrayList<>();

    private BigDecimal totalPrice;

    private PaymentMode paymentMode;

    @JsonFormat(pattern = "MM/dd/yyyy",
            shape = JsonFormat.Shape.STRING,
            locale = "pt-BR",
            timezone = "Brazil/East")
    private Date orderDate;

    private Status status;

    private Transaction transaction;



}
