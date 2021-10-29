package day20211029;


class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head;//用来标志双向链表的头
    public Node tail;//用来标志双向链表的尾巴
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }

    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

    }

    private void checkIndex(int index){
        if(index < 0 || index > size()){
            throw new RuntimeException("index不合法! ");
        }
    }

    private Node searchIndex(int index){
        Node cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;

    }
    //任意位置插入 第一个数据节点为0号下标
    public void addIndex(int index, int data){
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }

        //找到index的位置
        Node cur = searchIndex(index);
        Node node = new Node(data);
        //进行插入
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;


    }
    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public int remove(int key){
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key){
                int oldData = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;

                        this.head.prev = null;


                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }
                    //删除的是尾巴节点只需要移动tail
                    this.tail = cur.prev;

                }
                return oldData;
            }
                cur = cur.next;

        }
        return -1;

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key){
                int oldData = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;
                    if(this.head  != null){
                        this.head.prev = null;
                    }

                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }
                    //删除的是尾巴节点只需要移动tail
                    this.tail = cur.prev;

                }
            }
            cur = cur.next;

        }
    }
    //得到双向链表的长度
    public int size(){
        Node cur = this.head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    //打印双向链表
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //清空双向链表 需要一个一个节点进行释放
    public void clear(){
        while(this.head != null){
            Node cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
            this.tail = null;

    }
}
