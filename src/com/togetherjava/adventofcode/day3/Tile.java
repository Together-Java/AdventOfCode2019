package com.togetherjava.adventofcode.day3;

public class Tile {
	
	private int x, y;
	
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
	public boolean equals(Object obj) {
		Tile tile = (Tile) obj;
		return tile.getX() == x && tile.getY() == y;
	}
	
	@Override
	public String toString() {
		return String.format("X = %d Y = %d", x, y);
	}
}
