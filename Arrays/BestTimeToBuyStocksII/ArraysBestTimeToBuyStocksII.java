package Arrays.BestTimeToBuyStocksII;

class ArraysBestTimeToBuyStocksIIMain{
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int expectedPrice = 7;
        int actualPrice = new ArraysBestTimeToBuyStocksII().maxProfit(prices);

        if(expectedPrice != actualPrice){
            throw new AssertionError("prices dont match");
        }
        System.out.println("done");
    }
}
// given
// 
// int array of prices
// prices[i] - the ith day
//
// TODO
// return the maxium profit you can achieve
//
// details
// 
// each day you can buy or sell
// you can only hold at most one share of the stock at any time
// you can buy it and sel it the same day
public class ArraysBestTimeToBuyStocksII {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            // the "peak" and "valley" accumlate to the same
            // over time (disregarding taxes)
            // therfore we can just buy everytime the day before is lower than the next day
            int currentPrice = prices[i];
            int prevPrice = prices[i - 1];
            if (currentPrice > prevPrice){
                maxprofit += currentPrice - prevPrice;
            }
                
        }
        return maxprofit;
    }
}
