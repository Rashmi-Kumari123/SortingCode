// package week1;

public class Stack {
    private final int[] arr;
    private int top;
    private final int capacity;
    Stack(int Size){
        arr = new int[Size];
        capacity = Size;
        top = -1;
    }
    public void push(int e){
        if (top == capacity -1){    // already full
            System.out.println("Stack is overflow");
            return;
        }
        top = top + 1;
        arr[top] = e;
    }
    public int pop(){
        if (top == -1){
            System.out.println("Stack is underflow");  
        }
        int val = arr[top];
        top = top - 1;
        return val;
    }
    public int peek(){
        if (top == -1){
            System.out.println("stack is empty");
        }
        return arr[top];
    }
    public static void main(String[] args){
        Stack st = new Stack(3);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);    // output will show : Stack is overflow
        System.out.println(st.pop());  // 3
        System.out.println(st.pop());  // 2
        System.out.println(st.peek());   // 1
        System.out.println(st.pop());   // 1
        System.out.println(st.pop()); // Stack is underflow
        System.out.println(st.peek());  // stack is empty
        System.out.println(st.pop());  // ArrayIndexOutOfBoundsException
        
        
    }

    
}
