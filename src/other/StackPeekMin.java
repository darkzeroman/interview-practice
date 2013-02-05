package other;

import java.util.Stack;

public class StackPeekMin {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minpeek = new Stack<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackPeekMin peekmin = new StackPeekMin();
		peekmin.push(5);
		peekmin.push(3);
		peekmin.push(1);
		peekmin.push(6);
		peekmin.push(7);

		peekmin.pop();
		peekmin.pop();
		peekmin.pop();
		peekmin.pop();
		peekmin.pop();

	}

	public StackPeekMin() {
	}

	public void push(int n) {
		stack.push(n);

		if (!(minpeek.size() > 0 && minpeek.peek() <= n))
			minpeek.push(n);
	}

	public void pop() {
		if (minpeek.peek().equals(stack.peek()))
			System.out.println(minpeek.pop());
		else
			System.out.println(minpeek.peek());
		stack.pop();

	}

}
