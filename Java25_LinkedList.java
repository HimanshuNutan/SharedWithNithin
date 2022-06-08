import java.util.HashSet;

public class Java25_LinkedList {
    public static void main(String[] args) {
        CustomLinkedList.Node node = new CustomLinkedList.Node(10);
        CustomLinkedList list1 = new CustomLinkedList(node);
        list1.addAtEnd(20);
        list1.addAtEnd(30);
        list1.addAtEnd(40);
        list1.addAtFirst(5);
        list1.addAtFirst(node);
//        list1.findMiddle();
        list1.findIfLoop();
//        System.out.println(list1.findLength());
//        list1.printList();
    }
}

class CustomLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public CustomLinkedList(Node head) {
        this.head = head;
        head.next = null;
    }

    public void addAtEnd(int data) {
        Node node = new Node(data);
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public void addAtEnd(Node node) {
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public void addAtFirst(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    public void addAtFirst(Node node) {
        Node new_node = node;
        new_node.next = head;
        head = new_node;
    }
    public void printList() {
        Node head1 = head;
        while (head1 != null) {
            System.out.println(head1.data);
            head1 = head1.next;
        }
    }

    public void findMiddle() {
        Node node1, node2;
        node1 = head;
        node2 = head;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        System.out.println("Middle element -" + node1.data);
    }

    public int findLength() {
        Node node = head;
        int l = 0;
        while (node != null) {
            node = node.next;
            l++;
        }
        return l;
    }

    public void findIfLoop() {
        HashSet<Node> set = new HashSet<>();
        Node node = head;
        boolean flag = true;
        while (!set.contains(node)) {
            if (node.next == null) {
                flag = false;
                break;
            }
            set.add(node);
            node = node.next;
        }
        if (flag) {
            System.out.println("Loop present");
        } else {
            System.out.println("No loop present");
        }
    }
}
