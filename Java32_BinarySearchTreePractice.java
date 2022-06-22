package amazon;

public class Java32_BinarySearchTreePractice {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root_bst = new Node_BST(10);
        tree.insert(4);
        tree.insert(41);
        tree.insert(24);
        tree.insert(12);
        tree.findClosestElement(33);
//        tree.InOrder(tree.root_bst);
    }
}
class BST{
    Node_BST root_bst;
    Node_BST closest;int diff=0,diff1=Integer.MAX_VALUE;
    boolean flag;
    public void InOrder(Node_BST node){
        if(node!=null){
            InOrder(node.left);
            System.out.println(node.data);
            InOrder(node.right);
        }
    }

    public void insert(int data){
       if(isEmpty()){
           root_bst = new Node_BST(data);
       }else{
           insert(data,root_bst);
       }
    }
    public void insert(int data,Node_BST node){
        if(node.data>data){
            if(node.left==null){
             Node_BST newNode = new Node_BST(data);
             node.left=newNode;
            }else{
                insert(data,node.left);
            }
        }else if(node.data<data){
            if(node.right==null){
                Node_BST newNode = new Node_BST(data);
                node.right=newNode;
            }else{
                insert(data,node.right);
            }
        }
    }
    public void findClosestElement(int n){
        findClosestElement(n,root_bst);
        if(!flag){
            System.out.println("Closest node is "+closest.data+" and difference is "+diff1);
        }
    }
    public void findClosestElement(int n, Node_BST node){
        if(node.data==n){
            System.out.println("Node found in tree "+node.data);flag = true;
        }else{
        diff = Math.abs(node.data-n);
        if(diff1>diff){
            diff1=diff;
            closest=node;
        }
        if(node.left!=null)
            findClosestElement(n,node.left);
        if(node.right!=null)
            findClosestElement(n,node.right);
    }}

    private boolean isEmpty() {
        return root_bst==null;
    }
}
class Node_BST{
    Node_BST left;
    int data;
    Node_BST right;

    public Node_BST(int data) {
        this.data = data;
    }
}