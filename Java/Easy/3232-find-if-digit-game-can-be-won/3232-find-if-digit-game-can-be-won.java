
class Solution {
    public boolean canAliceWin(int[] nums) {

/*

An integer array is given.

Alice has only TWO choices:

1. Take all single-digit numbers.
2. Take all double-digit numbers.

Remaining numbers automatically go to Bob.


So we should calculate:

singleDigitSum

and

doubleDigitSum


Whenever you see an array,

immediately think:

for(int i = 0; i < nums.length; i++)
{
    int element = nums[i];
}


Now ask:

How do I identify a single-digit number?

1 to 9

means:

element < 10


Otherwise,

it is a double-digit number.

(Question says numbers are from 1 to 99)


Hence,

if(element < 10)

add it to singleDigitSum

else

add it to doubleDigitSum


After traversing the complete array,

we will know:

total of all single-digit numbers

and

total of all double-digit numbers.


Now think from Alice's perspective.

Case 1:

Alice chooses all single-digit numbers.

Alice's score:

singleDigitSum

Bob's score:

doubleDigitSum

If

singleDigitSum > doubleDigitSum

Alice wins.


Case 2:

Alice chooses all double-digit numbers.

Alice's score:

doubleDigitSum

Bob's score:

singleDigitSum

If

doubleDigitSum > singleDigitSum

Alice wins.


Hence,

if either case is true,

return true.

Otherwise,

return false.

*/

        int singleDigitSum = 0;
        int doubleDigitSum = 0;

        for(int i = 0; i < nums.length; i++) {

            int element = nums[i];

            if(element < 10) {

                singleDigitSum += element;

            } else {

                doubleDigitSum += element;
            }
        }

        return singleDigitSum > doubleDigitSum ||
               doubleDigitSum > singleDigitSum;
    }
}
