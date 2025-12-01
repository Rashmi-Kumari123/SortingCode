package week1;
import java.util.Arrays;
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        int[] warmerDay = new int[n];
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int curr= 0; curr< n; curr++){
            while (!st.isEmpty() && temperatures[curr] > temperatures[st.peek()]){
                int idx = st.pop();
                warmerDay[idx] = curr - idx;
            }
            st.push(curr);
        }
        return warmerDay;
    }
    
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = dt.dailyTemperatures(temperatures1);
        System.out.println("Input: " + Arrays.toString(temperatures1));
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println();
        
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dt.dailyTemperatures(temperatures2);
        System.out.println("Input: " + Arrays.toString(temperatures2));
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println();
        
        int[] temperatures3 = {-5, -3, 0, 5, 10};
        int[] result3 = dt.dailyTemperatures(temperatures3);
        System.out.println("Input: " + Arrays.toString(temperatures3));
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
