package deque;

/** Treat array as circular to implement the deque. */
public class ArrayDeque<Item> {
    public Item[] item;
    public int first;
    public int last;
    public int size;

    /** Creates an empty deque. */
    /*
    Reason for set first = 1 and set last = 0.
        In the addFirst method first needs to minus 1, in order to
    make sure that first tracks the first item's index, we need
    to set first initially equals to 1.So when we execute the
    addFirst(), the deque looks like:
        beginning:
        l  f
        0  0  0  0
        addFirst(3):
        lf
        3  0  0  0
        The reason for setting last initially equals to 0 is the same
        , to make sure that last keeps track of the last item's index.
     */
    public ArrayDeque() {
        item = (Item[]) new Object[8];
        first = 1;
        last = 0;
        size = 0;
    }

    /** Changes the size of the deque. */
    private void resize(int newSize) {
        Item[] orderedDeque = (Item[]) new Object[item.length];
        for (int i = 0; i < size + 1; i += 1) {
            orderedDeque[i] = item[first];
            first = first + 1;
            if (first > item.length) {
                first = 0;
            }
        }
        Item[] newDeque = (Item[]) new Object[newSize];
        System.arraycopy(orderedDeque, 0, newDeque, 0, size + 1);
        item = newDeque;
        first = 0;
        last = size;
    }

    /** Helper method to add function. */
    private void prepAdd() {
        size += 1;
        if (size > item.length) {
            resize(2 * item.length);
        }
    }

    /** Inserts X in the front of the deque. */
    public void addFirst(Item x) {
        prepAdd();
        first = first - 1;
        if (first < 0) {
            first = item.length - 1;
        }
        item[first] = x;
    }

    /** Inserts X at the back of the deque. */
    public void addLast(Item x) {
        prepAdd();
        last = last + 1;
        if (last > (item.length - 1)) {
            last = 0;
        }
        item[last] = x;
    }

    /** Helper method to remove function. */
    private void prepRemove() {
        size -= 1;
        double spaceUtilization = (double)size / item.length;
        if (item.length >= 16 && spaceUtilization < 0.25) {
            resize(item.length / 2);
        }
    }

    /** Removes the first item in the deque. */
    public Item removeFirst() {
        prepRemove();
        Item x = item[first];
        item[first] = null;
        first = first + 1;
        if (first > (item.length - 1)) {
            first = 0;
        }
        return x;
    }

    /** Removes the last item in the deque. */
    public Item removeLast() {
        prepRemove();
        Item x = item[last];
        item[last] = null;
        last = last - 1;
        if (last < 0) {
            last = item.length - 1;
        }
        return x;
    }

    /** Returns ture if the deque is empty. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int p = first;
        for (int i = 0; i < size; i += 1) {
            System.out.print(item[p] + " ");
        }
        System.out.println();
    }

    /** Returns the ith item in the deque. */
    public Item get(int i) {
        int index;
        if (i > size - 1) {
            return null;
        } else {
            index = first + i;
            if (index >= item.length) {
                index = index - item.length;
            }
        }
        return item[index];
    }
}