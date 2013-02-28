

import java.util.Stack;

/** Get constant access to min element for a stack */
public class StackPeekMin {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minPeek = new Stack<Integer>();

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

		if (!(minPeek.size() > 0 && minPeek.peek() <= n))
			minPeek.push(n);
	}

	public void pop() {
		if (minPeek.peek().equals(stack.peek()))
			System.out.println(minPeek.pop());
		else
			System.out.println(minPeek.peek());
		stack.pop();

	}

}
