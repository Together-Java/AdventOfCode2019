package com.togetherjava.adventofcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4 {
	
	public static boolean isValidNumberPart1(int number) {
		int[] digits = String.valueOf(number).chars().map(n -> n - 48).toArray();
		int lastDigit = digits[0];
		boolean hasConsecutiveDigits = false;
		for(int i = 1; i < digits.length; i++) {
			int digit = digits[i];
			if (digit < lastDigit) {
				return false;
			}
			lastDigit = digit;
			if (digit == digits[i - 1]) {
				hasConsecutiveDigits = true;
			}
		}
		return hasConsecutiveDigits;
	}
	
	/**
	 * Written by Discord user and bae @Kemikals#3177
	 * I quite liked this better than mine so I decided to use this one instead
	 */
	public static int isValidNumberPart2(int[] valid) {
        List<String> stillValid = IntStream.of(valid).boxed().map(Object::toString).filter(f -> f.matches("^((\\d)\\2(?!\\2)\\d*|\\d*(\\d)(?!\\3)(\\d)\\4(?!\\4)\\d*)$")).collect(Collectors.toList());
        return stillValid.size();
    }
	
	public static void main(String[] args) {
		final int LOWER_LIMIT = 138307;
		final int UPPER_LIMIT = 654504;
		int[] validNumbers = IntStream.range(LOWER_LIMIT, UPPER_LIMIT).filter(Day4::isValidNumberPart1).toArray();
		System.out.println("Part 1) " + validNumbers.length);
		System.out.println("Part 2) " + isValidNumberPart2(validNumbers));
	}
}