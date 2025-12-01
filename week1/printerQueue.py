# Solving a problem that simulates a printer queue, where documents are added 
# to the queue using the `enqueue` operation and printed in the order they 
# were added using the `dequeue` operation.
class Queue:
    def __init__(self):
        self.items = []
    def enqueue(self, item):
        self.items.append(item)
    def dequeue(self):
        if not self.is_empty():
            return self.items.pop(0)
        return None
    def is_empty(self):
        return len(self.items) == 0
    def size(self):
        return len(self.items)
printer_queue = Queue()
printer_queue.enqueue("Document1")
printer_queue.enqueue("Document2")
printer_queue.enqueue("Document3")
while not printer_queue.is_empty():
    print("Printing:", printer_queue.dequeue())
