/* You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x. */

public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        /*Solution 1
        Time limit exceeded as nested loop used (Brute force) */
    //     if(A.size() == 0)
    //         throw new IllegalArgumentException();
    //     if(A.size() == 1)
    //         return 0;
    //     int max = Integer.MIN_VALUE;
    //     for(int i = 1; i <= A.size(); i++) {
    //         for(int j = i + 1; j < A.size(); j ++ ) {
    //             max = Math.max(Math.abs(A.get(i) - A.get(j)) + (j - i) , max);
    //         }
    // }
    // return max;
    
    /*Solution 2*/
    /* Solution video : https://www.youtube.com/watch?v=Ov4weYCIipg */
    if(A.size() == 0 || A.size() == 1)
        throw new IllegalArgumentException();
    int max1 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int max2 = Integer.MIN_VALUE;
    int min2 = Integer.MAX_VALUE;
    for(int i = 0; i < A.size(); i ++ ) {
        max1 = Math.max(max1,A.get(i) + i);
        min1 = Math.min(min1,A.get(i) + i);
        max2 = Math.max(max2,A.get(i) - i);
        min2 = Math.min(min2,A.get(i) - i);
    }
    int x1 = max1 - min1;
    int x2 = max2 - min2;
    return Math.max(x1,x2);
    }
}
