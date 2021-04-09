/* Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2. */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        int resLeft = -1;
        int resRight = -1;
        int middle = 0;
        
        while(left <= right) {
            middle = left + ((right - left)/2);
            if(A.get(middle) == B) {
                resLeft = middle;
                right = middle - 1;
            }
            else if(B < A.get(middle)) 
                right = middle - 1;
            else
                left = middle + 1;
        }
        
        left = 0;
        right = A.size() - 1;
        
        while(left <= right) {
            middle = left + ((right - middle)/2);
            if(B == A.get(middle)) {
                resRight = middle;
                left = middle + 1;
            }
            else if(B > A.get(middle))
                left = middle + 1;
            else
                right = middle - 1;
    }
    if(resLeft == -1)
        return 0;
    else
        return resRight - resLeft + 1;
}
}
