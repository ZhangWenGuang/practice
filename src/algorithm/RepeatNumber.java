package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 数组中重复的数字
 * @author ZhangWenGuang
 *
 */
public class RepeatNumber {

	/*
		题目描述
		1.在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
		2.数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
		3.请找出数组中任意一个重复的数字。
	 */
	public static void main(String[] args) {
		// 1纳秒=0.000001 毫秒
		long startTime = System.nanoTime();
		int[] nums = {2, 3, 1, 0, 2, 5};
//		method1(nums);
//		method2(nums);
		method3(nums);
		long endTime = System.nanoTime();
		System.out.println("消耗时间：" + (double)(endTime - startTime) / 1000000 + "ms");
		
	}
	
	public static void method1(int[] nums) {
		// 自己理解的
		Set<Integer> list = new HashSet<Integer>();
		for (int num : nums) {
			if (list.contains(num)) {
				System.out.println(num);
			} else {
				list.add(num);
			}
		}
	}
	
	// 递归停不下来
	public static void method2(int[] nums) {
		// 在条件1下，可以将值1调整到位置1，如果该位置存在该值即重复
		for (int i = 0; i < nums.length; i++) {
			exchange(nums, i);
		}
	}
	
	private static void exchange(int[] nums, int index) {
		if (nums[index] != index) {
			if (nums[index] == nums[nums[index]]) {
				System.out.println(nums[index]);
				return;
			}
			int temp = nums[index]; // 既是当前值也是目标的下标
			nums[index] = nums[temp];
			nums[temp] = temp;
			exchange(nums, index);
		}
	}
	
	/*
	 * 最优
	 * while循环，return停止
	 */
	public static boolean method3(int[] nums) {
		if (nums == null) return false;
		
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				int j = nums[i];
				if (nums[j] == nums[i]) {
					System.out.println(nums[i]);
					return true;
				}
				swap(nums, i, j);
			}
		}
		return false;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
