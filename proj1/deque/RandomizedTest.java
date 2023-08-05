package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomizedTest {

    @Test
    public void LinkedListDequeRandomizedTest() {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 9);
            if (operationNumber == 0) {
                int randomVal = StdRandom.uniform(0, 100);
                list.addFirst(randomVal);
            } else if (operationNumber == 1) {
                int randomVal = StdRandom.uniform(0, 100);
                list.addLast(randomVal);
            } else if (operationNumber == 2) {
                if (list.isEmpty()) {
                    System.out.println("Is Empty.");
                } else {
                    System.out.println("Is Not Empty.");
                }
            } else if (operationNumber == 3) {
                System.out.println("Size is: " + list.size());
            } else if (operationNumber == 4) {
                list.printDeque();
            } else if (operationNumber == 5) {
                System.out.println(list.removeFirst());
            } else if (operationNumber == 6) {
                System.out.println(list.removeLast());
            } else if (operationNumber == 7) {
                int randomVal = StdRandom.uniform(0, 100);
                System.out.println(list.get(randomVal));
            } else if (operationNumber == 8) {
                int randomVal = StdRandom.uniform(0, 100);
                System.out.println(list.getRecursive(randomVal));
            }
        }
    }

    @Test
    public void ArrayDequeRandomizedTest() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 8);
            if (operationNumber == 0) {
                int randomVal = StdRandom.uniform(0, 100);
                list.addFirst(randomVal);
            } else if (operationNumber == 1) {
                int randomVal = StdRandom.uniform(0, 100);
                list.addLast(randomVal);
            } else if (operationNumber == 2) {
                if (list.isEmpty()) {
                    System.out.println("Is Empty.");
                } else {
                    System.out.println("Is Not Empty.");
                }
            } else if (operationNumber == 3) {
                System.out.println("Size is: " + list.size());
            } else if (operationNumber == 4) {
                list.printDeque();
            } else if (operationNumber == 5) {
                System.out.println(list.removeFirst());
            } else if (operationNumber == 6) {
                System.out.println(list.removeLast());
            } else if (operationNumber == 7) {
                int randomVal = StdRandom.uniform(0, 100);
                System.out.println(list.get(randomVal));
            }
        }
    }
}
