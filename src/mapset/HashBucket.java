package mapset;

/**
 *如果采用哈希桶的方式 当扩容成功之后 原来桶中的数据 得重新哈希
 * 重新遍历原来桶中的数据 重新哈希
 */
public class HashBucket {
    static class Node{
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] array;
    public int usedSize;
    public HashBucket(){
        this.array = new Node[10];
        this.usedSize = 0;
    }
    public void put(int key,int val){
        //1.确定下标
        int index = key % this.array.length;
        //2.遍历这个下标的链表
        Node cur = array[index];
        while(cur != null){
            //更新val
            if(cur.key == key){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //cur == null 当前数组下标的链表没有key
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        //判断当前有没有超过负载因子
        if(loadFactor() >= 0.75){
            //扩容
            resize();
        }
    }
    public int get(int key){

        //以什么方式存储 就以什么方式取
        int index = key % this.array.length;
        Node cur = array[index];
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
    public double loadFactor(){
        return this.usedSize*1.0 / this.array.length;
    }
    public void resize(){
        //自己创建新的2倍数组
        Node[] newArray = new Node[2*this.array.length];
        //遍历原来的哈希桶
        //最外层循坏 控制数组下标
        for (int i = 0; i < this.array.length; i++) {
            Node cur = array[i];
            Node curNext = null;
            while(cur != null){
                //记录cur.next
                curNext = cur.next;
                //在新的数组里面的下标
                int index = cur.key % newArray.length;
                //进行头插法
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    public static void main(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(1,1);
        hashBucket.put(4,4);
        hashBucket.put(14,14);
        hashBucket.put(24,24);
        hashBucket.put(34,34);
        hashBucket.put(44,44);
        hashBucket.put(54,54);
        hashBucket.put(64,64);
        System.out.println(hashBucket.get(54));
        System.out.println("hhhh");

    }
}
