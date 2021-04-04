/* You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B. */

public class Solution {
    public ArrayList<Integer> repeatedNumber(final List<Integer> Ar) {
        //Solution 1
        //Using HashMap
        //O(n) space and time complexity
        // HashMap<Integer,Integer> map = new HashMap<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(Integer x : A) {
        //     map.put(x,map.getOrDefault(x,0)+1);
        // }
        // for(Integer i = 1; i <= A.size(); i++) {
        //     if(map.containsKey(i) && map.get(i) == 2)
        //         ans.add(i);
        // }
        // for(Integer i = 1; i <= A.size(); i++) {
        //     if(!map.containsKey(i))
        //         ans.add(i);
        // }
        // return ans;
        
        //Solution 2
        //Using maths
        //Always use .equal() to compare 2 Integer objects.
        //This solution fails for larger test cases.
        //Do not calculate the sum of squares of elements.
        //Since it is given in the question that the entries are large,
        //we might face time limit exceeded.
        //Sort the array and calculate the duplicate value.
        //Find the difference between sum of all numbers upto n and
        // the sum of elements of array.
        //This gives the difference between missing and duplicate element.
        // ArrayList<Integer> A = new ArrayList<>();
        // for(Integer x : Ar)
        //     A.add(x);
        // int n = Ar.size();
        // Collections.sort(A);
        // int duplicate = 0;
        // for(int i = 0; i < n - 1; i++) {
        //     if(A.get(i).equals(A.get(i+1))) {
        //         duplicate = A.get(i);
        //     }
        // }
        // int sumOfNNumbers = n*(n+1)/2;
        // int sum = 0;
        // for(Integer x : A)
        //     sum += x;
        // //sumOfNNumbers - sum = missing - duplicate
        // int missing = sumOfNNumbers - sum + duplicate;
        // //RHS = missing - duplicate + duplicate
        // ArrayList<Integer> ans = new ArrayList<>();
        // ans.add(duplicate);
        // ans.add(missing);
        // return ans;
        
        //Solution 3
        //Although the list given here is fixed,
        //and cannot be changed because of the keyword "final".
        //But here, I am trying to practice swap sort, 
        //by copying the contents to a new array.
        int[] arr = new int[A.size()];
        for(int i = 0; i < A.size(); i++) {
            arr[i]  = A.get(i);
        }
        int duplicate = 0;
        int j = 0;
        while(j < A.size()) {
            if(arr[j] != arr[arr[j] - 1]) {
                int temp = arr[j];
                arr[j] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
            else
                j++;
        }
        int missing = 0;
        for(int i = 0; i < A.size(); i++) {
            if(arr[i] != i+1) {
                duplicate = arr[i];
                missing = i+1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(duplicate);
        ans.add(missing);
        return ans;
    }
}
