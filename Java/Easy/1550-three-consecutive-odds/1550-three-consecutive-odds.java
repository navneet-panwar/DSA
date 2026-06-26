
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {

/*

An integer array is given.

Question asks whether there exist
three consecutive odd numbers.

Whenever you see an array,
immediately think:

for(int i = 0; i < arr.length; i++)
{
    int element = arr[i];
}


Now ask:

How do I identify an odd number?

Whenever you see "odd",

immediately think:

number % 2 != 0


Question is NOT asking:

How many odd numbers exist?

Instead it asks:

Are there 3 consecutive odd numbers?


So maintain a variable:

count = 0;

It stores how many consecutive
odd numbers have been seen.


Example:

arr = [2,5,7,9]

2 is even

count = 0


5 is odd

count = 1


7 is odd

count = 2


9 is odd

count = 3

Answer found.

Return true.


But if an even number appears,

Example:

[5,7,2,9]

Sequence breaks.

So start counting again.

count = 0


Hence:

If odd

count++

Else

count = 0


Whenever count becomes 3,

return true immediately.

If loop finishes,

it means no such sequence exists.

Return false.

*/

        int count = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] % 2 != 0) {

                count++;

                if(count == 3) {
                    return true;
                }

            } else {

                count = 0;
            }
        }

        return false;
    }
}

