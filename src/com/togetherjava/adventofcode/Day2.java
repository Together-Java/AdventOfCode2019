package com.togetherjava.adventofcode;

import java.util.Arrays;

import com.togetherjava.adventofcode.util.ResourceLoader;

public class Day2 {

	public static void main(String[] args) {
		String[] input = ResourceLoader.getInput("Day2Inputs.txt").get(0).split(",");
		int[] data = new int[input.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(input[i]);
		}
		System.out.println("Part 1)");
		int[] part1 = Arrays.copyOf(data, data.length);
		//part 1 noun = 2 verb = 12
		System.out.println(calculate(part1, 12, 2)[0]);
		for(int verb = 0; verb < 100; verb++) {
			for(int noun = 0; noun < 100; noun++) {
				int[] part2 = Arrays.copyOf(data, data.length);
				int[] temp = calculate(part2, noun, verb);
				if(temp[0] == 19690720) {
					System.out.println("Part 2)");
					System.out.printf("FOUND NOUN = %d VERB = %d\n", noun, verb);
					System.out.printf("100 * %d + %d = %d", noun, verb, 100 * noun + verb);
				}
			}
		}
	}
	
	public static int[] calculate(int[] data, int noun, int verb) {
		data[1] = noun;
		data[2] = verb;
		int i = 0;
		while (i < data.length) {
			int opcode = data[i];
			if (opcode == 1) {
				int aPosition = data[i + 1];
				int bPosition = data[i + 2];
				int positionToStore = data[i + 3];
				int a = data[aPosition];
				int b = data[bPosition];
				data[positionToStore] = a + b;
				i += 4;
			} else if (opcode == 2) {
				int aPosition = data[i + 1];
				int bPosition = data[i + 2];
				int positionToStore = data[i + 3];
				int a = data[aPosition];
				int b = data[bPosition];
				data[positionToStore] = a * b;
				i += 4;
			} else if (opcode == 99) {
				break;
			}
		}
		return data;
	}
}
