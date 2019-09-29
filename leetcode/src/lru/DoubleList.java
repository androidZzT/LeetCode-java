package lru;

class DoubleList {

    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node n) {
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        size++;
    }

    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    public Node removeLast() {
        if (head.next == tail) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}
