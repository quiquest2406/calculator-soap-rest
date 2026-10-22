package com.example.calculator.controller;

import com.example.calculator.client.CalculatorSoapClient;
import com.example.calculator.dto.OperacionRequest;
import com.example.calculator.dto.OperacionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorSoapClient soapClient;

    public CalculatorController(CalculatorSoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @PostMapping("/add")
    public ResponseEntity<OperacionResponse> add(
            @RequestBody OperacionRequest request) {

        if (request == null
                || request.getA() == null
                || request.getB() == null) {
            return ResponseEntity.badRequest().build();
        }

        int result = soapClient.add(
                request.getA(),
                request.getB());

        return ResponseEntity.ok(
                new OperacionResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<OperacionResponse> subtract(
            @RequestBody OperacionRequest request) {

        if (request == null
                || request.getA() == null
                || request.getB() == null) {
            return ResponseEntity.badRequest().build();
        }

        int result = soapClient.subtract(
                request.getA(),
                request.getB());

        return ResponseEntity.ok(
                new OperacionResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<OperacionResponse> multiply(
            @RequestBody OperacionRequest request) {

        if (request == null
                || request.getA() == null
                || request.getB() == null) {
            return ResponseEntity.badRequest().build();
        }

        int result = soapClient.multiply(
                request.getA(),
                request.getB());

        return ResponseEntity.ok(
                new OperacionResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<OperacionResponse> divide(
            @RequestBody OperacionRequest request) {

        if (request == null
                || request.getA() == null
                || request.getB() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (request.getB() == 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        int result = soapClient.divide(
                request.getA(),
                request.getB());

        return ResponseEntity.ok(
                new OperacionResponse(result));
    }
}

