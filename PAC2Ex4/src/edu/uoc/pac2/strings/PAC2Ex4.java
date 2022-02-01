package edu.uoc.pac2.strings;

//import com.sun.tools.classfile.StackMap_attribute.stack_map_frame;

public class PAC2Ex4 {


	public String palindromeADN(String adn) {
		return adn == null ? null : adn.concat(new StringBuilder(adn).reverse().toString()).toUpperCase().replaceAll(" ", "");
	}
	
	
	public boolean equalsADN(String adn1, String adn2) {
		return adn1 == null || adn2 == null ? false : (adn1 + adn1).contains(adn2);
	}
	
	
	public String printADN(String text, int distance) {
if(text == null || text.length() < 6 || distance < 1) return null;
		
		StringBuilder result = new StringBuilder();
		
		int column = 0;
		boolean right = true;
		
		for(int i=0; i<text.length(); i++) {
			
			for(int j=0; j<column; j++) { 
				result.append(" ");
			}
			
			if(column == distance-1) {
				right = false;
			}else if(column == 0) {
				right = true;
			}
			
			if(right) column++; 
			else column--;
			
			result.append(text.charAt(i));
			result.append("\n");
			
		}
		
		return result.toString();
	}
}
