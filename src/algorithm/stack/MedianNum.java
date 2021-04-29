package algorithm.stack;

import java.util.PriorityQueue;

/**
 * 41.1 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * @author ZhangWenGuang
 *
 */
public class MedianNum {

	/* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
	private PriorityQueue<Integer> rightQueue = new PriorityQueue<Integer>();
	/* 大顶堆，存储左半边元素 */
	private PriorityQueue<Integer> leftQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
	/* 当前数据流读入的元素个数 */
	int n = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianNum bo = new MedianNum();
		int[] num = new int[] {1, 2, 6, 9, 5, 4, 3, 8};
		for (int i : num) {
			bo.insert(i);
		}
		System.out.println(bo.getMedian());
	}
	
	public void insert(int i) {
		n++;
		// 左右两边依次放入一个数，并将顶端的数给对方
		if (n % 2 == 0) {
			leftQueue.add(i);
			rightQueue.add(leftQueue.poll());
		} else {
			rightQueue.add(i);
			leftQueue.add(rightQueue.poll());
			
		}
	}
	
	public int getMedian() {
		System.out.println(leftQueue);
		System.out.println(rightQueue);
		if (n / 2 == 0) {
			return (leftQueue.peek() + rightQueue.peek()) / 2;
		} else {
			return leftQueue.peek();
		}
	}

}
