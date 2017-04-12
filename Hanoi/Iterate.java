package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterate<T> implements Iterator<T>{
	private Node<T> point;
	public Iterate(Node<T> head){
		point = new Node<T>(null, head);
	}
	public boolean hasNext(){
		if (point.getNext()== null){
			return false;
		}
		else{
			return true;
		}
	}
	public T next() {
		if(this.hasNext()) {
			point = point.getNext();
			return point.getData();
		}
		else{
			throw new NoSuchElementException("No next element");
		}
	}
}