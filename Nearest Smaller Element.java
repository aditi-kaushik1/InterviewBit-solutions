/* Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
More formally,
    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1. */

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            if(stack.isEmpty())
                ans.add(-1);
            else if(stack.peek() < A.get(i))
                ans.add(stack.peek());
            else if(stack.peek() >= A.get(i)) {
                while(!stack.isEmpty() && stack.peek() >= A.get(i))
                    stack.pop();
                if(stack.isEmpty())
                    ans.add(-1);
                else
                    ans.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return ans;
    }
}
