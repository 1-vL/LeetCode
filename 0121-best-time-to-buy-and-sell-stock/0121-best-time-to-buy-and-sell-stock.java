class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        int max_pos = 0;
        int min_pos = 0;
        for (int i=0;i<prices.length;i++) {
            int now = prices[i];
            if (now > max) {
                max_pos = i;
                max = now;
            }
            max_profit = Math.max(max_profit, max-min);
            if (now < min) {
                min_pos = i;
                min = now;
                max_pos = i;
                max = now;
            }
        }
        return max_profit;
    }
}