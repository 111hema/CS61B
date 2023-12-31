package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

  @Test
  public void testThreeAddThreeRemove() {
    AListNoResizing<Integer> correct = new AListNoResizing<>();
    BuggyAList<Integer> buggy = new BuggyAList<>();

    correct.addLast(5);
    correct.addLast(10);
    correct.addLast(15);

    buggy.addLast(5);
    buggy.addLast(10);
    buggy.addLast(15);

    assertEquals(correct.size(), buggy.size());

    assertEquals(correct.removeLast(), buggy.removeLast());
    assertEquals(correct.removeLast(), buggy.removeLast());
    assertEquals(correct.removeLast(), buggy.removeLast());
  }

  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> B = new BuggyAList<>();

    int N = 5000;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 4);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        B.addLast(randVal);
      } else if (operationNumber == 1) {
        // size
        int LSize = L.size();
        int BSize = B.size();
        assertEquals(LSize, BSize);
      } else if (operationNumber == 2) {
        // getLast
        int LSize = L.size();
        int BSize = B.size();
        if (LSize != 0 && BSize != 0) {
          assertEquals(L.getLast(), B.getLast());
        }
      } else if (operationNumber == 3) {
        // removeLast
        int LSize = L.size();
        int BSize = B.size();
        if (LSize != 0 && BSize != 0) {
          int LRemoveLast = L.removeLast();
          int BRemoveLast = B.removeLast();
          assertEquals(LRemoveLast, BRemoveLast);
        }
      }
    }
  }
}
