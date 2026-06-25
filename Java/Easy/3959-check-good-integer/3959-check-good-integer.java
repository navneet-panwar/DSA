class Solution {


    public int SumOfdigits(int n){

            int sum = 0;                            
            
            
            while (n > 0) {
               int rem = n % 10;                  
               sum += rem;      
                n = n / 10;                       
            }
            return sum;
    }
        



    

        public int SquareSumOfDigits(int n){
            
                    int sum = 0;                            
            
            
                        while (n > 0) {
                            int rem = n % 10;                  
                            sum += (int) Math.pow(rem, 2);      
                            n = n / 10;                       
                        }
            
                        
                        return sum;
        
    }
    
    public boolean checkGoodInteger(int n) {

    if (SquareSumOfDigits(n) - SumOfdigits(n) >= 50 ){
        return true;
    }
        return false;
        
    }

    

    
}