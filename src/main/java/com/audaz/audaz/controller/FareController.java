package com.audaz.audaz.controller;

import com.audaz.audaz.model.Fare;
import com.audaz.audaz.model.FareDTO;
import com.audaz.audaz.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fare")
public class FareController {

    @Autowired
    private FareService fareService;

    @PostMapping
    public ResponseEntity<FareDTO> criar(@RequestBody FareDTO fareDTO) throws Exception {
        return new ResponseEntity<>(fareService.criar(fareDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FareDTO>> consultarTodos(){
        return new ResponseEntity<>(fareService.consultarTodos(), HttpStatus.OK);
    }
}
