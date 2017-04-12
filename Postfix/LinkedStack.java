package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	

	/**
	 * {@inheritDoc}
	 */
	LLNode<T> head;
	public LinkedStack(){
		head=null;
	}
	@Override
	public T pop() throws StackUnderflowException {
    // TODO
		LLNode<T> infoNode=head;
		if(!isEmpty()){
			head=head.getNext();
			return infoNode.getData();
		}
		else{
			throw new StackUnderflowException("stack empty");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
    // TODO
		if(!isEmpty()){
			return head.getData();
		}
		else{
			throw new StackUnderflowException("stack empty");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
    // TODO
    if (head!= null){
    	return false;
    }
    else return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
    // TODO
		LLNode<T> node = head;
		int num = 0;
    	if(!isEmpty()){
    		while(node!= null){
    			num++;
    			node=node.getNext();
    		}
    		return num;
    	}
    	else return num;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
    // TODO
		LLNode<T> temp = head;
		head=new LLNode<T>(elem);
		head.setNext(temp);
	}

}
