package com.audaz.audaz.controller;

import com.audaz.audaz.model.Operator;
import com.audaz.audaz.model.OperatorDTO;
import com.audaz.audaz.service.OperatorService;
import com.audaz.audaz.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    
    @Autowired
    private OperatorService operatorService;

    @PostMapping
    public ResponseEntity<OperatorDTO> criar(@Validated @RequestBody OperatorDTO Operator){
        return new ResponseEntity<>(operatorService.criar(Operator), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OperatorDTO>> consultarTodos(){
        return new ResponseEntity<>(operatorService.consultarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{code}/code")
    public ResponseEntity<OperatorDTO> consultarPorCode(@PathVariable String code){
        return new ResponseEntity<>(operatorService.consultarPorCode(code), HttpStatus.OK);
    }
}
