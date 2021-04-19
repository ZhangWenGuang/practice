package algorithm.stack;

import java.util.Stack;

/**
 * 31. 栈的压入、弹出序列
 * @author ZhangWenGuang
 *
 */
public class StackOrder {

	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] pushOrder = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] popOrder = {1, 2, 4, 5, 6, 3, 7, 8};
		
		boolean checkStackOrder = checkStackOrder(pushOrder, popOrder);
		System.out.println(checkStackOrder);

	}
	
	private static boolean checkStackOrder(int[] in, int[] out) {
		if (in == null || out == null || in.length != out.length) return false;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0, j = 0; i < in.length; i++) {
			stack.push(in[i]);
			while (j < out.length && !stack.isEmpty() && stack.peek() == out[j]) {
				stack.pop();
				j++;
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
