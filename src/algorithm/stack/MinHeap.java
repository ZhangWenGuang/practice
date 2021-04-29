package algorithm.stack;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 40. 最小的 K 个数
 * @author ZhangWenGuang
 *
 */
public class MinHeap {

	/**
	 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
	 */
	
	/**
	 * 输入
		[4,5,1,6,2,7,3,8],4 
		返回值
		[1,2,3,4]
	 */
	
	public static void main(String[] args) {
//		int[] nums = {2, 6, 3, 9, 5, 1, 3, 7, 4};
//		getLeastNumbers(nums, 5);
		int[] nums = {9, 1, 3, 7, 5};
		
		getLeastNumbers_Solution(nums, 4);
	}
	
	public static void getLeastNumbers(int[] nums, int k) {
		if (k > nums.length || k < 1) return;
		
		// 优先队列（最小堆）  (o1, o2) -> o2 - o1 转为最大堆  最大堆可以保证所有数小于堆顶
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		
		// 所有数加入堆中，超过数量k，去掉堆顶
		for (int i : nums) {
			queue.add(i);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		System.out.println(new ArrayList<Integer>(queue));
		
	}
	
	public static void getLeastNumbers_Solution(int[] nums, int k) {
		if (k > nums.length || k < 1) return;
		
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		findKtnSmallest(nums, k - 1);
		
	}

	/**
	 *
	 * @param nums
	 * @param i  在排序过程中，满足个数的下标
	 */
	private static void findKtnSmallest(int[] nums, int i) {
		int l = 0;
		int h = nums.length - 1;
		while (l < h) {
			int j = partition(nums, l, h); // 经过比较后的数组截止下标，其中一边的值小于中间值，中间值下标
			
			if (j == i)
				break;
			if (j > i)  // 右边的都比中间值大
				h = j - 1; // j == i
			else // 左边的都比中间值小
				l = j + 1;
		}
	}

	private static int partition(int[] nums, int l, int h) {
		int p = nums[l]; // p:2 l:0
		int i = l;
		int j = h + 1;
		
		while (true) {
			while (i != h && nums[++i] < p); // 找出第一个大于等于p的下标i
			while(j != l && nums[--j] > p); // 找出第一个小于等于p的下标j
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, l, j);
		
		
		return j;
	}

	private static void swap(int[] nums, int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
