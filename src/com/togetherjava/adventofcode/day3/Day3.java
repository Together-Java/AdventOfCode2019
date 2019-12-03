package com.togetherjava.adventofcode.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.togetherjava.adventofcode.util.ResourceLoader;

public class Day3 {

	private static List<String> data = ResourceLoader.getInput("Day3Inputs.txt");
	
	public static void main(String[] args) {
		part1();
		System.out.println("Calculating part 2 - this may take a while.....");
		part2();
	}

	public static void part1() {
		Set<Tile> wireA = new HashSet<>();
		Set<Tile> wireB = new HashSet<>();
		parseWire(data.get(0).split(","), wireA);
		parseWire(data.get(1).split(","), wireB);
		wireA.retainAll(wireB);
		int recordDistance = Integer.MAX_VALUE;
		for (Tile t : wireA) {
			int distance = getManhattanDistance(0, 0, t.getX(), t.getY());
			if (distance < recordDistance && distance != 0) {
				recordDistance = distance;
			}
		}
		System.out.println("Part 1 answer) " + recordDistance);
	}

	public static void part2() {
		List<Tile> wireA = new ArrayList<>();
		List<Tile> wireB = new ArrayList<>();
		parseWire(data.get(0).split(","), wireA);
		parseWire(data.get(1).split(","), wireB);
		int recordSum = Integer.MAX_VALUE;
		for (int i = 0; i < wireA.size(); i++) {
			for (int j = 0; j < wireB.size(); j++) {
				if (wireA.get(i).equals(wireB.get(j))) {
					if (i + j < recordSum && i + j != 0) {
						recordSum = i + j;
					}
				}
			}
		}
		System.out.println("Part 2 answer) " + recordSum);
	}

	public static int getManhattanDistance(int x, int y, int x2, int y2) {
		return Math.abs(x2 - x) + Math.abs(y2 - y);
	}

	public static void parseWire(String[] data, Collection<Tile> wire) {
		int x = 0;
		int y = 0;
		for (String w : data) {
			String direction = w.substring(0, 1);
			int moves = Integer.parseInt(w.substring(1));
			if (direction.equals("U")) {
				for (int i = y; i > y - moves; i--) {
					wire.add(new Tile(x, i));
				}
				y -= moves;
			} else if (direction.equals("D")) {
				for (int i = y; i < y + moves; i++) {
					wire.add(new Tile(x, i));
				}
				y += moves;
			} else if (direction.equals("L")) {
				for (int i = x; i > x - moves; i--) {
					wire.add(new Tile(i, y));
				}
				x -= moves;
			} else if (direction.equals("R")) {
				for (int i = x; i < x + moves; i++) {
					wire.add(new Tile(i, y));
				}
				x += moves;
			}
		}
	}
}