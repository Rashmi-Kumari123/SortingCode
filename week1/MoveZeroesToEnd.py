# Q is move all Zeroes to the end of the array
# i , j => considering two pointers..i will iterate over the array and j will just track position where next non-zero will be placed
def moveZeroesToEnd(arr):
    j = -1
    n = len(arr)
    for i in range(n):  
        if arr[i] == 0:
            j = i  # tracking at which index first time Zero element is found
            break

    for i in range(j+1, n): # once track the zeroth index, then next from that index if got non-zero further just swap and then 
        # increase j pointer
        if arr[i] != 0:
            arr[i], arr[j] = arr[j], arr[i]
            j = j + 1
    return arr

print(moveZeroesToEnd([1,0, 2,3,2,0,0, 4,5,1]))
print(moveZeroesToEnd([0,1,0,3,12]))