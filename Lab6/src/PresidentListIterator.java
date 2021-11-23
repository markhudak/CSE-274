import java.util.Iterator;

public class PresidentListIterator implements Iterator<President> {
	
	OrderedList presidents;

	Node nextNode;
	
	public PresidentListIterator(OrderedList list ) {
		nextNode = list.getFront();
	}
	
	public boolean hasNext() {
		return nextNode != null;
	}
	
	public President next() {
		President result = null;
		
		if(hasNext()) {
			result = nextNode.getData();
			nextNode = nextNode.getNext();
		}
		
		return result;
	}
}

