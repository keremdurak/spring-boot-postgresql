package com.durakkerem.controller;


import com.durakkerem.repository.PersonRepository;
import com.durakkerem.service.PersonService;
import com.durakkerem.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private  final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> addPerson (@RequestBody PersonDto personDto){
        return  ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> allPersonList(){

        return ResponseEntity.ok(personService.getAll());
    }
}
