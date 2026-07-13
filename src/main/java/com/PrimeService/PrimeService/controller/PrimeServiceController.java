package com.PrimeService.PrimeService.controller;

import com.PrimeService.PrimeService.model.PrimeResponse;
import com.PrimeService.PrimeService.service.PrimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/primes")
public class PrimeServiceController {

    private final PrimeService primeService;
    // Constructor injection
    public PrimeServiceController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping(
            value = "/{limit}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<PrimeResponse> getPrimes(@PathVariable int limit) {
        if (limit < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Please enter a positive number"
            );
  //          return ResponseEntity.badRequest().build();
        }

        List<Integer> primes = primeService.getPrimesUpTo(limit);
        PrimeResponse response = new PrimeResponse(limit, primes);
        return ResponseEntity.ok(response);
    }
}

