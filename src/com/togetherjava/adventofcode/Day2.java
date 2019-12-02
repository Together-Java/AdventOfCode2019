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
		data[1] = 12;
		data[2] = 2;
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
				System.out.println("Opcode 99 reached - terminating");
				break;
			}
		}
		System.out.println(Arrays.toString(data).replaceAll(" ", ""));
		System.out.println("Number at position 0 is " + data[0]);
	}
}
