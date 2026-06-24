class Solution {
    public int[] sortedSquares(int[] nums) {
/*

an integer array is sorted in ascending order
sqaure each element of the array and return in ascending order

*/

/*
i think i would traverse each each element of the array 
so:
for(i=0; i<nums.length;i++){

    int element = nums[i];

//but i would also square tht number
    int square = element * element; 

// now i would like to store this number inside a new array, which will create outside for loop and then i will sort that array 
    
}

so starting from scratch again:

        int[] squaredNums = new int[nums.length]; // new array should be of same length as nums

        for(int i = 0; i < nums.length; i++){

            int element = nums[i];

            int square = element * element;

            squaredNums[i] = square;  // store that squared number inside ith position of new array

        }
        Arrays.sort(squaredNums);   // sort the newarray in ascending order

        return squaredNums;         // return the new array finally 

BUT THIS IS NOT THE OPTIMAL SOLUTION

*/


/*
## OPTIMAL THOUGHT PROCESS

Question says:

array is already sorted

Example: [-4,-1,0,3,10]

After squaring: [16,1,0,9,100]

Notice something:

The largest square comes from the number having the largest absolute value.

Example:

-4 → 16
10 → 100

100 is bigger.

So the largest square will always come from:

        1) either the leftmost element
        2) or the rightmost element

Why?
because in a sorted array the largest absolute values are always sitting at the ends.


Hence instead of:

Square everything
↓
Sort again

we can do:

Compare left square and right square
↓
Take larger square
↓
Put it directly into answer array

Now a new question arises:

Where should we place the larger square?

Since it is the largest value currently available,
it belongs towards the END of the sorted answer array.

Example:

nums = [-4,-1,0,3,10]

left = 0th index
right = 4th index

Compare: (-4)^2 = 16

         (10)^2 = 100

100 is bigger.

So place it at the LAST position.

answer: [*,*,*,*,100]


Now move right pointer.

left = 0th index
right = 3th index

Compare:

(-4)^2 = 16

(3)^2 = 9

16 is bigger.

Place it next from the back.

answer: [*,*,_,16,100]

Move left pointer.

left = 1
right = 3

Compare:

(-1)^2 = 1

(3)^2 = 9

9 is bigger.

answer:

[*,*,9,16,100]

Move right pointer.

left = 1
right = 2

Compare:

(-1)^2 = 1

(0)^2 = 0

1 is bigger.

answer:

[_,1,9,16,100]

Move left pointer.

left = 2
right = 2

Compare:

0^2 = 0

0^2 = 0

answer:

[0,1,9,16,100]

Done.


Hence:

1. Create answer array.

2. Keep two pointers:

   left = 0
   right = nums.length - 1

3. Fill answer array from END to START.

4. Compare:

   nums[left] * nums[left]

   and

   nums[right] * nums[right]

5. Larger square goes into answer array.

6. Move the corresponding pointer.

7. Return answer array finally.

PATTERN LEARNED:

When array is sorted and answer depends on values at the extremes,

think:
Two Pointers

left = 0

right = arr.length - 1

and keep shrinking the window.

*/

/*
TWO POINTERS - HOW TO KNOW WHICH POINTER TO MOVE?

A very common doubt is:
How do I know whether to move left pointer or right pointer?

Answer: Move the pointer whose value was used.

Example:

leftSquare  = 16
rightSquare = 9

Since 16 is larger,

we place 16 into the answer array.

Now ask: Can 16 help us again later?
No

Because we have already used it.

So the element that produced 16 has completed its job.

Hence move that pointer.

Since 16 came from leftSquare,

move:

left++

Another example:

leftSquare  = 1
rightSquare = 9

Since 9 is larger,

we place 9 into the answer array.

Now ask:

Which side produced 9?

Right side.

Since that element has already been used,

move:

right--

GENERAL RULE:

Whichever side contributes the value
that gets placed into the answer array,

move that side's pointer.

In code:

if(leftSquare > rightSquare) {

ans[idx] = leftSquare;   //once a value has been selected and placed into the answer, that element's work is finished. you don't need it again so change the pointer that produced it 

left++;     // coz left produced the chosen value


}

else
{
ans[idx] = rightSquare;  ////once a value has been selected and placed into the answer, that element's work is finished. you don't need it again so change the pointer that produced it


right--;   // coz right produced the chosen value


}



PATTERN TO REMEMBER:

Use a value
↓
The pointer that produced that value
has completed its job
↓
Move that pointer
↓
Continue comparing the remaining values


*/
        int[] ans = new int[nums.length];  // stores the final sorted squares

        int left = 0;                      // points to first element
        int right = nums.length - 1;       // points to last element

        int idx = nums.length - 1;         // start filling answer array from the end


// continue until all elements between left and right are processed

        while (left <= right) {

// square of leftmost element

            int leftSquare = nums[left] * nums[left];

// square of rightmost element

            int rightSquare = nums[right] * nums[right];

// larger square should go at the current idx position
// because we are filling answer array from back to front

            if (leftSquare > rightSquare) {

                ans[idx] = leftSquare;     // place larger square

                left++;                    // left element has been used

            } else {

                ans[idx] = rightSquare;    // place larger square

                right--;                   // right element has been used
            }

            idx--;                         // move to next position from the back
        }

        return ans;                        // return final sorted squares array


    }
}


