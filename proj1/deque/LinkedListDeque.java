package deque;

/** Circular sentinel topology implementing the Deque*/

/* Invariants:
    addFirst: The 0th item is sentinel.next. The 0th item.prev is sentinel.
    addLast: The Last item is sentinel.prev. The last item.next is sentinel.
 */
public class LinkedListDeque<Item> {
    public ItemNode sentinel;
    public int size;

    private class ItemNode {
        Item item;
        ItemNode prev;
        ItemNode next;

        public ItemNode(Item x) {
            item = x;
            prev = null;
            next = null;
        }
    }

    /** Creates an empty deque. */
    public LinkedListDeque() {
        sentinel = new ItemNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;
    }

    /** Inserts X to the front of the deque. */
    public void addFirst(Item x) {
        ItemNode newNode = new ItemNode(x);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size += 1;
    }

    /** Inserts X to the back of the deque. */
    public void addLast(Item x) {
        ItemNode newNode = new ItemNode(x);
        newNode.next = sentinel;
        newNode.prev = sentinel.prev;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size += 1;
    }

    /** Tells whether the deque is empty. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the size of the deque. */
    public int size() {
        return size;
    }

    /** Prints the item in the deque from first to last, separated by a space. */
    public void printDeque() {
        ItemNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** Removes the first item of the deque. */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Item x = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;

            size -= 1;
            return x;
        }
    }

    /** Removes the last item of the deque. */
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item x = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;

            size -= 1;
            return x;
        }
    }

    /** Returns the ith item of the deque in an iterative way. */
    public Item get(int i) {
        if (i > size - 1) {
            return null;
        } else {
            ItemNode p = sentinel.next;

            for (int x = 0; x < i; x += 1) {
                p = p.next;
            }

            return p.item;
        }
    }

    /** Helper method to recursively return the ith item of the deque. */
    private Item recursiveGet(ItemNode curr, int start, int i) {
        if (start == i) {
            return curr.item;
        } else {
            return recursiveGet(curr.next, start + 1, i);
        }
    }

    /** Returns the ith item of the deque in a recursive way. */
    public Item getRecursive(int i) {
        return recursiveGet(sentinel.next, 0, i);
    }
}