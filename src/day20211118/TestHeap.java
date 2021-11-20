package day20211118;
/*
1.顺序存储 存储的是一颗完全二叉树 如果是非完全二叉树会有空间浪费
2.堆逻辑上是一颗完全二叉树
3.堆物理上是保存在数组中的
4.每棵树的根节点都是大于孩子节点的,此时这棵树就叫做大根堆
5.棵树的根节点都是小于孩子节点的,此时这棵树就叫做小根堆
  (不管是大根堆还是小根堆 左右还在的大小关系是不确定的,我们只能确定根节点和孩子节点的关系)
6.堆的作用就是快速找到最值
7.要计算最坏情况下的时间复杂度 实际上就是一颗满二叉树,这样每棵树都要进行调整
    假设这棵树的高度是h
    (1) 每一层有多少节点?
         2^0,2^1,2^2,2^3
        倒数第二层的节点有多少个?
        2^(h-2)
        最后一层节点是:2^(h-1)
    (2) 每一层调整的高分别是多少?
         第一层:h-1
         第二层:h-2
            .
            .
         倒数第二层:1
 公式为: T(n) = 2^0*(h-1) + 2^1*(h-2) + 2^2*(h-3) + 2^3*(h-4) + ... + 2^(h-3)*2 + 2^(h-2)*1
 等式两边同乘2 : 2*T(n) = 2^1*(h-1) + 2^2(h-2) + 2^3*(h-3) + 2^4*(h-4)+... +2^(h-2)*2 + 2^(h-1)*1
 错位相减法: T(n) = 2^1 + 2^2 + 2^3 + 2^4 + ... + 2^(h-2) + 2^(h-1)-h+1
 T(n) = 2^0 + 2^1 + 2^2 + 2^3 + 2^4 + ... + 2^(h-2) + 2^(h-1)-h
 等比数列求和公式 : Sn = (a1 - an*q)/1-q
 T(n) = 2^h-1-h
 假设n个节点 : n = 2^h-1
 2^h = n+1
 h = log2(n+1)
 T(n) = n - log2(n+1)
当n越变越大时 log2X曲线趋平(不变)
所以当n慢慢变大时整个表达式的结果就趋近于n
所以T(n) = O(n)(建堆的时间复杂度)

 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(){
        this.elem = new int[10];
    }
    /*
    建一个大堆
     */

    public void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //parent 就代表每颗子树的根节点
        for(int parent = (array.length-1-1)/2;parent >= 0;parent--){
            //第二个参数 每次调整的结束位置应该是 : this.usedSise(10)取小于号即可
            adjustDown(parent,this.usedSize);
        }
    }
    public void adjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;

        while(child < len){
            //可以进行调整 找到左右孩子的最大值
            //1.前提是要有右孩子
            //2.左孩子比右孩子小 才进行这一步
            if(child + 1 < len && this.elem[child] < this.elem[child+1]){
                child++;
                //这一步能保证,child下标的数据 一定是左右孩子的最大值的下标
            }
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                //当调整过程中孩子节点没有父亲节点的大,就说明这棵树已经是大根堆了,不需要调整直接break即可
                break;
            }
        }
    }
}
