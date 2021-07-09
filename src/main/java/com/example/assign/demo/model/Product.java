package com.example.assign.demo.model;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Product {

    private Long prodId;
    @NonNull private String prodName;
    @NonNull private int prodPrice;
}
