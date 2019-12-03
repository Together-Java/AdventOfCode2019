package com.togetherjava.adventofcode.day3;

import java.util.ArrayList;
import java.util.List;

import com.togetherjava.adventofcode.util.ResourceLoader;

public class Day3 {

	private static List<Tile> wireA = new ArrayList<>();
	private static List<Tile> wireB = new ArrayList<>();

	public static void main(String[] args) {
		List<String> data = ResourceLoader.getInput("Day3Inputs.txt");
		parseWire(data.get(0).split(","), wireA);
		parseWire(data.get(1).split(","), wireB);
		
		wireA.retainAll(wireB);
		
		int recordDistance = Integer.MAX_VALUE;
		for (Tile t : wireA) {
			int distance = getManhattanDistance(t.getX(), t.getY(), 0, 0);
			if (distance < recordDistance) {
				recordDistance = distance;
			}
		}

		System.out.println(recordDistance);
	}

	public static int getManhattanDistance(int x, int y, int x2, int y2) {
		return Math.abs(x2 - x) + Math.abs(y2 - y);
	}

	public static void parseWire(String[] data, List<Tile> wire) {
		int x = 0;
		int y = 0;
		for (String w : data) {
			String direction = w.substring(0, 1);
			int moves = Integer.parseInt(w.substring(1));
			if (direction.equals("U")) {
				y -= moves;
			} else if (direction.equals("D")) {
				y += moves;
			} else if (direction.equals("L")) {
				x -= moves;
			} else if (direction.equals("R")) {
				x += moves;
			}
			wire.add(new Tile(x, y));
		}
	}
}