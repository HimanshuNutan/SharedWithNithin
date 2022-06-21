public class Java29_DoublyLinkedListImp {
    public static void main(String[] args) {
        DoubleLL list = new DoubleLL(10);
        list.addAtLast(20);
        list.addAtFirst(15);
        list.addBefore(list.head.next.next,18);
        list.printListReverse();
    }
}

class DoubleLL {
    Node head;

    static class Node {
        Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            prev = next = null;
        }

    }

    public DoubleLL(int data) {
        Node head = new Node(data);
        this.head = head;
    }

    public void addAtLast(int data) {
        Node node = new Node(data);
        Node head1 = head;
        while (head1.next != null) {
            head1 = head1.next;
        }
        node.prev = head1;
        head1.next = node;

    }

    public void addAtFirst(int data) {
        Node node = new Node(data);
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    public void addBefore(Node node,int data){
        Node node1 = head;boolean found = true;
        Node new_node = new Node(data);
        while(node1!=node){
            node1 = node1.next;
            if(node1==null){
                System.out.println("Node not found");
                found = false;
                break;
            }
        }
        if(found){
            new_node.prev = node1.prev;
            node1.prev.next = new_node;
            new_node.next = node1;
            node1.prev = new_node;
        }
    }
    public void printList(){
        Node head1 = head;
        while(head1!=null){
            System.out.println(head1.data);
            head1=head1.next;
        }
    }
    public void printListReverse(){
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        while(node!=head){
            System.out.println(node.data);
            node = node.prev;
        }
        System.out.println(head.data);
    }
}
