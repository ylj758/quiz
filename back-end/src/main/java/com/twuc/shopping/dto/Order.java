package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @NotEmpty
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer count;
    @NotEmpty
    private String unit;
}
