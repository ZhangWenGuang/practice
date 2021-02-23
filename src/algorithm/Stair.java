package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 台阶问题
 * @author ZhangWenGuang
 *
 */
public class Stair {

	/**
	 * 有一排台阶，高低不同。
	 * 如果下雨，台阶最多可以储存多少高度单位的水？
	 * o(n)?
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stairs = {2, 5, 9, 1, 6, 3, 5, 7};
		System.out.println(getWater(stairs));
		
		int[] stairs2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(getWater(stairs2));
		
		int[] stairs3 = {1, 0, 2, 3, 5, 2, 1, 3, 2, 4, 3};
		System.out.println(getWater(stairs3));
		
	}
	
	private static int getWater(int[] stairs) {
		int water = 0;
		
		List<Integer> topList = new ArrayList<Integer>();
		for (int i = 0; i < stairs.length; i++) {
			if (i == 0 && stairs[i] > stairs[i + 1]) {
				topList.add(i);
			} else if (i == stairs.length - 1 && stairs[i - 1] < stairs[i]) {
				topList.add(i);
			} else if (i != 0 && i != stairs.length - 1 && stairs[i - 1] < stairs[i] && stairs[i] > stairs[i + 1]) {
				topList.add(i);
			}
		}
		
		System.out.println(topList);
		
		if (topList.size() > 2) {
			int i = 1;
			while (i < topList.size() - 1) {
				if (stairs[topList.get(i - 1)] > stairs[topList.get(i)] && stairs[topList.get(i)] < stairs[topList.get(i + 1)]) {
					topList.remove(i);
				} else {
					i++;
				}
			}
		}
		
		System.out.println(topList);
		
		if (topList.size() >= 2) {
			for (int i = 0; i < topList.size() - 1; i++) {
				int n = topList.get(i);
				int m = topList.get(i + 1);
				int x = stairs[n] > stairs[m] ? stairs[m] : stairs[n];
				for (int j = n + 1; j < m; j++) {
					if (x > stairs[j]) {
						water = water + x - stairs[j];
					}
				}
			}
		}
		
		return water;
	}

}
