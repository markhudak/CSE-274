/**
 * Mark Hudak
 * 08/21/2020
 * 
 * Implements an array-backed list of words.  The array will have a fixed capacity, meaning that once 
 * it is full, no additional words can be removed.
 * @author Norm Krumpe
 *
 */


// Typically when we work with lists, we expect them to maintain order
// (things stay in the position we put them), and there are certain methods we expect to have:
//   add() which adds a new word to the end of the list
//   add() which adds a new word to a particular location in the list
//   get() which retrieves an element from a particular location
//   set() which changes an element at a particular location
//	 size() which returns the number of elements in the list
//   remove() which removes a particular word
//   remove() which retrieves and removes an element from a particular location
//   contains() which tells us whether a particular word is in the list
//   clear() which removes all words
//   toArray() which returns an array of words in the list

public class WordList {
	private String[] words;
	private int size;
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * Constructs a new empty word list with the specified capacity.
	 * 
	 * @param capacity the maximum capacity of the list
	 */
	public WordList(int capacity) {
		
		size = 0;
		words = new String[capacity];
	}

	/**
	 * Constructs a new empty word list with a default capacity (in this case, 10).
	 */
	public WordList() {
		
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Returns the number of words in this list.
	 * @return the number of words in this list
	 */
	public int size() {
		
		return size;
		
	}

	/**
	 * Adds a specified string to this word list
	 * 
	 * @param s string to be added
	 * @return true if the add was successful, false otherwise
	 */
	public boolean add(String s) {
		
		if ( size == words.length ) {
			return false;
		}
		
		words[size] = s;
		size++;
		return true;
		
	}

	/**
	 * Adds a specified string to this word list at a specified index. The word may
	 * be added to the end of the list (when the index is the size of the list) or
	 * anywhere earlier (in which case, words will be shifted down to make room for
	 * the added word)
	 * 
	 * @param s string to be added
	 * @param index the index where the word is to be added (any value from 0 up to
	 *              the size of the list).
	 * @param s     the word to be added
	 * @return true if the add was successful, and false otherwise
	 * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt; size
	 */
	public boolean add(int index, String s) {
		
		if ( index < 0 )
			throw new IndexOutOfBoundsException("index" + index + "< 0" );
		if ( index > size )
			throw new IndexOutOfBoundsException("index" + index + "< ");
		
		if( size == words.length ) return false;
		
		for ( int i=size; i > index; i--) {
			words[i] = words[i-1];
		}
		
		words[index] = s;
		size++;
		return true;

	}

	/**
	 * Removes an element from a particular location. If the location is valid,
	 * return the word that is removed. If the location is not valid, throw an
	 * OutOfBoundsException.
	 * @param index the index of the word to be removed
	 * @return the word at the specified index
	 * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= size
	 */
	public String remove(int index) {
		
		if ( index > size) 
			throw new IndexOutOfBoundsException("index" + index + ">" + size);
		if ( index < 0 )
			throw new IndexOutOfBoundsException("index" + index + " < 0");
		
		String result = words[index];
		for (int i = index; i < size-1; i++) {
			words[i] = words[i+1];
		}
		
		words[size-1] = null;
		size--;
		return result;
		
	}

	

	/**
	 * Removes all words from the list.
	 */
	public void clear() {
		
		for ( int i = 0; i < size(); i++)
			words[i] = null;
		
	}

	/**
	 * Returns true if the specified word is in this list, and false otherwise.
	 * 
	 * @param s the word to look for
	 * @return true if the word is in this list, and false otherwise
	 */
	public boolean contains(String s) {
		
		int position = getLocation(s);
		if ( position == -1) return false;
		else return true;
		
	}

	/**
	 * Removes the first occurrence of a particular string, if it exists in the
	 * list.
	 * 
	 * @param s the string to be removed
	 * @return true if the string was removed, and false otherwise
	 */
	public boolean remove(String s) {
		
		int position = this.getLocation(s);
		if ( position == -1) return false; 
		
		remove(position);
		
		return true;
	}

	/**
	 * Returns the string at a particular index, if the index is valid
	 * 
	 * @param index The location of word to be removed. Valid values are 0 through 1
	 *              less than the size of the list.
	 * @return the string at the specified location
	 * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= size
	 */
	public String get(int index) {
		
		return words[index];
		
	}

	/**
	 * Sets a particular pre-existing location to a new word, and returns
	 * the old word that was in that location
	 * 
	 * @param index The location of word to be updated. Valid values are 0 through 1
	 *              less than the size of the list.
	 * @param s     the new value
	 * @return the old string that was just replaced
	 * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= size
	 */
	public String set(int index, String s) {
		
		if ( index > size) 
			throw new IndexOutOfBoundsException("index" + index + ">" + size);
		if ( index < 0 )
			throw new IndexOutOfBoundsException("index" + index + " < 0");
		
		String rtrn = words[index];
		words[index] = s;
		
		return rtrn;
		
	}

	/*
	 * A helper method. There are a couple operations that need to be able to look
	 * up where a word is in the list. So let's put that logic in one place.
	 * 
	 * returns the first index where s is located, or -1 if s is not found in the
	 * list
	 */
	private int getLocation(String s) {
		
		for (int i = 0; i < size; i++) {
			if ( words[i].equals(s)) return i;
		}
		
		return -1;
		
	}

	/**
	 * Returns an array of the words in the list. This is NOT the same as the array
	 * instance variable. For example, the instance variable named words might have
	 * a capacity of 10, but only contain 2 words. In that case, toArray() should
	 * return an array of length 2, containing the two words.
	 * 
	 * @return an array of all the words in the list 
	 */
	public String[] toArray() {
	
		String[] array = new String[words.length];
		
		for(int i = 0; i < words.length; i++) {
			array[i] = words[i];
		}
		
		return array;
		
	}
	
	public String toString() {
		
		String result = "";
		if (size == 0) return result;
		for (int i=0; i < size; i++) {
			result += words[i] + ", ";
		}
		
		result = result.substring(0, result.length()-2);
		return result;
		
	}

}
