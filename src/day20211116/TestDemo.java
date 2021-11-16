package day20211116;

import java.util.Scanner;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}
public class TestDemo {


    //将二叉搜索树转换为有序双向列表  思路:先用中序遍历会遍历出的有序
    public static TreeNode prev = null;
    public void ConvertChild(TreeNode pCur){
        if(pCur == null){
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null){
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null) return null;
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head.left != null){
            head = head.left;
        }
        return head;
    }
    //找两个节点的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root == null) {
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);
        if(leftTree != null && rightTree != null){
            return root;
        }
        //代码能走到这里,说明:一个肯定为空
        if(leftTree != null){
            return leftTree;
        }
        if(rightTree != null){
            return rightTree;
        }
        return null;//说明没有公共祖先
    }
    public static int i = 0;
    public static TreeNode createTree(String str){
        if(str == null) return null;
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        TreeNode root = createTree(str);
        inorder(root);

    }
}
