/* Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area. */

public class Solution {
    /* Write an MAH function which performs the necessary task for array nums.
    Write a for loop for the first row, to make it nums. Then find max.
    Then write a nested for loop with an if else condition,
    checking if arr[i][j] = 0 or not.
    */
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[] nums = new int[n];
        for(int j = 0; j < n; j++) {
            nums[j] = A.get(0).get(j);
        }
        int mx = MAH(nums,n);
        for(int i = 1; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(A.get(i).get(j) == 0)
                nums[j] = 0;
            else
                nums[j] = A.get(i).get(j) + nums[j];
        }
        mx = Math.max(mx,MAH(nums,n));
        }
        return mx;
    }
    
    public int MAH(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ansLeft = new int[n];
        int[] ansRight = new int[n];
        int[] area = new int[n];
        int maxArea = 0;
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                ansLeft[i] = i;
            else
                ansLeft[i] = i - stack.peek() - 1;
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                ansRight[i] = n - i - 1;
            else
                ansRight[i] = stack.peek() - i - 1;
            stack.push(i);
        }
        for(int i = 0; i < n; i++) {
            area[i] = nums[i] * (ansLeft[i] + ansRight[i] + 1);
            maxArea = Math.max(area[i],maxArea);
        }
        return maxArea;
    }
}
