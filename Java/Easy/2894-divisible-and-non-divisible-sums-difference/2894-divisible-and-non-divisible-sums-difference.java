
class Solution {
    public int differenceOfSums(int n, int m) {

/*

Question says:

consider all numbers from

1 to n


Now divide them into two groups.


Group 1:

numbers NOT divisible by m

store their sum in:

num1


Group 2:

numbers divisible by m

store their sum in:

num2


By seeing:

1 to n

i immediately think:

for(int i = 1; i <= n; i++)
{
}


Now for every number,

check whether it is divisible by m.


Whenever you see:

divisible by

immediately think:

number % divisor == 0


If divisible,

add current number to num2.

Otherwise,

add current number to num1.


Finally question asks:

num1 - num2

so return:

num1 - num2

*/

        int num1 = 0;    // sum of numbers not divisible by m

        int num2 = 0;    // sum of numbers divisible by m

        for(int i = 1; i <= n; i++) {



            if(i % m == 0) {     // if current number is divisible by m

                num2 += i;       // then add that number to num2

            } else {

                num1 += i;       // otherwise add that number to num1
            }
        }

        return num1 - num2;
    }
}
