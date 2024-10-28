package LinkedList;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年10月28日 14:19
 */
public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 10;

    private Node<T> headNode;

    private Integer length;

    private Integer capacity;

    private static class Node<T> {
        public T element;
        public Node<T> next;

        public Node() {
        }

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    public LRUBaseLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T element) {
        Node<T> preNode = findPreNode(element);
        if (preNode != null) {
            deleteElementOptim(preNode);
            insertElementAtBegin(element);
        } else {
            if (length >= capacity) {
                deleteElementAtEnd();
            }
            insertElementAtBegin(element);
        }
    }

    private void deleteElementAtEnd() {
        Node<T> temp = headNode;
        if (temp.next == null) {
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        length--;
    }

    private void insertElementAtBegin(T element) {
        Node<T> next = headNode.next;
        headNode.next = new Node<>(element, next);
        length++;
    }

    private void deleteElementOptim(Node<T> preNode) {
        Node<T> temp = preNode.next;
        preNode.next = temp.next;
        temp = null;
        length--;
    }

    private Node<T> findPreNode(T element) {
        Node<T> temp = headNode;
        while (temp.next != null) {
            if (element.equals(temp.next.element)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void printAll() {
        Node<T> temp = headNode.next;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> lruBaseLinkedList = new LRUBaseLinkedList<>();
        lruBaseLinkedList.add(7); // 1
        lruBaseLinkedList.add(2); // 2 1
        lruBaseLinkedList.add(3); // 3 2 1
        lruBaseLinkedList.add(4); // 4 3 2 1
        lruBaseLinkedList.add(5);
        lruBaseLinkedList.add(6);
        lruBaseLinkedList.add(1);
        lruBaseLinkedList.add(8);
        lruBaseLinkedList.add(3);
        lruBaseLinkedList.add(10);
        lruBaseLinkedList.add(7);
        lruBaseLinkedList.add(11);
        lruBaseLinkedList.add(12);
        lruBaseLinkedList.add(11);
        lruBaseLinkedList.printAll();
    }

}
