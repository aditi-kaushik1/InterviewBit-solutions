/* Given an array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index, otherwise return -1.
You may assume no duplicate exists in the array.
NOTE:- Array A was sorted in non-decreasing order before rotation.
NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return index of B in array A, otherwise return -1
Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are disitinct. */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int n = A.size();
        int left = 0;
        int right = n - 1;
        int prev;
        int next;
        int mid;
        
        if(n == 0)
            return -1;
        
        if(n == 1 && A.get(0) == B)
            return 0;
        else if(n == 1 && A.get(0) != B)
            return -1;
        
        if(A.get(0) < A.get(n - 1))
            return binarySearch(A,0,n - 1, B);
            
        while(left <= right) {
            mid = left + (right - left)/2;
            prev = (mid + n - 1) % n;
            next = (mid + 1) % n;
            if(A.get(mid) <= A.get(prev) && A.get(mid) <= A.get(next))
            return Math.max(binarySearch(A,0, mid - 1, B), binarySearch(A,mid,n - 1, B));
            else if(A.get(mid) >= A.get(0))
                left = mid + 1;
            else if(A.get(mid) < A.get(0))
                right = mid - 1;
    }
    return -1;
    }
    
    public int binarySearch(List<Integer> A, int l, int r, int target) {
        int middle;
        while(l <= r) {
            middle = l + (r - l)/2;
            if(A.get(middle) == target)
                return middle;
            else if(A.get(middle) < target)
                l = middle + 1;
            else
                r = middle - 1;
        }
        return -1;
    }
}
