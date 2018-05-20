import org.junit.Test;
import static org.junit.Assert.*;

public class PuzzleTest {
    
	@Test 
    public void testCompleteString() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("A quick brown fox jumps over the lazy dog");
		assertEquals("", output);
    }
	
	@Test 
    public void testEmptyString() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("");
		assertEquals("abcdefghijklmnopqrstuvwxyz", output);
    }
	
	@Test 
    public void testNumericString() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("3289329398238977 3289328923");
		assertEquals("abcdefghijklmnopqrstuvwxyz", output);
    }
	
	@Test 
    public void testUnicodeString() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("\\במסגרתו קשת, מפעילת מאקו, ");
		assertEquals("abcdefghijklmnopqrstuvwxyz", output);
    }
	
	@Test 
    public void testExampleTwo() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("A slow yellow fox crawls under the proactive dog");
		assertEquals("bjkmqz", output);
    }
	
	@Test 
    public void testExampleThree() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters("Lions, and tigers, and bears, oh my!");
		assertEquals("cfjkpquvwxz", output);
    }
	
	@Test 
    public void testNull() {
		Puzzle p = new Puzzle();
		String output = p.getMissingLetters(null);
		assertEquals("abcdefghijklmnopqrstuvwxyz", output);
    }
	
}
