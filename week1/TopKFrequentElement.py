def TopK(nums, k):
    mapping = {}
    for i in nums:
        if i  in mapping:
            mapping[i] += 1
        else:
            mapping[i] = 1
   
    max_freq = max(mapping.values())
    bucket = [[] for freq in range(max_freq + 1)]
    
    for key, V in mapping.items():
        bucket[V].append(key)
    print(bucket)
    result = []
    count = 0
    for i in range(len(bucket)-1, -1, -1):
        for j in bucket[i]:
            result.append(j)
            count +=1
            if count == k:
                return result
print(TopK([1,1,1,2,2, 3], 2))
print(TopK([1,1,2,2,2, 3,3,3,3], 2))
print(TopK([4,5,6,7], k = 2))
        

