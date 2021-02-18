package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. �������ظ�������
 * @author ZhangWenGuang
 *
 */
public class RepeatNumber {

	/*
		��Ŀ����
		1.��һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�
		2.������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�Ҳ��֪��ÿ�������ظ����Ρ�
		3.���ҳ�����������һ���ظ������֡�
	 */
	public static void main(String[] args) {
		// 1����=0.000001 ����
		long startTime = System.nanoTime();
		int[] nums = {2, 3, 1, 0, 2, 5};
//		method1(nums);
//		method2(nums);
		method3(nums);
		long endTime = System.nanoTime();
		System.out.println("����ʱ�䣺" + (double)(endTime - startTime) / 1000000 + "ms");
		
	}
	
	public static void method1(int[] nums) {
		// �Լ�����
		Set<Integer> list = new HashSet<Integer>();
		for (int num : nums) {
			if (list.contains(num)) {
				System.out.println(num);
			} else {
				list.add(num);
			}
		}
	}
	
	// �ݹ�ͣ������
	public static void method2(int[] nums) {
		// ������1�£����Խ�ֵ1������λ��1�������λ�ô��ڸ�ֵ���ظ�
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
			int temp = nums[index]; // ���ǵ�ǰֵҲ��Ŀ����±�
			nums[index] = nums[temp];
			nums[temp] = temp;
			exchange(nums, index);
		}
	}
	
	/*
	 * ����
	 * whileѭ����returnֹͣ
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