/*
TWO POINTER APPROACH

this won't work for every two-pointer question. There are several flavors (opposite ends, same direction/sliding window, fast-slow pointers, partitioning, etc.). This note covers the most common opposite-end two-pointer pattern used in problems like 977, Two Sum II, Container With Most Water, etc.


Whenever you see:

1) Sorted Array
2) Pair Problems
3) Need to compare values from both ends
4) Need to shrink the search space gradually

immediately think:

left = 0;
right = arr.length - 1;



----------------------------------------------------
STEP 1 : PLACE TWO POINTERS
----------------------------------------------------

int left = 0;                 // first element

int right = arr.length - 1;   // last element


Array:

[10,20,30,40,50]

 L           R

left and right represent the current window
that is still under consideration.



----------------------------------------------------
STEP 2 : KEEP WORKING UNTIL POINTERS CROSS
----------------------------------------------------

while(left <= right)
{
    ...
}

Why?

Because:

left > right

means no elements are left to process.



----------------------------------------------------
STEP 3 : INSPECT THE VALUES
----------------------------------------------------

int leftValue = arr[left];

int rightValue = arr[right];


Now decide what the problem wants.

Examples:

Compare values
Compare squares
Find pair sum
Find pair difference
Find maximum area

etc.



----------------------------------------------------
STEP 4 : USE ONE OF THE VALUES
----------------------------------------------------

Suppose:

leftValue = 20

rightValue = 50


Problem logic decides:

50 is more useful.

Therefore use 50.



----------------------------------------------------
STEP 5 : MOVE THE POINTER
----------------------------------------------------

VERY IMPORTANT RULE:

Move the pointer whose value was used.


Example:

50 was used.

50 came from right side.

Therefore:

right--;



Another Example:

20 was used.

20 came from left side.

Therefore:

left++;



Reason:

That element has completed its job.

No need to compare it again.



----------------------------------------------------
STEP 6 : WINDOW SHRINKS
----------------------------------------------------

Initially:

[10,20,30,40,50]

 L           R


After moving right:

[10,20,30,40,50]

 L        R


After moving left:

[10,20,30,40,50]

    L     R


Search space keeps shrinking.



----------------------------------------------------
MOST IMPORTANT RULE OF TWO POINTERS
----------------------------------------------------

Use a value
       ↓
That element's job is finished
       ↓
Move the pointer that produced it
       ↓
Continue with remaining elements



----------------------------------------------------
COMMON MOVEMENTS
----------------------------------------------------

// move left pointer

left++;


// move right pointer

right--;



----------------------------------------------------
MENTAL TEMPLATE
----------------------------------------------------

int left = 0;

int right = arr.length - 1;

while(left <= right)
{
    // inspect left value

    // inspect right value

    // apply problem logic

    // move the pointer whose value was used
}
```

The only thing that changes from one two-pointer question to another is:

```java
// apply problem logic
```

Everything else usually remains almost identical.
*/