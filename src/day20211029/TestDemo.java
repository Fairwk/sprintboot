package day20211029;

public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.display();
        //System.out.println(myLinkedList.contains(4));
        //System.out.println(myLinkedList.size());
        /*myLinkedList.addIndex(2,20);
        myLinkedList.display();
        myLinkedList.addIndex(0,99);
        myLinkedList.display();
        myLinkedList.addIndex(5,999);
        myLinkedList.display();*/
        myLinkedList.removeAllKey(2);
        myLinkedList.display();
    }
}
