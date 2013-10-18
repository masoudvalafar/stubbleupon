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

	public ArrayList<ArrayList<Object>> getFormattedInstances(
			AttributeTypes stumbleUponAttrtypes) {
		ArrayList<ArrayList<String>> instances = getInstances();
		ArrayList<ArrayList<Object>> formattedInstances = new ArrayList<ArrayList<Object>>();
		
		for(ArrayList<String> instance: instances) {
			ArrayList<Object> formattedInstance = new ArrayList<Object>();
			
			for (int index = 0; index < instance.size(); index++) {
				formattedInstance.add(stumbleUponAttrtypes.convert(index, instance.get(index)));
			}
			
			formattedInstances.add(formattedInstance);
		}
		
		return formattedInstances;
	}

}
