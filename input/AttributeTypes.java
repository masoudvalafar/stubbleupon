package input;

public interface AttributeTypes {

	Object convert(int count, String nextToken);
	Class<?> getType(int index);

}
