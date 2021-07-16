package dataPojos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Data {
	

	public String item1="Test1";
	public String item2="Test2";
	public String item3="Test3";
	
	public String selected="selected";
	
	
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
