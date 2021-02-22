package algorithm;

import java.util.Stack;

/**
 * 9. 用两个栈实现队列
 * @author ZhangWenGuang
 *
 */
public class TwoStack {
	
	/**
	 * 题目描述:
	 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			Queue queue = new Queue();
			queue.push(1);
			queue.push(2);
			System.out.println(queue.pop());
			queue.push(4);
			queue.push(3);
			System.out.println(queue.pop());
			System.out.println(queue.pop());
			System.out.println(queue.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * in正常存储，每次pop时，如果out不为空，依次出栈；为空，将in的数据依次压入out，实现先入后出转为先入先出
 * @author ZhangWenGuang
 *
 */
class Queue {
	private Stack<Integer> in = new Stack<Integer>();
	private Stack<Integer> out = new Stack<Integer>();
	
	public void push(int node) {
		in.push(node);
	}
	
	public Integer pop() throws Exception {
		if (out.isEmpty())
			while (!in.isEmpty())
				out.push(in.pop());
		
		if (out.isEmpty())
			throw new Exception("queue is empty");
		
		return out.pop();
	}
}
