package lru

class DoubleLinkList {

    val head: DEntryNode = DEntryNode(0, 0)
    val tail: DEntryNode = DEntryNode(0, 0)

    var size: Int = 0

    constructor() {
        head.next = tail
        tail.pre = head
    }

    fun addFirst(n: DEntryNode) {
        n.pre = head
        n.next = head.next
        head.next!!.pre = n
        head.next = n
        size++
    }

    fun remove(n: DEntryNode?) {
        n?.pre?.next = n?.next
        n?.next?.pre = n?.pre
        size--
    }

    fun removeLast(): DEntryNode? {
        if (head.next == tail) return null
        val last = tail.pre
        remove(last)
        return last
    }
}

class DEntryNode(var key: Int, var value: Int) {
    var pre: DEntryNode? = null
    var next: DEntryNode? = null
}