package algorithm;

/**
 * 4. ��ά�����еĲ���
 * @author ZhangWenGuang
 *
 */
public class TwoDimensionArray {

	/**
	 * ����һ����ά���飬��ÿһ�д����ҵ������򣬴��ϵ���Ҳ�ǵ�������
	 * ����һ�������ж�������Ƿ��ڸö�ά�����С�
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
	 * �ӵ�һ�����һ����ʼ�Ƚϣ���Ϊx����Ϊy����ѯֵ���ڸ�λ��ֵx+1��С��y-1
	 * @param data
	 * @param n
	 * @return
	 */
	private static boolean method1(int[][] data, int n) {
		if (data == null || data.length <= 0 || data[0].length <= 0) return false;
		int rows = data.length;
		int cols = data[0].length;
		
		// �����Ͻǿ�ʼ
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
