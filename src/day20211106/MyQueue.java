package day20211106;

class Node{
    private int val;
    private Node next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int val){
        this.val = val;
    }
}
public class MyQueue {
    /*
    从尾进从头出
     */
    private Node first;
    private Node last;
    //入队
    public void offer(int val){
        Node node = new Node(val);
        if(this.first == null){
            this.first = node;
            this.last = node;
        }else{
            this.last.setNext(node);//last.next = node
            this.last = node;

        }
    }
    //出队
    public int poll(){
        //1.判断队列是否为空
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空! ");
        }
        int ret = this.first.getVal();
        this.first = this.first.getNext();//this.first = this.first.next;
        return ret;
    }
    //得到队头元素但不出队
    public int peek(){
        //1.判断队列是否为空
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空! ");
        }
        int ret = this.first.getVal();
        return ret;

    }
    //队列是否为空
    public boolean isEmpty(){
        return this.first == null;

    }

}
