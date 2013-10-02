import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Developer: Andrey Zubkov
 * Date: 2013-09-22
 */

public class Main {
    
    static class Test {
        public int n;
        public int[][] values;
    }

    private static List<Test> tests = new ArrayList<Test>();
    
    static class Solution {
        public int[] result;
    }

    private static List<Solution> solutions = new ArrayList<Solution>();

    public static void main(String[] args) {
        readInput();
        solve();
        writeOutput();
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            Test test = new Test();
            test.n = scanner.nextInt();
            test.values = new int[test.n][2];
            for(int j = 0; j < test.n; j++){
                test.values[j][0] = scanner.nextInt();
                test.values[j][1] = scanner.nextInt();
            }
            tests.add(test);
        }
    }

    private static void solve() {
        for (Test test : tests) {
            solveOne(test);
        }
    }

    private static void solveOne(Test test) {
        Solution s = new Solution();
        s.result = new int[test.n];
        for (int i = 0; i < test.n; i++){
            s.result[i] = test.values[i][0] +  test.values[i][1];
        }
        solutions.add(s);
    }

    private static void writeOutput() {
        int cnt = 1;
        for (Solution solution : solutions) {
            System.out.println(String.format("Case #%d", cnt++));
            for(int i = 0; i < solution.result.length; i++){
                System.out.println(solution.result[i]);
            }
        }
    }
}
