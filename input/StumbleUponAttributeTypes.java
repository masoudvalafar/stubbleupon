package input;

import java.util.ArrayList;
import java.util.Map;

import tools.ParsingTools;

import com.google.gson.Gson;

public class StumbleUponAttributeTypes implements AttributeTypes {

	ArrayList<Class<?>> attributeTypes = new ArrayList<Class<?>>();
	
	public StumbleUponAttributeTypes() {
		attributeTypes.add(String.class); // url
		attributeTypes.add(Integer.TYPE); // urlid
		attributeTypes.add(Gson.class); // boilerplate
		attributeTypes.add(String.class); // alchemy category
		attributeTypes.add(Double.TYPE);  // alchemy  category score
		attributeTypes.add(Double.TYPE);  // average number of words in each link
		attributeTypes.add(Double.TYPE);  // # of links sharing at least 1 word with 1 other links / # of links
		attributeTypes.add(Double.TYPE);  // # of links sharing at least 1 word with 2 other links / # of links
		attributeTypes.add(Double.TYPE);  // # of links sharing at least 1 word with 3 other links / # of links
		attributeTypes.add(Double.TYPE);  // # of links sharing at least 1 word with 4 other links / # of links
		attributeTypes.add(Double.TYPE);  // compression ratio
		attributeTypes.add(Double.TYPE);  // Count of number of <embed>  usage
		attributeTypes.add(Integer.TYPE); // A page is frame-based (1) if it has no body markup but have a frameset markup
		attributeTypes.add(Double.TYPE);  // Ratio of iframe markups over total number of markups
		attributeTypes.add(Integer.TYPE); // True (1) if it contains an <a>  with an url with domain
		attributeTypes.add(Double.TYPE);  // Ratio of tags vs text in the page
		attributeTypes.add(Double.TYPE);  // Ratio of <img> tags vs text in the page
		attributeTypes.add(Integer.TYPE); // True (1) if StumbleUpon's news classifier determines that this webpage is news
		attributeTypes.add(Integer.TYPE); // True (1) if at least 3 <a> 's text contains more than 30 alphanumeric characters
		attributeTypes.add(Double.TYPE);  // Percentage of words on the page that are in hyperlink's text
		attributeTypes.add(Integer.TYPE); // True (1) if StumbleUpon's news classifier determines that this webpage is front-page news
		attributeTypes.add(Integer.TYPE); // Page's text's number of alphanumeric characters
		attributeTypes.add(Integer.TYPE); // Number of <a>  markups
		attributeTypes.add(Double.TYPE);  // Number of words in url
		attributeTypes.add(Double.TYPE);  // A link is parametrized if it's url contains parameters  or has an attached onClick event
		attributeTypes.add(Double.TYPE);  // Ratio of words not found in wiki (considered to be a spelling mistake)
		attributeTypes.add(Integer.TYPE); // User-determined label. Either evergreen (1) or non-evergreen (0); available for train.tsv only
	}
	
	@Override
	public Object convert(int count, String input) {
		
		if (input.equals("\"?\"")) {
			return null;
		} else if (attributeTypes.get(count) == Gson.class) {
			Gson gson=new Gson(); 
			Map<String,String> map = (Map<String,String>) gson.fromJson(ParsingTools.strip(input.replaceAll("\"\"", "\"")), Map.class);
			return map; 
		} else if (attributeTypes.get(count) == Integer.TYPE) {
			return Integer.parseInt(ParsingTools.strip(input));
		} else if (attributeTypes.get(count) == Double.TYPE) {
			return Double.parseDouble(ParsingTools.strip(input));
		} else {
			return input;
		}
	}

	@Override
	public Class<?> getType(int index) {
		return attributeTypes.get(index);
	}

}
