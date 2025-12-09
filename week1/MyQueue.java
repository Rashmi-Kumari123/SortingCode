
class MyQueue {
    private java.util.Stack<Integer> input;
    private java.util.Stack<Integer> output;
    
    public MyQueue() {
        input = new java.util.Stack<>();
        output = new java.util.Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        // if output is empty, transfer elements from input
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        // if output is empty, transfer elements from input
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        System.out.println("=== Testing MyQueue Implementation ===");
        System.out.println();
        
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Is queue empty? " + queue.empty());
        System.out.println();

        System.out.println("Front element (peek): " + queue.peek());
        System.out.println();
        // In FIFO order, elemnts should pop out
        System.out.println("Popped: " + queue.pop());  // Should be 1
        System.out.println("Popped: " + queue.pop());  // Should be 2
        System.out.println("Popped: " + queue.pop());  // Should be 3
        System.out.println("Is queue empty? " + queue.empty());
        System.out.println();
}
}

