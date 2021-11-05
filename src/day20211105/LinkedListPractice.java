package day20211105;

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        this.val = x;
    }
}
public class LinkedListPractice {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        head.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        LinkedListPractice solution = new LinkedListPractice();
        System.out.println(solution.middleNode(head).val);

    }
    public ListNode middleNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = head;
        int count = 0;
        while(pre != null){
            count++;
            pre = pre.next;
        }
        int middleIndex = count / 2;
        pre = head;
        for (int i = 0; i < middleIndex; i++) {
            pre = pre.next;
        }
        head = pre;
        return head;
    }

}