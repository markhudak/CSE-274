//---------------------------------------------------------------------------
// BagInterface.java           by Dale/Joyce/Weems                  Chapter 5
//
// Interface for a class that implements a bag of T.
// A bag is a collection that supports a few extra operations.
//---------------------------------------------------------------------------

public interface BagInterface<T> extends CollectionInterface<T> {

	// If this bag is not empty, removes and returns a random element of the
	// bag; otherwise returns null.
	T grab();

	// Returns a count of all elements e in this collection such that
	// e.equals(target).
	int count(T target);

	// Removes all elements e from this collection such that e.equals(target)
	// and returns the number of elements removed.
	int removeAll(T target);

	// Empties this bag so that it contains zero elements.
	void clear();

}
