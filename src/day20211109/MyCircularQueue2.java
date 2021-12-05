package day20211109;

public class MyCircularQueue2 {

        private int[] elem;//创建数组
        private int front;//头
        private int rear;//尾巴  可以存放当前元素的下标
        private int size;
        private int k;

        public void MyCircularDeque2(int k) {
            this.elem = new int[k];
            this.k = k;
            this.front = 0;
            this.rear = 0;
        }

        public boolean insertFront(int value) {
            if(isFull()) return false;
            this.front = (this.front - 1 + this.elem.length)%this.elem.length;
            this.elem[this.front] = value;
            this.size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) return false;
            this.elem[this.rear] = value;
            this.rear = (this.rear+1)%this.elem.length;
            this.size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;
            int val = this.elem[this.front];
            this.front = (this.front+1)%this.elem.length;
            this.size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) return false;
            this.rear = (this.rear - 1 + this.elem.length)%this.elem.length;
            int val = this.elem[this.rear];
            this.size--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) return -1;
            return this.elem[this.front];
        }

        public int getRear() {
            if(isEmpty()) return -1;
            return this.elem[(this.rear-1 + this.elem.length)%this.elem.length];
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.k;
        }


}
