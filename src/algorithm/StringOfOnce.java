package algorithm;

import java.util.BitSet;

/**
 * 50. 第一个只出现一次的字符位置
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 * @author ZhangWenGuang
 *
 */
public class StringOfOnce {

	public static void main(String[] args) {
		String str = "abaccbedA";
		
		System.out.println(firstNotRepeating(str));
		
		System.out.println(firstNotRepeating2(str));
	}
	
	/*
	 * 最直观的解法是使用 HashMap 对出现次数进行统计：
	 * 字符做为 key，出现次数作为 value，遍历字符串每次都将 key 对应的 value 加 1。
	 * 最后再遍历这个 HashMap 就可以找出出现次数为 1 的字符。
	 * 考虑到要统计的字符范围有限，也可以使用整型数组代替 HashMap。
	 * ASCII 码只有 128 个字符，因此可以使用长度为 128 的整型数组来存储每个字符出现的次数。
	 */
	private static int firstNotRepeating(String str) {
		if (str == null || "".equals(str)) return -1;
		
		int[] charNum = new int[128];
		char[] charArray = str.toCharArray();
		
		for (char c : charArray) {
			charNum[c]++;
		}
		
		for (int i = 0; i < str.length(); i++) {
			
			if (charNum[charArray[i]] == 1) {
				System.out.println(charArray[i]);
				return i;
			}
		}
		
		return -1;
	}
	
	/*
	 * BitSet 可以更进一步节省存储空间  32：2
	 */
	private static int firstNotRepeating2(String str) {
		if (str == null || "".equals(str)) return -1;
		
		BitSet set1 = new BitSet(128);
		BitSet set2 = new BitSet(128);
		
		char[] chars = str.toCharArray();
		
		for (char c : chars) {
			if (!set1.get(c)) {
				set1.set(c);
			} else if (!set2.get(c)) {
				set2.set(c);
			}
		}
		
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (set1.get(c) && !set2.get(c)) {
				System.out.println(c);
				return i;
			}
		}
		
		return -1;
	}

}
