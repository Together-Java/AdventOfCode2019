package com.togetherjava.adventofcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
				wire.addAll(getTilesBottomToTop(x, y, moves));
				y -= moves;
			} else if (direction.equals("D")) {
				wire.addAll(getTilesTopToBottom(x, y, moves));
				y += moves;
			} else if (direction.equals("L")) {
				wire.addAll(getTilesRightToLeft(x, y, moves));
				x -= moves;
			} else if (direction.equals("R")) {
				wire.addAll(getTilesLeftToRight(x, y, moves));
				x += moves;
			}
		}
	}
	
	public static List<Tile> getTilesLeftToRight(int x, int y, int moves) {
		List<Tile> tiles = new ArrayList<>();
		for(int i = x; i < x + moves; i++) {
			tiles.add(new Tile(i, y));
		}
		return tiles;
	}
	
	public static List<Tile> getTilesRightToLeft(int x, int y, int moves) {
		List<Tile> tiles = new ArrayList<>();
		for(int i = x; i > x - moves; i--) {
			tiles.add(new Tile(i, y));
		}
		return tiles;
	}
	
	public static List<Tile> getTilesTopToBottom(int x, int y, int moves) {
		List<Tile> tiles = new ArrayList<>();
		for(int i = y; i < y + moves; i++) {
			tiles.add(new Tile(x, i));
		}
		return tiles;
	}
	
	public static List<Tile> getTilesBottomToTop(int x, int y, int moves) {
		List<Tile> tiles = new ArrayList<>();
		for(int i = y; i > y - moves; i--) {
			tiles.add(new Tile(x, i));
		}
		return tiles;
	}
	
	private static class Tile {
		
		private int x;
		private int y;
		
		public Tile(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tile other = (Tile) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}