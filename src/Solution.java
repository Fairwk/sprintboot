
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class Solution {
    //给定前序遍历和中序遍历求后序
    public int prindex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend ){
        if(inbegin > inend){
            return null;//左树或者右树为空
        }
        TreeNode root = new TreeNode(preorder[prindex]);
        //找根节点在中序遍历的数组中的结果
        int rootindex = findRootIndex(inorder,inbegin,inend,preorder[prindex]);
        prindex++;
        root.left = buildTreeChild(preorder,inorder,inbegin,rootindex-1);
        root.right = buildTreeChild(preorder,inorder,rootindex+1,inend);
        return root;
    }
    //数组中的查找代码
    public int findRootIndex(int[] inorder,int inbegin,int inend,int key){
        for(int i = inbegin; i <= inend;i++){
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null) return null;
        return buildTreeChild(preorder,inorder,0,inorder.length-1);

    }
}

