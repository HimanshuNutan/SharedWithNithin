import java.util.Stack;

public class Java27_BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(6);
//        tree.addToLeftMost(9);
//        tree.addToLeftMost(8);
//        tree.addToLeftMost(7);
        tree.addToLeftMost(3);
//        tree.addToRightMost(11);
//        tree.addToRightMost(12);
        tree.addToRightMost(13);
//        tree.addToRightMost(14);
        BinaryTree.Node node1 = new BinaryTree.Node(9);
        BinaryTree.Node node2 = new BinaryTree.Node(10);
        BinaryTree.Node node3 = new BinaryTree.Node(11);
        BinaryTree.Node node4 = new BinaryTree.Node(12);
        BinaryTree.Node node5 = new BinaryTree.Node(7);

        tree.addToLeftOf(11,13);
        tree.printInOrderTraversal(tree.root);
    }}

    class BinaryTree{

    Node root;
        public BinaryTree(int data) {
            root = new Node(data);
        }

        static class Node{
            Node left;
            int data;
            Node right;

            public Node(int data) {
                this.data = data;
                left=right=null;
            }
        }
        public void addToLeftMost(int data){
            Node node = new Node(data);
            Node rootnode = root;
            while(rootnode.left!=null){
                rootnode=rootnode.left;
            }
            rootnode.left=node;
        }
        public void addToLeftOf(int data,int already){
            Node node1 = findNode(already,root);
            if(node1==null){
                System.out.println("Node doesn't exist");
            }
            else{
                Node tempLeft = node1.left;
                node1.left = new Node(data);
                node1.left.left = tempLeft;
            }
        }
        public void addToRightMost(int data){
            Node node = new Node(data);
            Node rootnode = root;
            while(rootnode.right!=null){
                rootnode=rootnode.right;
            }
            rootnode.right=node;
        }
        public void printInOrderTraversal(Node root){
            if(root.left!=null)
            printInOrderTraversal(root.left);
            System.out.println(root.data);
            if(root.right!=null)
            printInOrderTraversal(root.right);

        }
        public void printPreOrderTraversal(Node root){
            System.out.println(root.data);
            if(root.left!=null)
                printPreOrderTraversal(root.left);
            if(root.right!=null)
                printPreOrderTraversal(root.right);
        }
        public void printPostOrderTraversal(Node root){
            if(root.left!=null)
                printPostOrderTraversal(root.left);
            if(root.right!=null)
                printPostOrderTraversal(root.right);
            System.out.println(root.data);
        }
        public Node findNode(int data,Node root){
            Node rootnode = root,found=null;
            if(rootnode.data==data){
                found = rootnode;
            }
            if(found==null&&rootnode.left!=null)
           found = findNode(data,rootnode.left);
            if(found==null&&rootnode.right!=null)
            found =findNode(data,rootnode.right);
            return found;
        }
    }

