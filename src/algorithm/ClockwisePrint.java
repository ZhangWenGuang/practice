package algorithm;

/**
 * 29. 顺时针打印矩阵
 * @author ZhangWenGuang
 *
 */
public class ClockwisePrint {

	/*
	 * 按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		print(data);
		
		System.out.println();
		int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		print(data2);
		
	}
	
	/*
	 * 以圈为单位进行循环，通过r1 r1 c1 c2建立每圈的坐标范围
	 */
	private static void print(int[][] data) {
		if (data == null || data.length == 0 || data[0].length == 0) return;
		
		int r1 = 0;
		int r2 = data.length - 1;
		int c1 = 0;
		int c2 = data[0].length - 1;
		
		while(r1 <= r2 && c1 <= c2) {
			int x = r1;
			int y = c1;
			// 上
			while (y < c2) {
				System.out.println(data[x][y++]);
			};
			// 右
			while (x < r2) {
				System.out.println(data[x++][y]);
			}
			// 下
			while (y > c1) {
				System.out.println(data[x][y--]);
			}
			// 左
			while (x > r1) {
				System.out.println(data[x--][y]);
			}
			r1++;
			r2--;
			c1++;
			c2--;

		}
	}

}
