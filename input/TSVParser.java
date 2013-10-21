package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import tools.ParsingTools;

public class TSVParser implements Parser {
	
	private static final String DELIM = "\t";
	private ArrayList<String> columns = new ArrayList<String>();
	private ArrayList<ArrayList<String>> instances = new ArrayList<ArrayList<String>>();

	@Override
	public void parseInput(BufferedReader br) {
		String line = null;
		
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		StringTokenizer st = new StringTokenizer(line, DELIM);
		while (st.hasMoreTokens()) {
			columns.add(ParsingTools.strip(st.nextToken()));
		}
		
		while (true) {
			try {
				line = br.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			if (line == null)
				break;

			st = new StringTokenizer(line, DELIM);
			ArrayList<String> instance = new ArrayList<String>();
			while (st.hasMoreTokens()) {
				instance.add(st.nextToken());
			}
			instances.add(instance);
		}
		
	}

	@Override
	public ArrayList<String> getColumns() {
		return columns;
	}

	@Override
	public ArrayList<ArrayList<String>> getInstances() {
		return instances;
	}

}
