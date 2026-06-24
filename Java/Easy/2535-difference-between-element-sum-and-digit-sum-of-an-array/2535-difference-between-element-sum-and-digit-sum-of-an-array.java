
class Solution {
    public int differenceOfSum(int[] nums) {

/*

positive integer array is given

Question asks:

absolute difference between

1) element sum
2) digit sum



----------------------------------------------------
WHAT IS ELEMENT SUM?
----------------------------------------------------

Example:

nums = [1,15,6,3]

element sum means:

1 + 15 + 6 + 3

= 25


By seeing "sum of array elements"

I immediately think:

int elementSum = 0;

for(int i = 0; i < nums.length; i++)
{
    int element = nums[i];

    elementSum += element;
}



----------------------------------------------------
WHAT IS DIGIT SUM?
----------------------------------------------------

Example:

nums = [1,15,6,3]

digit sum means:

1 + 1 + 5 + 6 + 3

= 16


Notice:

we are not adding complete elements anymore.

we are adding individual digits of every element.


So first extract an element from array:

int element = nums[i];


Then extract all digits of that element.

Whenever you see: digits of a number

immediately think:

while(element > 0)
{
    int rem = element % 10;

    element = element / 10;
}

because this loop gives digits one by one.


Example:

element = 15


15 % 10 = 5

digitSum += 5

15 / 10 = 1


1 % 10 = 1

digitSum += 1

1 / 10 = 0


element becomes 0

therefore loop stops.


Now do this for EVERY element of the array.



----------------------------------------------------
COMBINING BOTH IDEAS
----------------------------------------------------

for loop
    ↓
gives one element

while loop
    ↓
gives digits of that element


Example:

nums = [1,15,6,3]


for loop gives:

1

15

6

3


while loop gives:

1

1,5

6

3


digit sum becomes:

1 + 1 + 5 + 6 + 3

= 16



----------------------------------------------------
FINAL STEP
----------------------------------------------------

Question asks:

absolute difference

therefore:

elementSum = 25

digitSum = 16


difference = 25 - 16
= 9


But what if:

digitSum > elementSum ?


Then answer becomes negative.


Question wants absolute difference.

Absolute value means: "always positive answer"


Example:
        |-9| = 9
        |9|  = 9


Hence we have to use:
Math.abs(elementSum - digitSum)



----------------------------------------------------
PATTERN LEARNED
----------------------------------------------------

When question contains:

Array
        ↓
Traverse using for loop


Digits of a number
        ↓
Extract using while loop


Array + Digits
        ↓
for loop outside

while loop inside

*/


        int elementSum = 0;

        int digitSum = 0;

        for(int i = 0; i < nums.length; i++) {

            int element = nums[i];

            elementSum += element;

// now extract all digits of current element

            while(element > 0) {

                int rem = element % 10;

                digitSum += rem;

                element = element / 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}
