package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        /*
        * AList Ns hold the number of items at SLList : N
        * AList times hold the time to complete all operations : timeInSeconds
        * AList opCounts hold the number of calls to getLast() : M = 10000
        */

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int N = 1000; N <= 128000; N *= 2) {
            int M = 10000;
            SLList<Integer> timeTest = new SLList<>();

            for (int i = 0; i < N; i += 1) {
                timeTest.addFirst(i);
            }

            Stopwatch sw = new Stopwatch();

            for (int j = 0; j < M; j += 1) {
                int temp = timeTest.getLast();
            }

            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(M);
        }

        printTimingTable(Ns, times, opCounts);
    }
}
