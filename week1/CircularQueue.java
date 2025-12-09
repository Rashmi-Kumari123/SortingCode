//function that is checking if a circular queue is full or not
// package week1;

public class CircularQueue {
    int[] queue;
    int front, rear, size, capacity;
    CircularQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }
    boolean isFull(){
        return size == capacity;
    }
    
}
