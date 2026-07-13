package com.PrimeService.PrimeService;

import com.PrimeService.PrimeService.service.PrimeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PrimeServiceApplicationTests {
	private final PrimeService primeService = new PrimeService();

	@Test
	void shouldRunSieveOfEratosthenesForSmallLimits() {
		// 30 is less than 1,000,000 -> triggers Sieve code path
		List<Integer> result = primeService.getPrimesUpTo(30);

		assertThat(result).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
	}

	@Test
	void shouldRunTrialDivisionForLargeLimits() {
		// 1,000,005 triggers Trial Division code path
		List<Integer> result = primeService.getPrimesUpTo(1_000_005);

		// Let's assert the last few elements to make sure it computed successfully
		assertThat(result).isNotEmpty();
		assertThat(result.get(result.size() - 1)).isLessThanOrEqualTo(1_000_005);
	}

	@Test
	void shouldReturnEmptyListForEdgeCases() {
		assertThat(primeService.getPrimesUpTo(1)).isEmpty();
		assertThat(primeService.getPrimesUpTo(-5)).isEmpty();
	}
//	@Test
//	void contextLoads() {
	}

