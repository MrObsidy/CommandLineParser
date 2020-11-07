package commandlineparser.io;

import commandlineparser.type.Arguments;

public class Separator {
	public static Arguments separate(String[] args) {
		Arguments arguments = new Arguments();
		
		boolean previousValueWasFlagKey = false;
		String associatedKey = null;
		
		for(String arg : args) {
			if(arg.startsWith("--")) {
				//we're dealing with a flag
				
				if(previousValueWasFlagKey) {
					//In case we are just dealing with a singleton flag without any argument
					arguments.registerArguments(associatedKey, "");
					associatedKey = null;
					previousValueWasFlagKey = false;
				}
				
				if(!(args.length < 1)) {
					arguments.registerArguments(arg, "");
				}
				
				associatedKey = arg;
				previousValueWasFlagKey = true;
			} else {
				if(!previousValueWasFlagKey) {
					throw new RuntimeException("Could not parse argument without flag " + arg);
				} else {
					
					arguments.registerArguments(associatedKey, arg);
					previousValueWasFlagKey = false;
					associatedKey = null;
				}
			}
		}
		return arguments;
	}
}
