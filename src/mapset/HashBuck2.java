package mapset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 *     1.hashcode和equals的区别?
 *     (1)hashcode是定位当前的元素,需要在当前数组(桶)当中的下标
 *     (2)equals是需要在hashcode定位的某个下标(桶)中,
 *     遍历链表 比较哪个key是相同的
 *     2.如果两个数据的hashcode相同 equals一定相同吗?
 *     一定能定位到相同的位置,但equals不一定相同
 *     3.如果两个数据的hashcode不同 equals一定相同吗?
 *     定位到的位置不相同,equals一定不同
 *     4.如果两个数据的equals相同 hashcode一定相同吗?
 *     hashcode一定相同
 *     5.如果以后hashmap当中 需要存放自己自定义的数据类型
 *     那么这个数据类型,一定同时重写hashcode和equals方法
 *     6.HashMap:
 *     默认初始容量: 2^4 = 16
 *     数组的最大容量 : 2^30
 *     默认的负载因子: 0.75f
 *     变成红黑树的前提是数组的大小超过64
 *     7.HashMap什么时候占用内存?
 *     第一次put的时候(16)
 *     8.HashMap的put
 *     (1) 首先对key求hashcode,第一次put的时候,容量才真正有了,大小是16
 *     (2) 找下标进行尾插
 *     (3) 处理红黑树: 当数组容量大于64,且链表长度超过8
 *     9.hashMap什么时候扩容?
 *     根据负载因子
 *     10.new一个hashMap的容量
 *     age: new HashMap(19) 得到的容量就会是32
 *     因为他只能求得最接近给出容量的2的多少次方
 */
class Person{
    public String id;
    public Person(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class HashBuck2<K,V> {
    static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }

    public Node <K,V>[] array = (Node<K, V>[]) new Node[10];
    public int usedSize;

    public void put(K key,V val){
        //通过hashcode方法定位数组下标
        int hash = key.hashCode();
        //hashcode方法可以获得类似于地址的东西 每个都不相同
        int index = hash % this.array.length;
        Node<K,V> cur = array[index];
        while(cur != null){
            //equals 起的作用是 遍历当前数组下标的key是否相同
            if(cur.key.equals(key)){
                cur.val = val;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node<>(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }
    public V gey(K key){
        int hash = key.hashCode();
        int index = hash % this.array.length;
        Node<K,V> cur = array[index];
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //此时数组的大小为0
        HashMap<String,String> map = new HashMap<>();

    }

    public static void main2(String[] args) {
        Person person1 = new Person("123456");
        Person person2 = new Person("123456");
        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,"bit");
        System.out.println(hashBuck2.gey(person2));
    }
    public static void main1(String[] args) {
        Person person1 = new Person("123456");
        Person person2 = new Person("123456");
        System.out.println(person1.equals(person2));
    }

}
