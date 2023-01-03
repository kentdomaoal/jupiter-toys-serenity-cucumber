package com.project.example.data;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

    private String id;

    @NonNull
    @CsvBindByName(column = "productName")
    private String name;
    @NonNull
    @CsvBindByName
    private int quantity;
    private Float price;
    private String category;

}
