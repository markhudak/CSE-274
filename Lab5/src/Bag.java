public class Bag<T> implements BagInterface<T>, CollectionInterface<T> {

	private Node<T> front;
	private Node<T> rear;
	int size;
	
	public Bag() {
		front = null;
		rear = null;
		size = 0;
	}
	// Attempts to add element to this collection.
	// Returns true if successful, false otherwise.
	public boolean add(T element) {
		
		Node<T> node = new Node<T>(element); //first make a new node
		//if is empty just make a new node
		if(size == 0) {
			front = rear = node;
		} else {
		// insert at rear
		rear.next = node;
		node.prev = rear;
		rear = node;
		}
		size++;
		return true;
		
	
	}

	// Returns an element e from this collection such that e.equals(target).
	// If no such e exists, returns null.
	public T get(T target) {
		
		Node<T> nodePtr = front;
		while (nodePtr != null) {	
			if(nodePtr.data.equals(target)) return nodePtr.data;
			nodePtr = nodePtr.next;
		}
		return null;
	}

	// Returns true if this collection contains an element e such that
	// e.equals(target) { return true; } otherwise returns false.
	public boolean contains(T target) {
		
		return (target.equals(get(target)));
	}

	// Removes an element e from this collection such that e.equals(target)
	// and returns true. If no such e exists, returns false.
	//public boolean remove(T target) {
		
	//	Node<T> previousNode = nodePtr.prev;
	//	Node<T> nextNode = nodePtr.next;
	//	previousNode.next = 
	//	nextNode.prev = previousNode;
				
		// return false;
	//}

	// Returns true if this collection is full { return true; } otherwise, returns
	// false.
	public boolean isFull() {
		return false;
	}

	// Returns true if this collection is empty { return true; } otherwise, returns
	// false.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns the number of elements in this collection.
	public int size() {
		return size;
	}

	// If this bag is not empty, removes and returns a random element of the
	// bag { return true; } otherwise returns null.
	public T grab() {
		
		if ( isEmpty() ) return null;
		
		int rand = (int) (Math.random() * size) + 1;
		//rand = 1; can control this to assist in testing 
		Node<T> nodePtr = front;
		for ( int i=1; i < rand; i++) {
			nodePtr = nodePtr.next;
		}
		
		if(size == 1) {
			front = rear = null;
		} else if (nodePtr == front){
			Node<T> nextNode = nodePtr.next;
			nextNode.prev =  null;
			front = nextNode;
		} else if ( nodePtr == rear) {
			Node<T> previousNode = nodePtr.prev;
			previousNode.next = null;
			rear = previousNode;
		} else {
			Node<T> previousNode = nodePtr.prev;
			Node<T> nextNode = nodePtr.next;
			previousNode.next = nextNode;
			nextNode.prev = previousNode;
		}
		size --;
		return nodePtr.data;
	}

	// Returns a count of all elements e in this collection such that
	// e.equals(target).
	public int count(T target) {
		return 0;
	}

	// Removes all elements e from this collection such that e.equals(target)
	// and returns the number of elements removed.
	public int removeAll(T target) {
		return 0;
	}

	// Empties this bag so that it contains zero elements.
	public void clear() {
		size = 0;
		front = rear = null;
	}
	
	private class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;
		
		private Node(T item) {
			data = item;
			next = prev = null;
		}
		
		private Node( T item, Node<T> newNext, Node<T> newPrev) {
			data = item;
			next = newNext;
			prev = newPrev;
		}
	}
}
