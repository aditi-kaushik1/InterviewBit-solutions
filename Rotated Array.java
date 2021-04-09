/* Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
PROBLEM APPROACH:
Note: If you know the number of times the array is rotated, then this problem becomes trivial. If the number of rotation is x, then minimum element is A[x]. */

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> A) {
        int n = A.size();
        
        if(n == 0)
            return -1;
        if(n == 1 || A.get(0) < A.get(n - 1))
            return A.get(0);
        int mid;
        int left = 0;
        int right = n - 1;
        int prev;
        int next;
        
        while(left <= right) {
            mid = left + (right - left)/2;
            prev = (mid + n - 1) % n;
            next = (mid + 1) % n;
            if(A.get(mid) <= A.get(prev) && A.get(mid) <= A.get(next))
                return A.get(mid);
            else if(A.get(mid) >= A.get(0))
                left = mid + 1;
            else if(A.get(mid) < A.get(0))
                right = mid - 1;
        }
        return -1;
    }
}
