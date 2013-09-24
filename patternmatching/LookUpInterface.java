package horspool.patternmatching;

import java.util.Map;

public interface LookUpInterface {
      void buildShiftLookupMap(String pattern);
      
      int lookUpShiftValue(char textChar, int patternLength);
      
      int patternMatch(String pattern, String text, LookUpInterface lookUp);
}
