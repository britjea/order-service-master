package br.com.fiap.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Item {

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(quantity).setScale(2));
    }
}
