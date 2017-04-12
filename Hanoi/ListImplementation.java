package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 * 
 * @author jcollard
 * 
 */

public class ListImplementation<T> implements ListInterface<T> {
	Node<T> head;
	Node<T> end;
	int size;
	public ListImplementation() {
		head=null;
		end=null;
	}

	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
        return size;
	}

	@Override
	public boolean isEmpty() {
        if(head==null){
        	return true;
        }
        else return false;
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) {
		Node<T> newNode = new Node<T>((T)elem, null);
		if(elem == null){
			throw new NullPointerException("Cannot append null node");
		}
		else if(isEmpty()){
			head= newNode;
			end= newNode;
			size++;
		} 
		else{
			end.setNext(newNode);
			end = newNode;
			size++;
		}
		return this;
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) {
    if(n==0){
    	return head.getData();
    }
    else if(n<0 || size <= n){
    	throw new NoSuchElementException("Element does not exist");
    }
    else{
    	Node<T> getNode = head;
    	int count =0;
    	while(n>count){
    		getNode=getNode.getNext();
    		count++;
    	}
    	return getNode.getData();
    	
    }
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
        return new Iterate<T>(head);
	}
}

