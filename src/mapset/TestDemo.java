package mapset;

import java.util.*;

/*
map: HashMap实现的 还有TreeMap(下去自己看) key-value键对
set: 不能存放重复元素 数学意义上的集合 只有key
HashMap和HashSet底层是hash表
TreeMap和TreeSet底层是搜索树(红黑树)
 */
class Node{
    int val;
    Node next;
    Node random;
    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo {
    /**
     * 前k个高频单词
     */
    public List<String> topKFrequent(String[] words,int k){
        List<String> ret = new ArrayList<>();
        //1.统计每个单词出现的次数 以map的形式进行存储
        if(words == null) return ret;
        HashMap<String,Integer> map = new HashMap<>();
        for (String str: words) {
            if(map.get(str) == null){
                map.put(str,1);
            }else{
                int count = map.get(str);
                map.put(str,count+1);
            }
        }
        //计算好了每个单词出现的频率
        //2.建一个小堆 堆中每个元素都是Map的Entry
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            //o1是你插入的元素 o1 > o2 o1直接就放到了数组的最后
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    //建堆的时候 按照字母顺序 建大堆 因为最后要逆置
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });
        //3.遍历map里面的元素 下将前k个建成小堆 然后从第k+1个开始 和堆顶元素比较
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            //堆 还没有放满k个
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else{
                Map.Entry<String,Integer> top = minHeap.peek();
                if(top != null) {
                    //1. 频率相同 判断key 字母小的 入堆
                    if (top.getValue().compareTo(entry.getValue()) == 0) {
                        if (top.getKey().compareTo(entry.getKey()) > 0) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    } else {
                        //2. 频率不同 把大频率入堆
                        if (top.getValue() < entry.getValue()) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> top = minHeap.poll();
            if(top != null){
                String key =top.getKey();
                ret.add(key);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
    /**
     * 坏键盘
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//期望的
        String str2 = scan.nextLine();//实际的

        HashSet<Character> setActual = new HashSet<>();
        for(char ch : str2.toUpperCase().toCharArray()){
            //先变成大写在变成数组输出
            setActual.add(ch);
        }
        HashSet<Character> setBroken = new HashSet<>();
        for(char ch : str1.toUpperCase().toCharArray()){
            if(!setActual.contains(ch) && ! setBroken.contains(ch)){
                //ch是坏的 这样就可以不打印重复的
                setBroken.add(ch);
                System.out.println(ch);
            }
        }
    }
    /**
     * 宝石与石头
     * @param
     * @return
     */
    public int numJewelsInStones(String jewels,String stones){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < jewels.length(); i++){
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for (char ch: stones.toCharArray()) {
            if(set.contains(ch)){
                count++;
            }
        }
        return count;
    }
    /*
    复制带随机指针的链表
     */
    public Node copyRandomList(Node head){
        if(head == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    /*
    只出现一次的数字
     */
    public int singleNumber(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
    /*
    有10万个数据,统计每个数据出现了多少次
    只找出重复数据出现的次数
     */
    public static void main5(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(10000));
        }
        //       数据      次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer key: list) {
            if(map.get(key) == null){
                map.put(key,1);
            }else{
                //说明以前以前储存过
                int count = map.get(key);//get就是获得key对应的value值
                map.put(key,count+1);

            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1){//说明数据是重复的
                System.out.println("重复的数据: "+entry.getKey() + "出现的次数 : " + entry.getValue());
            }
        }
    }
    /*
    有10万个数据 找到第一个重复的数据
     */
    public static void main4(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(10000));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if(set.contains(list.get(i))){
                System.out.println(list.get(i));
                break;
            }else{
                set.add(list.get(i));
            }
        }
    }
    /*
    有10万个数据,去掉重复的
     */
    public static void main3(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(10000));
        }

        HashSet<Integer> set = new HashSet<>();//因为Set里不放重复元素
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        System.out.println(set.size());
        System.out.println(set);//这样就删除了所有重复的元素
    }
    public static void main2(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("bit1");
        set.add("bit2");
        set.add("bit3");
        set.add("bit3");
        set.add(null);
        System.out.println(set);

        Iterator<String> it = set.iterator();//迭代器

        while(it.hasNext()){
            System.out.println(it.next());//打印it的下一个并且it++;
        }
        System.out.println("============");
        //String[] strings = (String[])set.toArray();
        //在java当中,数组不能进行整体的转换
        Object[] strings = set.toArray();
    }
    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("国民女神","高圆圆");
        map.put("阿强","王宝强");
        map.put(null,"kun");
        map.put(null,null);
        System.out.println("=============");
        Set< Map.Entry<String,String> > entrySet = map.entrySet();
        for (Map.Entry<String,String> entry: entrySet) {
            System.out.println("key: "+entry.getKey() + "val: " + entry.getValue());
        }


        System.out.println("=============");
        String val = map.get("国民女神");
        System.out.println(val);

        val = map.getOrDefault("国民女神2","如花");
        System.out.println(val);
        //map.put("阿强","强强");//key值一定是唯一的 如果key一样 那么val就更新
        System.out.println(map);//打印的顺序 不一定是 put的顺序 根据某种规则实现的
        Set<String> stringSet = map.keySet();//把所有的key放到一个集合
        System.out.println(stringSet);
    }
}
