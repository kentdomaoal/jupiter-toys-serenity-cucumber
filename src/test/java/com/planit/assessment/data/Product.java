package com.planit.assessment.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

    private String id;
    @NonNull private String name;
    @NonNull private int quantity;
    private Float price;
    private String category;

}
