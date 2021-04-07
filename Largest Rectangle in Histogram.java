public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        int[] ansLeft = new int[n];
        int[] ansRight = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i))
                stack.pop();
            if(stack.isEmpty())
                ansLeft[i] = i;
            else
                ansLeft[i] = i - stack.peek() - 1;
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i))
                stack.pop();
            if(stack.isEmpty())
                ansRight[i] = n - i - 1;
            else
                ansRight[i] = stack.peek() - i - 1;
            stack.push(i);
        }
        int[] area = new int[n];
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            area[i] = A.get(i) * (ansLeft[i] + ansRight[i] + 1);
            maxArea = Math.max(area[i], maxArea);
        }
        return maxArea;
    }
}
