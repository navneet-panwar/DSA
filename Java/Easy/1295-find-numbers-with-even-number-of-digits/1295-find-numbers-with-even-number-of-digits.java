class Solution {
    public int findNumbers(int[] nums) {


// i should traverse the array 

// then for every element i should store it and count it's digits
//  if didgits  = even 
// store the count

// otherwise keep on trying on next digits

        int HowManyEven = 0;

// traversing
        for( int i = 0; i< nums.length; i++ ){

            int element = nums[i];  // storing the element


            int count = 0;

            while( element > 0 ){        // count digit logic
            
                int rem = element % 10;  // extract the last digit
                count++;                 // increase the count ( that's why maintained count = 0 above )
                element = element/10;    // remove the digit from original, coz it got counted

            }
            

            if( count % 2 == 0 ){    // if that count is divisible by 2
                                     // means the number has an even number of digits

                HowManyEven++;       // so update the variable maintained above for loop
                                     // which stores how many even 
                                     // so for every element you have to check whether it is even or not and then only you should update it
                                     // that's why written outside for loop
            }

        }
        return HowManyEven;


    }

}