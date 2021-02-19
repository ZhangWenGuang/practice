package algorithm;

/**
 * 29. ˳ʱ���ӡ����
 * @author ZhangWenGuang
 *
 */
public class ClockwisePrint {

	/*
	 * ��˳ʱ��ķ��򣬴��⵽���ӡ�����ֵ����ͼ�ľ����ӡ���Ϊ��1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
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
	 * ��ȦΪ��λ����ѭ����ͨ��r1 r1 c1 c2����ÿȦ�����귶Χ
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
			// ��
			while (y < c2) {
				System.out.println(data[x][y++]);
			};
			// ��
			while (x < r2) {
				System.out.println(data[x++][y]);
			}
			// ��
			while (y > c1) {
				System.out.println(data[x][y--]);
			}
			// ��
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
