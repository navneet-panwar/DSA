class Solution {
    public int[] numberGame(int[] nums) {


/*

Question says:

remove the two minimum elements from a array

and add them in reverse order in another array.

Doing actual removals repeatedly is complicated.


Observation:

After sorting,
the two minimum elements will always be adjacent.

Example:

[2,3,4,5,6,7]

Two minimum:

2,3

Now Add in reverse:

3,2


Next two minimum:

4,5

Now Add in reverse:

5,4


Hence:

1. Sort array.
2. Traverse in steps of 2.
3. Swap every pair.
4. Return array.

*/

        Arrays.sort(nums);   // smallest elements come together after sorting

// move 2 steps at a time because we process elements in pairs

        for(int i = 0; i < nums.length; i += 2) {

            int temp = nums[i];      // store first element temporarily

            nums[i] = nums[i + 1];   // put second element at first position

            nums[i + 1] = temp;      // put first element at second position
        }

        return nums;                 // array now contains required ordering

    }
}
/* The trick of this problem is not finding minimums repeatedly.

 The trick is realizing:
     remove two minimum repeatedly
             ↓
     sort array once
             ↓
     swap every adjacent pair
*/

