package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 * 
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	LinkedStack<HanoiRing> peg;
	public StackBasedHanoiPeg() {
		peg = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
	if(ring == null){
		throw new NullPointerException("Cannot add null ring");
	}
	else if (hasRings()==false){
		peg.push(ring);
	}
	else if (peg.peek().getSize()> ring.getSize()){
		peg.push(ring);
	}
	
	else{
		throw new IllegalHanoiMoveException("Unable to do move");
	}
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
        if(hasRings()==true){
        	return peg.pop();
        }
        else{
        	throw new IllegalHanoiMoveException("Peg is empty");
        }
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(hasRings()==true){
        	return peg.peek();
        }
        else{
        	throw new IllegalHanoiMoveException("Peg is empty");
        }
	}

	@Override
	public boolean hasRings() {
        if(peg.isEmpty()==true){
        	return false;
        }
        else{
        	return true;
        }
	}
}
