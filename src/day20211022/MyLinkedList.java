package day20211022;


class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;

    }
}
public class MyLinkedList {
    public Node head;//保存单链表的头结点的引用
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);

        if(this.head == null){
            //第一次插入节点
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;

    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;


    }
    //任意位置插入,第一个数据节点为0的下标
    public void addIndex(int index,int data){

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == this.size()){
            addLast(data);
            return;
        }
        //先找到index位置的前一个节点的地址
        Node cur = searchIndex(index);
        Node node = new Node(data);
        //进行插入
        node.next = cur.next;
        cur.next = node;

    }
    private Node searchIndex(int index){
        if(index < 0 || index > this.size()){
            throw new RuntimeException("index位置不合法!");
        }
        Node cur = this.head;

        while(index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;

    }
    //查找是否包含关键字key是否在单链表当中
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

    private Node searchPrev(int key){
        Node prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key){
                return prev;
            }else{
                prev = prev.next;
            }
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if(prev == null){
            System.out.println("根本没有这个节点! ");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = this.head.next;//代表要删除的节点
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;

    }
    //打印单链表
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

    }
    //清空单链表  释放内存
    public void clear(){
        this.head = null;
    }
    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while(cur != null){
            Node curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node FindKthToTail(int k){
        if(head == null){
            return null;
        }
        if(k <= 0){
            //throw new RuntimeException("k不合理! ");
            System.out.println("k不合法");
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k-1 > 0){
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else{
                System.out.println("没有这个节点! ");
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node partition (int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while(cur != null){
            if(cur.data < x){
                //第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;

                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                //第一次插入
                if(as == null){
                    as = cur;
                    ae = cur;

                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //1.判断bs是否为空  如果bs == null返回 as
        if(bs == null){
            return as;
        }
        //2.如果bs不为空  需要进行拼接
        be.next = as;
        //3.如果ae不为空  ae的next需要置为空
        if(ae != null){
            ae.next = null;
        }
        return bs;
    }
}
