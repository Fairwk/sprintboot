package HashTable;

import java.util.HashMap;

/**
 * hashtable(哈希表)还称为散列表 它的增删改查 时间复杂度是O(1)
 * 冲突: 不同的关键字 key 通过相同的哈希函数 得到了相同的位置
 * 负载因子 = 当前存入表中的数据个数/表的大小
 *负载因子越大 冲突率越大
 * 避免冲突: 设计合理的哈希函数 负载因子的调节
 * 如果要降低负载因子 那么只能增加表的大小
 * 不管我们怎么样避免 冲突一定会有的
 * 解决冲突: 闭散列  开散列
 * 闭散列: 开放地址法 分为线性探测和二次探测
 * 线性探测缺点: 会把冲突的元素都挤在一起
 * 二次探测: (hash(key) + i^2)% m(表的大小)
 * 开散列:哈希桶/链地址法/开链法
 */
public class TestDemo {
    /**
     * 找第一个不重复的字符
     */
    public int firstUniqChar(String s){
        if(s == null) return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            if(map.get(ch) == null){
                map.put(ch,1);
            }else{
                int count = map.get(ch);
                map.put(ch,count+1);
            }
        }
        for(int i = 0; i <s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
