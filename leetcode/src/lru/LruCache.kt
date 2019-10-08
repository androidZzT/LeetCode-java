package lru

class LruCache(val capacity: Int) {

    var map: HashMap<Int, DEntryNode> = HashMap()
    var list: DoubleLinkList = DoubleLinkList()

    fun put(key: Int, value: Int) {
        val n = DEntryNode(key, value)
        if (map.containsKey(key)) {
            val exist = map.get(key)
            list.remove(exist)
            list.addFirst(n)
            map.put(key, n)
        } else {
            if (list.size == capacity) {
                val last = list.removeLast()
                map.remove(last?.key)
            }
            list.addFirst(DEntryNode(key, value))
            map.put(key, n)
        }
    }

    fun get(key: Int): Int {
        if (!map.containsKey(key)) return -1
        val value = map.get(key)?.value
        put(key, value!!)
        return value
    }
}

fun main(args: Array<String>) {
    val cache = LruCache(5)
    cache.put(1,1)
    cache.put(2,2)
    cache.put(3,3)
    cache.put(4,4)
    cache.put(5,5)
    cache.put(6,6)
    println(cache.get(1))
    println(cache.get(2))
}



