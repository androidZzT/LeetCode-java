package array;

public class MaxStockProfit2 {
	public static void main(String args[]) {
		int[] stock = {7,1,5,3,6,4};
		int result = maxProfit(stock);
		System.out.println(result);
	}
	
	public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 0, j = 1; j < prices.length; i++, j++) {
        	if (prices[j] > prices[i]) {
        		profit += prices[j] - prices[i];
        	}
        }
        return profit;
    }
}
