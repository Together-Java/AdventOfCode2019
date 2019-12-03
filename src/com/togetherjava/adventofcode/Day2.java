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
		int[] dataClone = Arrays.copyOf(data, data.length);
		System.out.println("Part 1) " + calculate(dataClone, 12, 2)[0]);
		for(int verb = 0; verb < 100; verb++) {
			for(int noun = 0; noun < 100; noun++) {
				dataClone = Arrays.copyOf(data, data.length);
				int[] part2 = calculate(dataClone, noun, verb);
				if(part2[0] == 19690720) {
					System.out.printf("Part 2) 100 * %d + %d = %d", noun, verb, 100 * noun + verb);
				}
			}
		}
	}
	
	public static int[] calculate(int[] data, int noun, int verb) {
		data[1] = noun;
		data[2] = verb;
		for(int i = 0; i < data.length; i += 4) {
			int opcode = data[i];
			if(opcode == 1 || opcode == 2) {
				int aPosition = data[i + 1];
				int bPosition = data[i + 2];
				int positionToStore = data[i + 3];
				int a = data[aPosition];
				int b = data[bPosition];
				data[positionToStore] = opcode == 1 ? a + b : a * b;
			} else if (opcode == 99) {
				break;
			}
		}
		return data;
	}
}