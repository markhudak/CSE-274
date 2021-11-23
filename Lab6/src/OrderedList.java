/* Mark Hudak
 * CSE 274
 * 09/25/2020
 * Lab 6
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

public class OrderedList {

	private int size;
	private Node front;
	private Node rear;

	private Iterator iter;

	public OrderedList() {
		size = 0;
		front = rear = null;
	}

	public Node getFront() {
		return front;
	}

	public Node getRear() {
		return rear;
	}

	public int getSize() {
		return size;
	}

	public void insert(President item) {

		Node current = front;
		Node prev = null;

		Node node = new Node(item);
		if (size == 0) {
			front = rear = node;
			size++;
			return;
		}
		if (size == 1) { // prev == null
			if (current.getData().compareTo(item) > 0) { // insert before front
				node.setNext(current);
				node.setPrev(null);
				current.setPrev(node);
				front = node;
			} else { // insert after front
				front.setNext(node);
				node.setPrev(front);
				rear = node;
			}
			size++;
			return;
		}
		// list size 2 or bigger
		while (current != null) {
			if (current.getData().compareTo(item) < 0) {
				prev = current;
				current = current.getNext();
			} else { // insert before this node
				if (prev == null) {
					node.setNext(front);
					front.setPrev(node);
					front = node;
				} else {
					node.setPrev(prev);
					node.setNext(current);
					prev.setNext(node);
					current.setPrev(node);
				}
				size++;
				return;
			}
		}
		
		// insert at end of list
		rear.setNext(node);
		node.setPrev(rear);
		rear = node;
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String result = "[";
		
		//Node nodePtr = front;
//
//		Node nodePtr = front;
//
//		while ( nodePtr != null) {
//			result = result + nodePtr.getData().getLastName() + " ";
//			nodePtr = nodePtr.getNext();
//		}
//		result = result.trim();
//		result += "]";
		
		Iterator it = iterator();
		while(it.hasNext()) {
			result = result + ((President) it.next()).getLastName() + " " ;
		}
result = result.trim();
result += "]";
		
		return result;
	}

	private Iterator<Node> iterator() {
		return new Iterator() {

			Node nextPosition = front;

			@Override
			public boolean hasNext() {
				return !(nextPosition == null);
			}

			@Override
			public Object next() {
				President result = null;
				if (hasNext()) {
					result = nextPosition.getData();
					nextPosition = nextPosition.getNext();
				}

				return result;
			}
		};
	}

	// complete this method
	public String toStringReverse() {
		String result = "[";
		
//Node nodePtr = front;
Iterator it = iteratorReverse();
		while(it.hasNext()) {
			result = result + ((President) it.next()).getLastName() + " ";
		}
result = result.trim();
result += "]";
		
		return result;
	}

// complete this method
	private Iterator<Node> iteratorReverse() {
		return new Iterator() {
		Node nextPosition = rear;

		@Override
		public boolean hasNext() {
			return !(nextPosition == null);
		}

		@Override
		public Object next() {
			President result = null;
			if (hasNext()) {
				result = nextPosition.getData();
				nextPosition = nextPosition.getPrev();
			}

			return result;
		}
	};
		
		
	}


	public static void main(String[] args) {

		OrderedList presidents = new OrderedList();
		President washington = new President("George", "Washington", 1790, 8);

		President bush = new President("George", "Bush", 1989, 4);
		presidents.insert(bush);
		presidents.insert(washington);
		PresidentListIterator listIter = new PresidentListIterator(presidents);

		while (listIter.hasNext()) {
			President pres = listIter.next();
			System.out.println(pres.getLastName());
		}
		

	}

}
