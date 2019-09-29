package lru;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cache = new DoubleList();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) { //已经存在
            cache.remove(map.get(key)); //移除原来节点
            cache.addFirst(n); //将节点重新插到头部
            map.put(key, n);//更新 map
        } else {
            if (cache.size() == cap) { //容量已满
                Node last = cache.removeLast(); //删除最后节点
                map.remove(last.key); //同时删除 map 中的 value
            }
            cache.addFirst(n); //插入头节点
            map.put(key, n); //更新map
        }
    }
}
