class Solution {

    public int search(int[] nums, int target) {

        // Binary search:
        // binary search is applied on sorted data always, why? because we decide whether to go left or right based on comparison.
        // if array is not sorted, we cannot eliminate half of it confidently.

        // LeetCode already gives me:
        // nums   -> sorted array.
        // target -> item to be searched

        int low = 0;
        int high = nums.length - 1;

        // now what condition should I write for my loop and which loop should be used
        //
        // if 2 people are searching the element
        // 1 from the low (->)
        // 1 from the high (<-)
        //
        // then they will cross each other only when item is not found from both ends
        //
        // that means all my searching conditionals should be used only when item exists in the remaining search space
        //
        // so don't you think I should put while(low <= high)
        // because once low becomes greater than high, that's a deal breaker
        // and implies item does not exist

        while (low <= high) {

            // now to find mid we take (low + high) / 2

            int mid = (low + high) / 2;

            // since we are searching the element
            // there can be 3 cases for the mid
            //
            // 1) mid == item we are searching
            // 2) mid > item we are searching
            // 3) mid < item we are searching

            if (nums[mid] == target) {

                // found the item
                // simply return its index

                return mid;
            }

            else if (nums[mid] > target) {

                // target lies before mid
                //
                // because array is sorted
                // so I can safely ignore everything after mid
                //
                // hence high becomes mid - 1

                high = mid - 1;
            }

            else {

                // target lies after mid
                //
                // because array is sorted
                // so I can safely ignore everything before mid
                //
                // hence low becomes mid + 1

                low = mid + 1;
            }
        }

        // low crossed high
        // item does not exist

        return -1;
    }
}