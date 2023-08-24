class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        int max_pos = 0;
        int min_pos = 0;
        for (int i=0;i<prices.length;i++) {
            int now = prices[i];
            // 최고가 갱신
            if (now > max) {
                max_pos = i;
                max = now;
            }
            // 차익 계산
            max_profit = Math.max(max_profit, max-min);
            // 새로운 최저가 -> 이전 최고가 사용할 의미 없어지므로 초기화
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