package binarysearchtree;
class BinarySearchTree{
    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public Node root;
    /*
    查找
     */
    public Node search(int key){
        Node cur = root;
        while(cur != null){
            if(cur.val == key){
                return cur;
            }else if(cur.val < key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return null;
    }
    /*
    插入 : 每次插入都会插入到叶子节点的地方
     */
    public boolean insert(int key){
        Node node = new Node(key);
        if(root == null){
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;

        while(cur != null){
            if(cur.val == key){
                return false;
            }else if(cur.val < key){
                parent = cur;
                cur = cur.right;
            }else{
                parent = cur;
                cur = cur.left;
            }
        }
        //找到parent的地方
        if(parent.val < key){
            parent.right = node;
        }else{
            parent.left = node;
        }
        return true;
    }
    /*
    删除
    当左右树都不是空时:
    替罪羊法:
    1.在右树找到最左边的节点(这样能保证在右树中它是最小的节点)或者在左树找到最右边的节点
    找到最小的节点,放到现在删除的位置 一定可以保证当前节点的右边还是比我小左边还是比我大
    2.替换 之后真正删除的节点是替换的那个节点
     */
    public void remove(Node parent,Node cur){
        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            Node targetParent = cur;
            Node target = cur.right;
            while(target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left){
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }

        }
    }
    public void removeKey( int key){
        if(root == null){
            return;
        }
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(cur.val == key){
                remove(parent,cur);
            }else if(cur.val < key){
                parent = cur;
                cur = cur.right;
            }else{
                parent = cur;
                cur = cur.left;
            }
        }
    }

}
public class TestDemo {
    public static void inorder(BinarySearchTree.Node root){
        if(root == null){
            return;
        }
        inorder((root.left));
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void preorder(BinarySearchTree.Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorder((root.left));
        preorder(root.right);
    }
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(13);
        binarySearchTree.insert(1);
        binarySearchTree.insert(21);
        binarySearchTree.insert(14);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        inorder(binarySearchTree.root);
        System.out.println();
        preorder(binarySearchTree.root);
        System.out.println();
        System.out.println(binarySearchTree.search(1).val);

        binarySearchTree.removeKey(13);

        inorder(binarySearchTree.root);
        System.out.println();
        preorder(binarySearchTree.root);
        System.out.println();
    }

}
