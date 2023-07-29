package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        /*
         * AList Ns hold the size of the data structure : N
         * AList times hold the time to complete all operations : timeInSeconds
         * AList opCounts hold the number of calls to addLast() : N
         * AList timeTest : to make calls to addLast()
         */

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int N = 1000; N <= 128000; N *= 2) {
            AList<Integer> timeTest = new AList<>();
            Stopwatch sw = new Stopwatch();

            for (int j = 0; j < N;  j += 1) {
                timeTest.addLast(j);
            }

            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(N);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
