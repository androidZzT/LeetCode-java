package lru;

public class Node {

    public int key;
    public int val;
    public Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
