package algorithm.doublepointer;

/**
 * 58.2 左旋转字符串
 * 
 * Input:
 * S="abcXYZdef"
 * K=3
 * 
 * Output:
 * "XYZdefabc"
 */
public class RotateString {

	public static void main(String[] args) {
		String s = "abcXYZdef";
		int k = 3;
		System.out.println(LeftRotateString(s, k));
	}
	
	public static String LeftRotateString(String str, int n) {
		if (n >= str.length()) return str;
		
		char[] chars = str.toCharArray();
		
		reverse(chars, 0, n - 1);
		reverse(chars, n, chars.length - 1);
		reverse(chars, 0, chars.length - 1);
		
		return new String(chars);
		
	}
	
	public static void reverse(char[] chars, int i, int j) {
		while (i < j) {
			char c = chars[i];
			chars[i] = chars[j];
			chars[j] = c;
			i++;
			j--;
		}
	}

}
