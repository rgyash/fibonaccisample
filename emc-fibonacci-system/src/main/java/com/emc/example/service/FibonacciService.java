package com.emc.example.service;

import org.springframework.stereotype.Service;

import com.emc.example.exception.FibonacciServiceException;
import com.google.gson.Gson;

@Service
public class FibonacciService {

	// Need to put in properties files
	// Putting an upper bound to avoid 
	private static final Integer maxFibonacciSequnce = 100000;

	public String findSeriesofFibonacciNums(final Integer number)
			throws FibonacciServiceException {
		if (number < 0)
			throw new FibonacciServiceException(
					"The series of Fibonacci can not be negative");
		else if (number > maxFibonacciSequnce)
			throw new FibonacciServiceException(
					"The series of Fibonacci can not be greater than "
							+ maxFibonacciSequnce);

		long[] fibonacciSeries = new long[number];
		if (number > 1)
			fibonacciSeries[1] = 1;
		for (int ctr = 2; ctr < number; ctr++)
			fibonacciSeries[ctr] = fibonacciSeries[ctr - 1] + fibonacciSeries[ctr - 2];
		Gson gson = new Gson();
		return gson.toJson(fibonacciSeries);
	}
}
