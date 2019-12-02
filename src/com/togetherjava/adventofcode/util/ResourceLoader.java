package com.togetherjava.adventofcode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceLoader {

	public static List<String> getInput(String resourcePath) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath)))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
