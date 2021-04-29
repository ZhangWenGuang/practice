package algorithm.doublepointer;

/**
 * 58.1 翻转单词顺序列
 * 
 * Input:
 * "I am a student."
 * Output:
 * "student. a am I"
 * 
 * @author ZhangWenGuang
 *
 */
public class SpinString {

	public static void main(String[] args) {

		String str = "I am a student.";
		char[] chars = str.toCharArray();
		int n = chars.length;
		
		int i = 0;
		int j = 1;
		while (j <= n) {
			if (j == n || chars[j] == ' ') {
				System.out.println(i);
				System.out.println(j);
				reverse(i, j - 1, chars);
				i = j + 1;
			}
			j++;
		}
		
		reverse(0, n - 1, chars);
		
		System.out.println(new String(chars));
		
	}

	private static void reverse(int i, int j, char[] chars) {
		while (i < j) {
			char c = chars[i];
			chars[i] = chars[j];
			chars[j] = c;
			i++;
			j--;
		}
	}

}
