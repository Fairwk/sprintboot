package day20211122;

import java.util.Arrays;
import java.util.Stack;

/*
排序的三大指标 : 时间复杂度
              空间复杂度
              稳定性
(稳定性就是两个相等的数据,经过排序过后,排序算法能保证其对应位置不发生变化,
则我们称该算法具备稳定性的排序算法)
eg : 9  5a  2  7  3  6  4  5b
排序后 : 2  3  4  5a  5b  6  7 (这就是稳定的)
 */
public class Sort {

    /*
    直接插入排序
    时间复杂度:
    最好:O(n)  (数据有序的时候)
    最坏:O(n^2)  (数据逆序,无序)
    空间复杂度:O(1)
    稳定性: 稳定的(一个稳定的排序 可以实现为不稳定的排序;
                一个本身就不稳定的排序 不可以实现为稳定的排序)
     结论:当一组数据,数据量不大且趋近于有序,此时插入排序时间更快(越有序越快)
     */
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {//最坏:O(n)
            int tmp = array[i];
            int j = i-1;
            for(; j >= 0; j--){//最坏: O(n)
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    // array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /*
    希尔排序 :
    1.先分不同组 数据逐渐有序(预排序)
    2.整体排序(用直接插入排序)
    这是直接插入排序的优化
    gap(分组)越大 步子越大 移动的越快 越不有序
    gap越小的时候 步子越来越小了 移动变慢了 越来越有序了
    最后的gap一定是1
    gap > 1都是预排序 目的是数组更接近有序
     */

    /*
    array: 排序的数组
    gap: 每组的间隔  组数
     */
    public static void shell(int[] array,int gap){
        for(int i = gap; i < array.length; i++){
            int tmp = array[i];
            int j = i - gap;
            for(; j >= 0; j -=gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    /*
    时间复杂度:不好算  n^1.3~n^1.5
    空间复杂度:  O(1)
    稳定性:不稳定
    技巧:如果在比较过程中 没有发生跳跃式交换就稳定
     */

    public static void shellSort(int[] array){
        //处理gap
        int gap = array.length;
        while(gap > 1){
            gap = gap / 3 + 1;//+1 保证最后一个序列是1
            shell(array,gap);
        }
    }
    /*
    选择排序
    时间复杂度:
    最好: O(n^2)
    最坏: O(n^2)
    空间复杂度: O(1)
    稳定性 : 不稳定
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    /*
    堆排序
    时间复杂度: O(n*logn) 都是这个时间复杂度
    空间复杂度: O(1)
    稳定性: 不稳定的排序
     */
    public static void siftDown(int[] array,int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while(child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            //child的下标就是左右孩子的最大值下标
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else{
                break;
            }
        }
    }
    public static void createHeap(int[] array){
        //从小到大排序-->  大根堆
        for(int i = (array.length-1-1)/2; i >= 0; i--){
            siftDown(array,i,array.length);
        }
    }
    public static void heapSort(int[] array){
        createHeap(array);//O(n)
        int end = array.length-1;
        while(end > 0){//O(n*log2n)
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            siftDown(array,0,end);
            end--;
        }
    }
    /*
    冒泡排序
    时间复杂度:
    没优化的时候: 最好最坏都是O(n^2)
    优化后: 最好的时候O(n)(有序时)
    空间复杂度:O(1)
    稳定性:稳定的
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {//只需要排长度-1次(5个数字只需要排4次)
            boolean flg = false;//优化点
            for (int j = 0; j < array.length-1-i; j++) {//每一次比较的次数都比上一趟少1
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                break;
            }
        }
    }
    /*
    快速排序:
    1.挖坑法
    左边找比tmp小的值
    右边找比tmp大的值
    注:以左边数字为基准先走右边
    时间复杂度:
    最好: O(n*log2n)  均匀分割时
    最坏: O(n^2) 数据逆序的时候
    空间复杂度:
    最好: logn
    最坏: O(n)//数据多容易栈溢出
    稳定性: 不稳定的排序
     */
    public static int partition(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high){

            while(low < high && array[high] >= tmp){
                high--;
            }
            //找到了比tmp小的值让他去填low的坑
            array[low] = array[high];

            while(low < high && array[low] <= tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[high] = tmp;
        return low;
    }
    /*
    快速排序:
    三数取中法(挖坑法的优化)

     */
    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void selectPivotMedianOfThree(int[] array,int start,int end,int mid){
        //array[mid] <= array[start] <= array[end]
        if(array[mid] > array[start]){
            //array[mid] <= array[start]
            swap(array,start,mid);
        }
        if(array[start] > array[end]){
            //array[start] <= array[end]
            swap(array,start,end);
        }
        if(array[mid] > array[end]){
            swap(array,mid,end);
            //array[mid] <= array[end]
        }
    }
    /*
    快速排序:第二种优化 取一个阈值用直接插入排序
     */
    public static void insertSort(int[] array,int start,int end){
        for (int i = start+1; i <=end; i++) {//最坏:O(n)
            int tmp = array[i];
            int j = i-1;
            for(; j >= start; j--){//最坏: O(n)
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    // array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void quick(int[] array,int start,int end){
        if(start >= end){
            return;
        }
        //判断两个数据之间的个数
        if(end-start+1 <= 100){
            insertSort(array,start,end);
            return;
        }
        int mid = (start+end)/2;
        selectPivotMedianOfThree(array,start,end,mid);

        int pivot = partition(array,start,end);
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }
    public static void quickSort1(int[] array){


        quick(array,0,array.length-1);
    }
    /*
    非递归实现快速排序
     */
    public static void quickSort(int[] array){
        Stack<Integer> stack  = new Stack<>();
        int start = 0;
        int end = array.length-1;
        int pivot = partition(array,start,end);
        //左边有两个及以上元素
        if(pivot > start+1){
            stack.push(0);
            stack.push(pivot-1);
        }
         //右边有两个及以上元素
        if(pivot < end-1){
            stack.push(pivot+1);
            stack.push(end);
        }
        while(!stack.isEmpty()){
            end = stack.pop();
            start = stack.pop();
            pivot = partition(array,start,end);
            //左边有两个及以上元素
            if(pivot > start+1){
                stack.push(0);
                stack.push(pivot-1);
            }
            //右边有两个及以上元素
            if(pivot < end-1){
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }
    /*
    归并排序
    时间复杂度:O(n*log2n)
    空间复杂度: O(n)
    稳定性:稳定的
     */
    public static  void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = high;
        int[] tmp = new int[high-low+1];
        int k = 0;//代表tmp数组下标
        while(s1 <= e1 && s2 <= e2){
            if(array[s1] <= array[s2]){
                tmp[k] = array[s1];
                k++;
                s1++;
            }else{
                tmp[k] = array[s2];
                k++;
                s2++;
            }
        }
        //有两种情况
        while (s1 <= e1){
            //说明第二个归并段没有数据 把第一个归并段剩下的拷贝过来
            tmp[k] = array[s1];
            k++;
            s1++;
        }
        while(s2 <= e2){
            //说明第一个归并段没有数据 把第二个归并段剩下的拷贝过来
            tmp[k] = array[s2];
            k++;
            s2++;
        }
        //tmp数组当中存储的是归并过的数据
        for (int i = 0; i < tmp.length; i++) {
            array[i+low] = tmp[i];
        }
    }
    public static void mergeSortInternal(int[] array,int low,int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并的过程
        merge(array,low,mid,high);
    }
    public static void mergeSort1(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }
    /*
    归并排序: 非递归写法
     */
    public static  void merge2(int[] array,int gap){
        int[] tmp = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 >= array.length ? array.length-1 : s2+gap-1;
        //保证你有两个归并段
        while(s2 < array.length){
            while(s1 <= e1 && s2 <= e2){
                if(array[s1] <= array[s2]){
                    tmp[k++] = array[s1++];
                    //这个跟上面写的等价
                }else{
                    tmp[k++] = array[s2++];
                }
            }
            while (s1 <= e1){
                tmp[k++] = array[s1++];
            }
            while(s2 <= e2){
                tmp[k++] = array[s2++];
            }
            //走到这里说明一组完了 确定新的区间的开始和结束
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 >= array.length ? array.length-1 : s2+gap-1;
        }
        while (s1 <= array.length-1){
            tmp[k++] = array[s1++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }
    public static void mergeSort(int[] array){
        for (int i = 1; i < array.length; i*=2) {
            merge2(array,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {10,6,9,3,5};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
