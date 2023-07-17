package com.cybersoft.baitapkhoa4.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder
@AllArgsConstructor
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Byte age;
}
