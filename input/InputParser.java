package input;

import java.io.BufferedReader;
import java.util.ArrayList;

public class InputParser {

	Parser parser;
	
	public InputParser(String inputType) {
		if (inputType == "tsv") {
			this.parser = new TSVParser();
		}
	}

	public void parseInput(BufferedReader br) {
		parser.parseInput(br);
	}

	public ArrayList<String> getColumns() {
		return parser.getColumns();
	}

	public ArrayList<ArrayList<String>> getInstances() {
		return parser.getInstances();
	}

}
