package com.PrimeService.PrimeService.model;

import java.util.List;

public class PrimeResponse {

    private int initial;
    private List<Integer> prime;

    public PrimeResponse() {
    }

    public PrimeResponse(int initial, List<Integer> prime) {
        this.initial = initial;
        this.prime = prime;
    }
    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public List<Integer> getPrime() {
        return prime;
    }

    public void setPrime(List<Integer> prime) {
        this.prime = prime;
    }
}