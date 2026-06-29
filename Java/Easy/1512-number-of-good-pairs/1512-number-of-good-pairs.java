
class Solution {
    public int numIdenticalPairs(int[] nums) {

/*

An integer array is given.

Question asks:

Return the number of good pairs.


A pair is good if:

nums[i] == nums[j]

and

i < j


My first thought:

Visit one element.

Then compare it with every
remaining element.

If both elements are equal,

I found one good pair.

Increase my answer.

Continue until every element
has been compared.


Whenever you see:

Compare one element with
all remaining elements,

immediately think:

Nested loops.


Outer loop:

Fix one element.

Inner loop:

Compare every remaining element.


Now a new question arises.

Why should inner loop start from:

j = i + 1 ?

Why not j = 0 ?


Because:

1. We should not compare
   an element with itself.

2. Question says:

   i < j

3. If we already checked:

   (0,3)

there is no need to check:

   (3,0)

again.

Hence:

j starts from i + 1.

*/


// stores total number
// of good pairs

        int goodPairs = 0;


// fix one element

        for(int i = 0; i < nums.length; i++) {


// compare it with all
// remaining elements

            for(int j = i + 1; j < nums.length; j++) {


// if both values are equal,
// one good pair is found

                if(nums[i] == nums[j]) {

                    goodPairs++;
                }
            }
        }


// return total good pairs

        return goodPairs;
    }
}


/*

Pattern Learned:

Whenever you see:

Compare one element with
every remaining element,

immediately think:

Nested loops.

Outer loop fixes one element.

Inner loop compares all
remaining elements.

If question contains:

i < j

start inner loop from:

j = i + 1

instead of 0.

*/
