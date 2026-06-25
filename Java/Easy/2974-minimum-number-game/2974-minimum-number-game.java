
class Solution {
    public int[] numberGame(int[] nums) {

/*

Question says:

remove the two minimum elements from the array

and add them in reverse order into another array.

Doing actual removals repeatedly is complicated.


Observation:

After sorting,

the two minimum elements will always be adjacent.

Example:

[2,3,4,5,6,7]

Two minimum:

2,3

Add in reverse:

3,2


Next two minimum:

4,5

Add in reverse:

5,4


Hence:

1. Sort array.
2. Create another array "arr".
3. Traverse in steps of 2.
4. Store every pair into arr in reverse order.
5. Return arr.

*/

        Arrays.sort(nums);          // smallest elements become adjacent after sorting

        int[] arr = new int[nums.length];   // question asks us to build another array which has same number of elements as nums


// now a new question arises: "i" is already helping us traverse nums. 
// then how will we know where to store elements inside arr? 
// therefore we need another variable which keeps track of the current index of arr. 
// initially arr is empty, so first element should be stored at index 0.

        int j = 0;                  // index for arr

// move 2 steps because every iteration processes one pair

        for(int i = 0; i < nums.length; i += 2) {

            arr[j] = nums[i + 1]; // second minimum goes first
            j++;                  // next insertion should happen at next index
            
            arr[j] = nums[i];     // first minimum goes second
            j++;                  // again move to next empty position
        }

        return arr;
    }
}

/*

The trick of this problem is NOT finding minimums repeatedly.

The trick is realizing:

remove two minimum repeatedly
            ↓
sort array once
            ↓
process adjacent pairs
            ↓
store them in reverse order into arr
            ↓
return arr

*/

