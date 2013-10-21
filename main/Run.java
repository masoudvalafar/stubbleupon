package main;

import input.AttributeTypes;
import input.InputParser;
import input.StumbleUponAttributeTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Run {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/train.tsv"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		InputParser inputParser = new InputParser("tsv");
		inputParser.parseInput(br);
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		ArrayList<String> columns = inputParser.getColumns();
		
		AttributeTypes stumbleUponAttrtypes = new StumbleUponAttributeTypes();
		ArrayList<ArrayList<Object>> formattedInstances = inputParser.getFormattedInstances(stumbleUponAttrtypes);
		
		System.out.println(columns.size());
		System.out.println(formattedInstances.get(2).get(2));
		
	}

}
