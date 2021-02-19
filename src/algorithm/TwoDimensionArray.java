package algorithm;

/**
 * 4. 二维数组中的查找
 * @author ZhangWenGuang
 *
 */
public class TwoDimensionArray {

	/**
	 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
	 * 给定一个数，判断这个数是否在该二维数组中。
	 */
	public static void main(String[] args) {
		int[][] data = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
	};
		System.out.println(method1(data, 20));

	}
	
	/**
	 * 从第一行最后一个开始比较，行为x，列为y，查询值大于该位置值x+1，小于y-1
	 * @param data
	 * @param n
	 * @return
	 */
	private static boolean method1(int[][] data, int n) {
		if (data == null || data.length <= 0 || data[0].length <= 0) return false;
		int rows = data.length;
		int cols = data[0].length;
		
		// 从右上角开始
		int x = 0;
		int y = cols - 1;
		
		while (x >= 0 && x < rows && y >= 0 && y < cols) {
			if (data[x][y] == n) {
				System.out.println("x: " + x + " y: " + y);
				return true;
			} else if (data[x][y] > n) {
				y--;
			} else {
				x++;
			}
		}
		
		return false;
	}

}
