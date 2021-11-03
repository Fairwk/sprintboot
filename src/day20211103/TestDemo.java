package day20211103;

 class Node{
    public int val;
    public Node next = null;
    public Node(int val){
        this.val = val;
    }
}
public class TestDemo {
     //创建一个固定内容的链表
    //使用头节点代表整个链表 最后返回头节点
    public static Node List(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;

    }

    public static void main(String[] args) {
        Node head = List();
        Node cur = head;
        //1.遍历链表
        /*while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        //2.遍历链表找到最后一个节点
        while(cur != null && cur.next != null){
            cur = cur.next;
        }
        System.out.println(cur.val);
        //3.遍历链表并找到倒数第二个节点
        while(cur != null && cur.next != null && cur.next.next != null){
            cur = cur.next;
        }
        System.out.println(cur.val);
        //4.取链表的第n个节点
        int n = 3;
        for (int i = 1; i < n; i++) {
            cur = cur.next;
        }
        //此时cur指向的元素就是正数第n个元素
        System.out.println(cur.val);
        //5.获取链表的长度
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        System.out.println(count);*/
        //6.查找链表中是否存在某个元素
        int toFind = 3;
        while (cur != null) {
            if(cur.val == toFind){
                break;
            }
            cur = cur.next;
        }
        if (cur != null){
            System.out.println("找到了! ");
        }else{
            System.out.println("没找到! ");
        }

    }
}
