import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		WordList words1 = new WordList();
		WordList words2 = new WordList(100);
		
		System.out.println("size/cons test 1 :: " + (words1.size() ==0));
		System.out.println("size/cons test 2 :: " + (words2.size() ==0));

		words1.add("one");
		words1.add("two");
		words1.add("three");
System.out.println("add/size test 1 :: " + (words1.size() == 3) );		
		// Do your own testing here.  Create a WordList object,
		// add, remove, check what's in th array, and so on.
		// Test edge cases as you go.
	
		

	}
	


}
