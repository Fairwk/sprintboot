
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
    /*
    根据后序遍历和中序遍历得到二叉树
    public int postindex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend ){
        if(inbegin > inend){
            return null;//左树或者右树为空
        }
        TreeNode root = new TreeNode(preorder[postindex]);
        //找根节点在中序遍历的数组中的结果
        int rootindex = findRootIndex(inorder,inbegin,inend,preorder[postindex]);
        postindex--;
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
        postindex = postorder.length-1;
        return buildTreeChild(postindex,inorder,0,inorder.length-1);

    }
     */
    //将二叉树转变为数组和括号输出(字符串)
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t == null){
            return;
        }
        sb.append(t.val);
        if(t.left == null){
            if(t.right == null){
                return;
            }else{
                sb.append("()");
            }
        }else{
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }
        if(t.right == null){
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode root){
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        tree2strChild(root,sb);
        return sb.toString();
    }
}

