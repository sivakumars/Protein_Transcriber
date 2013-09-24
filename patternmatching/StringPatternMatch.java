package horspool.patternmatching;


public class StringPatternMatch {

	private static int matchPattern(String pattern, String text){		
		LookUpInterface lookUp = new LookUpImpl();	
		lookUp.buildShiftLookupMap(pattern);
		return lookUp.patternMatch(pattern, text, lookUp);
	}
	
	public static void main(String args[]) {		
		String startCodon = "ATG";
		String mRnaStrand = "GCCGCAUGGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
		mRnaStrand = mRnaStrand.replaceAll("U", "T");
		int matchFound = StringPatternMatch.matchPattern(startCodon, mRnaStrand);
				
		if(matchFound != -1 ){
			System.out.println(" Match found at index : "+ matchFound);
		}else{
			System.out.println("Start Codon Not Present in the sequence");
		}
	}
}
