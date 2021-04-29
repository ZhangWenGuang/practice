package algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 41.2 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 * 
 * @author ZhangWenGuang
 *
 */
public class AppearingOnce {

	private int[] cnts = new int[128];
	private Queue<Character> queue = new LinkedList<Character>();

	public void insert(char c) {
		cnts[c]++;
		queue.add(c);
		while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
			queue.poll();
		}
	}
	
	public char firstAppearingOnce() {
		return queue.isEmpty()? '#' : queue.poll();
	}
	
	public static void main(String[] args) {
		AppearingOnce once = new AppearingOnce();
		String str = "LinkedList";
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			once.insert(c);
		}
		System.out.println(once.firstAppearingOnce());
	}

}
