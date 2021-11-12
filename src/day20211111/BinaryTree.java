package day20211111;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val){
        this.val = val;
    }
}
public class BinaryTree {

    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    //前序遍历
    //第一种方法 .没有返回值的方法
    void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //第二种方法 又返回值的方法
    public List<Character> preOrderTraversal2(TreeNode root){
        List<Character> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        ret.add(root.val);
        List<Character> leftTree = preOrderTraversal2(root.left);
        ret.addAll(leftTree);
        List<Character> rightTree = preOrderTraversal2(root.right);
        ret.addAll(rightTree);
        return ret;
    }
    //中序遍历
    //第一种,没有返回值的方法
    List<Character> inOrderTraversal(TreeNode root){
        if(root == null){
            return null;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
        return null;
    }
    //第二种又返回值的方法
    public List<Character> inOrderTraversal2(TreeNode root){
        List<Character> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        List<Character> leftTree = inOrderTraversal(root.left);
        ret.addAll(leftTree);
        ret.add(root.val);
        List<Character> rightTree = inOrderTraversal(root.right);
        ret.addAll(rightTree);
        return ret;

    }
    //后序遍历
    //第一种方法没有返回值
    void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
    //第二种方法有返回值
    public List<Character> postOrderTraversal2(TreeNode root){
        List<Character> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        List<Character> leftTree = postOrderTraversal2(root.left);
        ret.addAll(leftTree);
        List<Character> rightTree = postOrderTraversal2(root.right);
        ret.addAll(rightTree);
        ret.add(root.val);
        return ret;
    }
    //遍历思路--求节点的个数
    static int size = 0;
    void getSize1(TreeNode root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    //子问题思路--求节点个数
    int getSize2(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right)+1;
    }
    //遍历思路-求叶子节点的个数
    static int leafSize = 0;
    void getLeafSize1(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }
    //子思路问题-求叶子节点的个数
    int getLeafSize2(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    //求k层节点的个数
    int getKLevelSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    //查找在二叉树中有没有val这个元素
    TreeNode find(TreeNode root,char val){
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null){
            return ret;
        }
        return null;
    }
    //获取二叉树的高度
    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) +1;

    }
    //两个子树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }
        //走到这里还有可能两个都为空
        if(p == null && q == null){
            return true;
        }
        //都不为空
        if(p.val != q.val){
            return false;
        }
        //p和q不为空,且对应值都是相同的,那么去判断两棵树的左树和右树
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //判断是不是另一个数的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null) return false;
        if(isSameTree(root,subRoot) ) return true;

        if(isSubtree(root.left,subRoot)) return true;

        if(isSubtree(root.right,subRoot)) return true;

        return false;
    }
    //判断二叉树是不是平衡二叉树
    //时间复杂度很高O(n^2)
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    //另一种方法时间复杂度低,主要求高度时不一样O(n)
    //运用自下而上的方式求高度
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        //只要 当前根的左树或者右树不满足就不会进入if语句
        if(leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight-rightHeight) <= 1){
            return Math.max(leftHeight,rightHeight)+1;
        }else{
            return -1;
        }
    }
    public boolean isBalanced2(TreeNode root){
        return maxDepth(root) >= 0;
    }
}
