package day20211118;

import java.util.PriorityQueue;
/*
TOPK 问题:
最优的解决方法 : 求前k个最大的就是建立一个大小为k的小堆
a.将当前数据的前K个建立为小堆
b.遍历剩下的元素,依次和堆顶元素比较.
如果当前i下标元素比堆顶元素大,就把i下标入堆
(堆顶元素一定是最小的 如果i都比你堆顶元素大 当前i下标最起码是满足要求的)
第K大的数据就是小堆的堆顶元素
相反 如果找前k个最小的就建立大堆

堆排序问题:
从小到大排:建立大堆
从大到小排:建立小堆
 */
public class TestMain {
    public static void main1(String[] args) {
        //底层是一个堆 大小默认为11
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //它默认是一个小堆还是大堆?   小堆
        queue.offer(61);
        queue.offer(21);
        queue.offer(1);
        System.out.println(queue);
    }
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.heapSort();
        //testHeap.pop();
        System.out.println("fasdfdsa");
    }
}
