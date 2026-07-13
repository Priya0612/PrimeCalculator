package com.PrimeService.PrimeService.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PrimeService {
    /**
     * Main entry point that automatically selects the best algorithm
     * based on the input threshold.
     */
    public List<Integer> getPrimesUpTo(int limit) {
        if (limit < 2) {
            return new ArrayList<>();
        }
        // Use the Sieve of Eratosthenes for limits up to 1,000,000
        if (limit <= 1_000_000) {
            return sieveOfEratosthenes(limit);
        } else {
            // Fallback or secondary algorithm for larger numbers
            return trialDivisionRange(limit);
        }
}
/**
 * ALGORITHM 1: Sieve of Eratosthenes
 * Time Complexity: O(N log log N) | Space Complexity: O(N)
 * Extremely fast for ranges up to 1M.
 */
private List<Integer> sieveOfEratosthenes(int limit) {
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    // Eliminate multiples up to the square root of the limit
    for (int p = 2; p * p <= limit; p++) {
        if (isPrime[p]) {
            // Mark all multiples of p starting from p*p as non-prime
            for (int i = p * p; i <= limit; i += p) {
                isPrime[i] = false;
            }
        }
    }

    // Collect all numbers that remained true
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
        if (isPrime[i]) {
            primes.add(i);
        }
    }
    return primes;
}
/**
 * ALGORITHM 2: Trial Division (Range Generation)
 * Time Complexity: O(N sqrt(N)) | Space Complexity: O(1) auxiliary
 * Slower, but uses virtually no setup memory.
 */
private List<Integer> trialDivisionRange(int limit) {
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
        if (isPrimeTrialDivision(i)) {
            primes.add(i);
        }
    }
    return primes;
}

/**
 * Helper method for individual primality testing via trial division
 */
private boolean isPrimeTrialDivision(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false; // Quick skip for even numbers

    // Check odd factors up to the square root of n
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}
}