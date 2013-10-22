package tools;

import input.AttributeTypes;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;

public class TypedArrayList {

	private ArrayList<ArrayList<Object>> instances;
	private AttributeTypes attributeTypes;

	public TypedArrayList(ArrayList<ArrayList<Object>> instances, AttributeTypes attributeTypes) {
		this.instances = instances;
		this.attributeTypes = attributeTypes;
	}
	
	public ArrayList<?> getInstancesAttributes(int index) {
		if (attributeTypes.getType(index) == Double.TYPE) {
			ArrayList<Double> attributes = new ArrayList<Double>();
			for (ArrayList<Object> instance: instances){
				if (instance.get(index) != null) { 
					attributes.add((double) instance.get(index));
				} else {
					attributes.add(null);
				}
			}
			return attributes;
		} else if (attributeTypes.getType(index) == Integer.TYPE) {
			ArrayList<Integer> attributes = new ArrayList<Integer>();
			for (ArrayList<Object> instance: instances){
				if (instance.get(index) != null) { 
					attributes.add((Integer) instance.get(index));
				} else {
					attributes.add(null);
				}
			}
			return attributes;
		} else if (attributeTypes.getType(index) == String.class) {
			ArrayList<String> attributes = new ArrayList<String>();
			for (ArrayList<Object> instance: instances){
				if (instance.get(index) != null) { 
					attributes.add((String) instance.get(index));
				} else {
					attributes.add(null);
				}
			}
			return attributes;
		} else if (attributeTypes.getType(index) == Gson.class) {
			ArrayList<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
			for (ArrayList<Object> instance: instances){
				if (instance.get(index) != null) { 
					attributes.add((Map<String,String>) instance.get(index));
				} else {
					attributes.add(null);
				}
			}
			return attributes;
		}
		
		return null;
	}

}
