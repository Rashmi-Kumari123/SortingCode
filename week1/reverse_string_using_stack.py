
def reverse_string(input_string):
    stack = [] 
    reversed_string = ""
   
    for char in input_string:
        stack.append(char)
    
    while stack:
        reversed_string += stack.pop()
    return reversed_string
input_string = "Hello, World!"
reversed_result = reverse_string(input_string)
print("Original:", input_string)
print("Reversed:", reversed_result)