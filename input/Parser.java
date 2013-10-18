package input;

import java.io.BufferedReader;
import java.util.ArrayList;

public interface Parser {

	void parseInput(BufferedReader br);
	ArrayList<String> getColumns();
	ArrayList<ArrayList<String>> getInstances();

}
