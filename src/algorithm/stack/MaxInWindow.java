package algorithm.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 59. 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * 
 * @author ZhangWenGuang
 *
 */
public class MaxInWindow {

	public static void main(String[] args) {
		
		List<Integer> maxList = new ArrayList<Integer>();
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		
		int[] nums = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
		
		int size = 3;
		
		for (int i = 0; i < size; i++) {
			queue.add(nums[i]);
		}
		
		maxList.add(queue.peek());
		
		for (int i = size; i < nums.length; i++) {
			queue.remove(nums[i - size]);
			queue.add(nums[i]);
			maxList.add(queue.peek());
		}

		System.out.println(maxList);
	}

}
