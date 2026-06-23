class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Step 7 → Function starts

        int n = nums.length;

        /*
        Step 8 → Create 2D array:
                 temp[i][0] → value
                 temp[i][1] → original index
        */
        int[][] temp = new int[n][2];

        // Step 9 → Fill temp with value + index
        for (int i = 0; i < n; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }

        /*
        Step 10 → Sort based on value (column 0)
        */
        java.util.Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        /*
        Step 11 → Two Pointer setup
        */
        int left = 0;
        int right = n - 1;

        /*
        Step 12 → Traverse using two pointer
        */
        while (left < right) {

            // Step 13 → Calculate sum
            int sum = temp[left][0] + temp[right][0];

            if (sum == target) {

                /*
                Step 14 → Found answer
                Return ORIGINAL indices
                */
                return new int[]{temp[left][1], temp[right][1]};
            }

            else if (sum < target) {

                /*
                Step 15 → Sum too small → increase it
                Move left forward
                */
                left++;
            }

            else {

                /*
                Step 15 → Sum too big → decrease it
                Move right backward
                */
                right--;
            }
        }

        // Step 16 → Safety return
        return new int[]{-1, -1};
    }
    }
