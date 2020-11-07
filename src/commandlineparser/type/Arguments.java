package commandlineparser.type;

import java.util.HashMap;

public class Arguments {
	private HashMap<String, String> argPairs = new HashMap<String, String>();
	
	public void registerArguments(String argument, String passedValue) {
		this.argPairs.put(argument, passedValue);
	}
	
	public String[] getKeys() {
		return this.argPairs.keySet().toArray(new String[this.argPairs.keySet().size()]);
	}
	
	public String getPassedValue(String key) {
		return this.argPairs.get(key);
	}
	
	public boolean hasAssociatedValue(String key) {
		return (this.argPairs.get(key) != null) ? true : false;
	}
}
