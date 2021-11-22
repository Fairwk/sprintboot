package day20211122;

import java.util.Arrays;

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
    public static void main(String[] args) {
        int[] array = {10,6,9,3,5};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
