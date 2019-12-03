package com.togetherjava.adventofcode.day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.togetherjava.adventofcode.util.ResourceLoader;

public class Day3 {

	private static Set<Tile> wireA = new HashSet<>();
	private static Set<Tile> wireB = new HashSet<>();

	public static void main(String[] args) {
		long then = System.currentTimeMillis();
		List<String> data = ResourceLoader.getInput("Day3Inputs.txt");
		parseWire(data.get(0).split(","), wireA);
		parseWire(data.get(1).split(","), wireB);
		
		wireA.retainAll(wireB);
		
		int recordDistance = Integer.MAX_VALUE;
		for (Tile t : wireA) {
			int distance = getManhattanDistance(0, 0, t.getX(), t.getY());
			//check if doesn't equal zero because the 2 tiles that intersect closest to the main port IS the main port
			if (distance < recordDistance && distance != 0) {
				recordDistance = distance;
			}
		}
		System.out.println("Part 1 answer) " + recordDistance);
		System.out.printf("Done in %d ms", System.currentTimeMillis() - then);
	}

	public static int getManhattanDistance(int x, int y, int x2, int y2) {
		return Math.abs(x2 - x) + Math.abs(y2 - y);
	}

	public static void parseWire(String[] data, Set<Tile> wire) {
		int x = 0;
		int y = 0;
		for (String w : data) {
			String direction = w.substring(0, 1);
			int moves = Integer.parseInt(w.substring(1));
			if (direction.equals("U")) {
				for(int i = y; i > y - moves; i--) {
					wire.add(new Tile(x, i));
				}
				y -= moves;
			} else if (direction.equals("D")) {
				for(int i = y; i < y + moves; i++) {
					wire.add(new Tile(x, i));
				}
				y += moves;
			} else if (direction.equals("L")) {
				for(int i = x; i > x - moves; i--) {
					wire.add(new Tile(i, y));
				}
				x -= moves;
			} else if (direction.equals("R")) {
				for(int i = x; i < x + moves; i++) {
					wire.add(new Tile(i, y));
				}
				x += moves;
			}
		}
	}
}