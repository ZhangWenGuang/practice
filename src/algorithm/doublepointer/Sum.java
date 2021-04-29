package algorithm.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57.1 和为 S 的两个数字
 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 * 
 * @author ZhangWenGuang
 *
 */
public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] data = new int[] {1, 2, 3, 5, 7, 8, 9, 14, 16, 19};
//		System.out.println(FindNumbersWithSum(data, 9));
		
		System.out.println(FindContinuousSequence(100));
	}
	
	/*
	 * 57.1 和为 S 的两个数字
	 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
	 */
	public static List<Integer> FindNumbersWithSum(int[] data, int num) {
		int i = 0;
		int j = data.length - 1;
		
		while (i < j) {
			int a = data[i] + data[j];
			if (a == num) {
				return Arrays.asList(data[i], data[j]);
			}
			if (a > num) {
				j--;
			} else {
				i++;
			}
		}
		
		return new ArrayList<Integer>();
	}
	
	/*
	 * 57.2 和为 S 的连续正数序列
	 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
	 * [9, 10, 11, 12, 13, 14, 15, 16]
	 * [18, 19, 20, 21, 22]
	 */
	public static List<List<Integer>> FindContinuousSequence(int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int i = 1;
		int j = 2;
		int curSum = i + j;
		while (j < sum) {
			if (curSum > sum) {
				curSum -= i;
				i++;
			} else if (curSum < sum) {
				j++;
				curSum += j;
			} else {
				List<Integer> tempList = new ArrayList<Integer>();
				for (int a = i; a <= j; a++) {
					tempList.add(a);
				}
				list.add(tempList);
				curSum -= i;
				i++;
				j++;
				curSum +=j;
			}
		}
		
		return list;
	}

}
