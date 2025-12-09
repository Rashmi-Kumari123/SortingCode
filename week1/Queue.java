class QueueNode{
    int val;
    QueueNode next;
    QueueNode(int data){
        this.val = data;
        this.next = null;
    }
}

public class Queue{
    private QueueNode front, rear;
    private int size;
    public Queue(){
        this.front = this.rear = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return front.val;
    }
    // Enqueue (inserting at a tail of SLL)
    public void enqueue(int val){
        QueueNode newNode = new QueueNode(val);
        if (rear == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size = size + 1;
        System.out.println(val + " inserted into Queue");
    }
    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue isEmpty");
        }
        int val = front.val;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size = size - 1;
        System.out.println(val + " removed from Queue");
        return val;
    }
    public int size(){
        return size;
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        System.out.println("The Size of the Queue is " + q.size());
        System.out.println("The peek element of the Queue is " + q.peek());
    }
}