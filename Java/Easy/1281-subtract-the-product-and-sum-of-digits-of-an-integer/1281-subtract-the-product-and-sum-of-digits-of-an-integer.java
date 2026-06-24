class Solution {
    public int subtractProductAndSum(int n) {

 
        int product = 1;   // can't be 0 coz when something gets multiplied to it will become 0 too
        int sum = 0;

        while(n>0){
            int rem = n % 10;     // extract the last digit
            product = product * rem; // multiply extacted value into product and store in it product so it gets updated  above
            sum = sum + rem;    // add extacted value to sum and store in it sum so it gets updated  above
            n = n/10;           // remove the extracted element from the original number after it gets used
        }

        return product - sum;
        
    }
}