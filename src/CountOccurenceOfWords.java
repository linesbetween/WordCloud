/*CIT-285 Adv.Java
 * Hanfei XU*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountOccurenceOfWords {
	
	private ArrayList<String> wordList;
	private Scanner s;
	
	
	public CountOccurenceOfWords(String fileName) throws FileNotFoundException{
		//read words from file into arraylist
		s = new Scanner(new File(fileName));
		wordList = new ArrayList<String>();
		while (s.hasNext()){
	    wordList.add(s.next());
		}
		s.close();
	  		
	}
	
	
	//count words occurance and store in map
  public Map<String, Integer> count() {
	
	
	// Create a TreeMap to hold words as key and count as value
    Map<String, Integer> map = new TreeMap<>();

    for (int i = 0; i < wordList.size(); i++) {
      String key = wordList.get(i).toLowerCase();
      
      if (key.length() > 0) {
        if (!map.containsKey(key)) {
          map.put(key, 1);
        }
        else {
          int value = map.get(key);
          value++;
          map.put(key, value);
        }
      }
    
  }
    
    

    // Display key and value for each entry
   // map.forEach((k, v) -> System.out.println(k + "\t" + v));
    
    return map;
  }
  
  /*
  public Map<String, Integer>  SubMap(Map<String, Integer> map){
 	 for (Map.Entry<String, Integer> entry: map){
 }
  }
  */
}

