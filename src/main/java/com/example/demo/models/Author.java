package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Author {
    private String id;
    private String firstName;
    private String lastName;
}
