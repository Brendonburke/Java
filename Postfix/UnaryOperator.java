package language.arith;

import language.Operand;
import language.Operator;

//unary implementation of binaryOperator class
public abstract class UnaryOperator<T> implements Operator<T> {

	private Operand<T> op;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getNumberOfArguments() {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<T> operand) {
		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i > 0)
			throw new IllegalArgumentException("Binary operator only accepts operand 0 but recieved " + i + ".");
		if(op != null)
			throw new IllegalStateException("Position " + i + " has been previously set.");
		op = operand;
	}

	/**
	 * Returns the first operand
	 * @return the first operand
	 */
	public Operand<T> getOp() {
		return op;
	}

}
