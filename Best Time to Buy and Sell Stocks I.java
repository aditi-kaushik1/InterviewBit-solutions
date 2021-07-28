public class Solution {
    public int maxProfit(final List<Integer> A) {
        if(A.size() == 0)
            return 0;
        int min = A.get(0);
        int max = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < min)
                min = Math.min(A.get(i), min);
            else
                max = Math.max(max, A.get(i) - min);
        }
        return max;
    }
}
