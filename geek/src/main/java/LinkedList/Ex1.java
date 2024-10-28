package LinkedList;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年10月28日 14:10
 */
public class Ex1 {

    private Node head;

    private int size;

    private class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Ex1() {
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
        // 判断回文字符串
        Ex1 ex1 = new Ex1();
        ex1.add(1);
        ex1.add(1);
        ex1.add(3);
        ex1.add(2);
        ex1.add(1);
        System.out.println(ex1.isPalindrome());
    }

    // 用单链表判断回文字符串
    public boolean isPalindrome() {
        if (head.next == null) {
            return false;
        }
        Node slow = head.next;
        Node fast = head.next;
        Node prev = null;

        // 快慢指针找到中间节点
        while (fast != null && fast.next != null) {
            // 快指针每次走两步
            fast = fast.next.next;
            Node next = slow.next;
            // 慢指针每次走一步，同时反转前半部分链表
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.data != prev.data) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

}
