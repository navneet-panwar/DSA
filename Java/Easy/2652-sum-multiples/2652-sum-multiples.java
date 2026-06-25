class Solution {
    public int sumOfMultiples(int n) {

/*

Question says:

find the sum of all numbers from 1 to n

that are divisible by

3 or 5 or 7.


By seeing:

1 to n

i immediately think:

for(int i = 1; i <= n; i++)
{
}


Now for every number,

check whether it is divisible by

3 or 5 or 7.


Whenever you see:

divisible by

immediately think:

number % divisor == 0


We don't have to store those numbers separately.

Question only asks for their SUM.

So maintain:

sum = 0

Whenever current number satisfies any one condition,

add it to sum.

Finally return sum.

*/

        int sum = 0;

        for(int i = 1; i <= n; i++) {

// if current number is divisible by 3, 5 or 7

            if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {

                sum += i;    // add current number to sum
            }
        }

        return sum;
    }
}