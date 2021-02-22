package algorithm;

import java.util.Stack;

/**
 * 30. 包含 min 函数的栈
 * @author ZhangWenGuang
 *
 */
public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	/**
	 * 每次压栈时，都将本次值与栈中之前最小值比较，存储最小
	 * @param node
	 */
	public void push(int node) {
		stack.push(node);
		minStack.push(minStack.isEmpty() ? node: Math.min(minStack.peek(), node));
	}
	
	public void pop() {
		stack.pop();
		minStack.pop();
	}
	
	public Integer top() {
		return stack.peek();
	}
	
	public Integer min() {
		return minStack.peek();
	}
	
	/**
	 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
	 * @param args
	 */
	public static void main(String[] args) {

		MinStack minStack = new MinStack();
		minStack.push(8);
		minStack.push(4);
		minStack.push(5);
		minStack.push(1);
		minStack.push(9);
		
		System.out.println(minStack.top() + "  " + minStack.min());
		minStack.pop();
		System.out.println(minStack.top() + "  " + minStack.min());
		minStack.pop();
		System.out.println(minStack.top() + "  " + minStack.min());
		minStack.pop();
		System.out.println(minStack.top() + "  " + minStack.min());
		minStack.pop();
		System.out.println(minStack.top() + "  " + minStack.min());
	}

}
