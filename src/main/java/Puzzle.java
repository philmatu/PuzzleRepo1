public class Puzzle {

	/**
	 * 
	 * @input sentence
	 * @return all characters that are needed to make the sentence a pangram
	 * 
	 * java 8 streams tend to be more efficient with smaller sentences and repetion, 
	 * thus why I've chosen this strategy.  I've also gone with primitive types
	 * because there won't be much performance loss in terms of benchmarking by
	 * going through a few more characters in a string that's 50 characters max to begin with,
	 * remember the alphabet is only 26 characters.  
	 * 
	 * In a larger sentence input, reflection will likely beat out streams in terms of benchmarks
	 * additionally, instead of going the missing integer route, it would be better to have an
	 * arraylist or other object that we remove Integer objects from as we encounter them
	 * along with a check for arraylist size 0, as the probability of hitting a panagram increases
	 * with sentence length.
	 * 
	 */
	public String getMissingLetters(String sentence) {
		//handle base case quickly
		if(sentence == null) {
			return "abcdefghijklmnopqrstuvwxyz";
		}
		
		int[] array = new int[26];//language defaults all values to 0
		
		//This is O(N) and allow parallel processing
		sentence.chars().parallel().forEach(item->{
			//65-90 is upper case A-Z, 97-122 is lower case a-z
			
			//integer comparisons are usually quick in benchmarking tools
			if(item > 64 && item < 91) {
				item = item + 32;
			}
			if(item < 97 || item > 122) {
				return;
			}
			
			int pos = item - 96;//start with 1
			array[pos-1] = pos; //O(1)
			
		});
		
		StringBuilder result = new StringBuilder();//thread safe builder incase the whole method is distributed
		//we are going through 26 values, which is O(26) or O(1) which is constant too
		for(int i=0; i<array.length; i++) {
			if(array[i] == 0) {
				result.append((char)(i+97));
			}
		}
        
		return result.toString();
	}
	
	public static void main(String args[]) {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("A quick brown fox jumps over the lazy dog");
		System.out.println(output);
	}
	
}
