package day20211101;


import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> generate(int numRows){
        if(numRows == 0){
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();

        //处理第一行
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);//把第一行处理完了

        //从第二行开始进行处理
        for (int i = 0; i < numRows; i++) {
            //获取上一行
            List<Integer> prevRow = ret.get(i-1);

            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);//当前行的第一个元素是1
            //当前行中间位置的值 = 上一行当前列 + 上一行前一列的值
            for (int j = 0; j < i; j++) {
                int val = prevRow.get(j) + prevRow.get(j-1);
                curRow.add(val);

            }
            //当前行最后一个元素为1
            curRow.add(1);

            ret.add(curRow);

        }
        return ret;
    }
}
public class YangHui {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.generate(3);
        System.out.println(list);

    }
}
