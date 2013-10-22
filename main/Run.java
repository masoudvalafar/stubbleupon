package main;

import input.AttributeTypes;
import input.InputParser;
import input.StumbleUponAttributeTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import tools.TypedArrayList;

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
		ArrayList<ArrayList<Object>> unformattedInstances = inputParser.getFormattedInstances(stumbleUponAttrtypes);
		TypedArrayList instances = new TypedArrayList(unformattedInstances, stumbleUponAttrtypes);
		
		System.out.println(columns.size());
		System.out.println( ((Map<String,String>) unformattedInstances.get(0).get(2)).get("body") );
		System.out.println(instances.getInstancesAttributes(5));
		
		PearsonsCorrelation pc = new PearsonsCorrelation();
		double[] x = {1,2,3,-4};
		double[] y = {-2,-3,-4,5};
		System.out.println(pc.correlation(x, y));
	}

}
