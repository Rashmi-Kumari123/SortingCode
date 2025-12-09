// design a stack  in which addition to push and pop, has a function min which returns the minimum element. Push, Pop, min should all operate in O(1) time.

// package week1;
public class MinStack {
    private java.util.Stack<Integer> mainStk;
    private java.util.Stack<Integer> minStk;
    public MinStack(){
        mainStk = new java.util.Stack<>();
        minStk = new java.util.Stack<>();
    }
    public void push(int val){
        mainStk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()){
            minStk.push(val);
        }
    }
    public void pop(){
        if (!mainStk.isEmpty()){
            int val = mainStk.pop();
            if (val == minStk.peek()){
                minStk.pop();
            }
        }
    }
    public int top(){
        return mainStk.peek();
    }
    public int getMin(){
        return minStk.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);
        System.out.println("Top Element: " + ms.top());       //  2
        System.out.println("Current Min: " + ms.getMin());     //  2

        ms.pop();
        System.out.println("After pop -> New Min: " + ms.getMin());  // 3

        ms.pop();
        System.out.println("After pop -> New Min: " + ms.getMin());  //  3

        ms.push(1);
        System.out.println("Top Element: " + ms.top());       //  1
        System.out.println("Current Min: " + ms.getMin());    //  1
    }
        
}