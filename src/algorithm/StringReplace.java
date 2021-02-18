package algorithm;

/**
 * 5. 替换空格
 * @author ZhangWenGuang
 *
 */
public class StringReplace {

	/**
	 * 将一个字符串中的空格替换成 "%20"。
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。
		② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
		③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
		 */
		
		// api实现，上方的解题思路感觉对java没有意义
		String n = "A B ";
		
		n = n.replaceAll(" ", "%20");
		
		System.out.println(n);
	}

}
