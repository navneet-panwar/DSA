class Solution {
    public int countDigits(int num) {

/*
Whenever you see: "digits of a number"

immediately think:

while(num > 0)
{
    int rem = num % 10;   // extract the last digit 
    num = num / 10;       // remove the last digit
}
// because this loop gives digits one by one from left to right . but you are not using those digits right now 


Now what you do with those digits depends on the problem.
eg:Count digits

        int count = 0;            // maintain a count var initialised as = 0, which will keep getting updated
                                  // if we write it inside loop it will start from count = 0 everytime ( problem!!)

        while(num > 0) {            
            int rem = num % 10;   // extract the digit from num and store in "rem"
            count++;              // before removing the extracted digit increase my "count" by 1
            num = num / 10;       // remove that digit from "num"   
        }                         // keep on doing this  while num>0 

        return count;             // finally return the count


eg:Sum Digits
        int sum = 0;              // maintain a count var initialised as = 0, which will keep getting updated
                                  // if we write it inside loop it will start from count = 0 everytime ( problem!!)

        while(num > 0) {
            int rem = num % 10;   // extract the digit from num and store in "rem"
            sum = sum + rem;      // add the extracted digit (in rem) to the sum (which was = 0 initially)
            num = num / 10;       // remove the digit from original number 
        }                         // keep on doing this  while num>0 

        return sum;               // return sum finally when loop ends
*/

/*
hence here say
num = 1248

Digits are:

1
2
4
8

Check if:

1248 % 1 == 0  ✔ update count coz it divides
1248 % 2 == 0  ✔ update count coz it divides
1248 % 4 == 0  ✔ update count coz it divides
1248 % 8 == 0  ✔ update count coz it divides

Answer:

4
*/
        
        int n = num;      // stores num in n 

        int count = 0;    //

// now this below logic is exactly same as out template
// but we are just putting "count++" inside "if block"

        while (n > 0) {

            int rem = n % 10;        // extract the last digit store it in "rem"

            if (num % rem == 0) {    // if that last digit (rem) fully divides num only then increase the count
                count++;
            }

            n = n / 10;              // other wise remove that last digit after testing it ( if it divides num fully still remove it )
                         
        }

        return count;               // after loop ends return "count" finally
    }
}