# Implementing ticket queue using queue data structure where individuals
# need to wait for a service or assistance, such as at ticket counters, customer service centers and it follow First come First Serve(FIFO) principle
class TicketQueue:
    def __init__(self):
        self.queue = []
    def take_ticket(self, ticket_number):
        self.queue.append(ticket_number)
        print(f"Ticket {ticket_number} taken. You are number {len(self.queue)} in the queue.")
        
    def serve_next(self):
        if not self.is_empty():
            served_ticket = self.queue.pop(0)
            print(f"Serving ticket {served_ticket}.")
            return served_ticket
        else:
            print("No tickets left in the queue.")
            return None
    def is_empty(self):
        len(self.queue) == 0
    def queue_length(self):
          return len(self.queue)
# Creating a ticket queue
ticket_queue = TicketQueue()
# Taking tickets and serving customers
ticket_queue.take_ticket(101)  #Ticket 101 taken. You are number 1 in the queue.
ticket_queue.take_ticket(102)  #Ticket 102 taken. You are number 2 in the queue.
ticket_queue.take_ticket(103)  #Ticket 103 taken. You are number 3 in the queue.
print("Queue length:", ticket_queue.queue_length())   #Queue length: 3
ticket_queue.serve_next()        #Serving ticket 101.
ticket_queue.serve_next()        #Serving ticket 102.
ticket_queue.serve_next()        #Serving ticket 103.
print("Queue length:", ticket_queue.queue_length())   #Queue length: 0