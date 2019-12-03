package com.togetherjava.adventofcode;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.togetherjava.adventofcode.util.ResourceLoader;

public class Day1 {

	public static void main(String[] args) {
		Supplier<Stream<Double>> input = () -> ResourceLoader.getInput("Day1Inputs.txt").stream().map(Double::parseDouble);
		double part1 = input.get().mapToDouble(Day1::calculateFuel).sum();
		double part2 = input.get().mapToDouble(Day1::recursiveCalculateFuel).sum();
		System.out.println("Part 1 answer: " + part1);
		System.out.println("Part 2 answer: " + part2);
	}

	public static double recursiveCalculateFuel(double mass) {
		double fuel = calculateFuel(mass);
		if (fuel <= 0) {
			return 0D;
		}
		return fuel + recursiveCalculateFuel(fuel);
	}

	public static double calculateFuel(double mass) {
		return Math.floor(mass / 3.0) - 2;
	}
}