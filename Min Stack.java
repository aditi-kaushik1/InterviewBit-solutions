/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1 */

class Solution {
    Stack<Integer> stack = new Stack<>();
    int minElement = Integer.MAX_VALUE;
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minElement = x;
            return;
        }
        if(x < minElement) {
            stack.push(2*x - minElement);
            minElement = x;
            return;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        if(stack.peek() < minElement) {
            minElement = 2*minElement - stack.pop();
            return;
        }
        stack.pop();
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        if(stack.peek() < minElement) {
            return minElement;
        }
        return stack.peek();
    }

    public int getMin() {
        if(stack.isEmpty())
            return -1;
        else
        return minElement;
    }
}
