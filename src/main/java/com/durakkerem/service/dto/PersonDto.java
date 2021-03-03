package com.durakkerem.service.dto;

import com.durakkerem.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private List<String> addresses;
}
