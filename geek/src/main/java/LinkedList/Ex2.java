package LinkedList;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年10月28日 14:10
 */
public class Ex2 {

    private Node head;

    private int size;

    private class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Ex2() {
        this.size = 0;
        this.head = new Node(0);
    }

    public void add(int data) {
        Node node = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node node = new Node(data);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
    }

    public boolean contains(int data) {
        Node temp = head.next;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.data;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node temp = head.next;
        while (temp != null) {
            res.append(temp.data).append("->");
            temp = temp.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        // 翻转单链表
        Ex2 ex2 = new Ex2();
        ex2.add(2);
        ex2.add(21);
        ex2.add(23);
        ex2.add(29);
        ex2.add(24);
        ex2.reverse();
        System.out.println(ex2.toString());
    }

    // 翻转单链表
    public void reverse() {
        Node prev = null;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;
    }

}
