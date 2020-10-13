package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;
}
