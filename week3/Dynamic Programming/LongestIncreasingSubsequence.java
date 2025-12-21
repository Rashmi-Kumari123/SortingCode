// package week3.Dynamic Programming;

public class LongestIncreasingSubsequence {
    public int longestSubsequenceWithActualSolution(int[] arr){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1; // similar T[i] = max(T[i], T[j] + 1)
                        actualSolution[i] = j; //setting the actualSolution to point to guy before me
                    }
                }
            }
        }
        int maxIndex = 0; //finding the index of max number in T 
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
        int t = maxIndex;        
        int newT = maxIndex;      
        do{
            t = newT;                    
            System.out.print(arr[t] + " ");  
            newT = actualSolution[t];
        }
        while(t != newT);  // Stopping as we reach an element that points to itself (first element)
        System.out.println();
        return T[maxIndex];
    }
    public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {3,4,-1,0,6,2,3};
        int arr1[] = {2,5,1,8,3};

        int result = lis.longestSubsequenceWithActualSolution(arr);
        int result1 = lis.longestSubsequenceWithActualSolution(arr1);
        System.out.println(result);
        System.out.println(result1);
// Time complexity: O(n²), Space: O(n)
    }
    
}
