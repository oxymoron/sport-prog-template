/*
 * Developer: Andrey Zubkov
 * Date: 2013-09-22
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Algorithm {

    class Test {
        public int n;
        public int[][] values;
    }

    private List<Test> tests = new ArrayList<Test>();

    class Solution {
        public int[] result;
    }

    private List<Solution> solutions = new ArrayList<Solution>();

    public void solution(String inFile, String outFile) {
        readInput(inFile);
        solve();
        writeOutput(outFile);
    }

    private void readInput(String inFile) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(inFile));
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (scanner != null) scanner.close();
        }
    }

    private void solve() {
        for (Test test : tests) {
            solveOne(test);
        }
    }

    private void solveOne(Test test) {
        Solution s = new Solution();
        s.result = new int[test.n];
        for (int i = 0; i < test.n; i++){
            s.result[i] = test.values[i][0] +  test.values[i][1];
        }
        solutions.add(s);
    }

    private void writeOutput(String outFile) {
        PrintStream out = null;
        try {
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
            int cnt = 1;
            for (Solution solution : solutions) {
                out.println((String.format("Case #%d", cnt++)));
                for(int i = 0; i < solution.result.length; i++){
                    out.println(solution.result[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }

}
