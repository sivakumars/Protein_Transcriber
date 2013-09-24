package horspool.patternmatching;

import java.util.HashMap;
import java.util.Map;

public class LookUpImpl implements LookUpInterface{

	Map<String,Integer> shiftLookupMap = new HashMap<String, Integer>();
	
	@Override
	public void buildShiftLookupMap(String pattern) {
		int patternLength = pattern.length();
		for(int i=0; i<= patternLength-2; i++){
			shiftLookupMap.put(pattern.charAt(i)+"", patternLength-(i+1));
		}
	}

	@Override
	public int lookUpShiftValue(char textChar, int patternLength) {
		String textKey = textChar+"";
		if(shiftLookupMap.containsKey(textKey)){
			return shiftLookupMap.get(textKey);
		}else{
			return patternLength;
		}
	}

	@Override
	public int patternMatch(String pattern, String text, LookUpInterface lookUp){
		
		int patternLength    = pattern.length();
		int patternRePos     = patternLength-1;
		int textLength		 = text.length();
		int matchedCharCount = 0;
		
		while(patternRePos <= textLength){
			matchedCharCount = 0;
			while((matchedCharCount < patternLength) &&
				  (pattern.charAt(patternLength-matchedCharCount-1) == (text.charAt(patternRePos-matchedCharCount))))
			{
				matchedCharCount += 1;
			}
			
			if(matchedCharCount == patternLength){
				return ( patternRePos - patternLength + 1);
			}else{
				patternRePos += lookUp.lookUpShiftValue(text.charAt(patternRePos), patternLength);
			}
		}			
		return -1;
	}
}
