package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotEmpty
    private String name;
    @NotNull
    private Double price;
    @NotEmpty
    private String unit;
    @NotEmpty
    private String img;
}
