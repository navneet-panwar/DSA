class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
 // Step 1 → method starts execution when LeetCode calls searchMatrix()

        int i = 0;                     
        // Step 2 → row pointer starts at first row

        int j = matrix[0].length - 1; 
        // Step 3 → column pointer starts at last column
        // so starting position becomes TOP RIGHT corner

        // Step 4 → loop runs while we stay inside matrix boundaries
        while (i < matrix.length && j >= 0) {

            // Step 5 → check the current element
            if (matrix[i][j] == target) {

                // Step 6 → element found
                return true;
            }

            // Step 7 → if current element is greater than target
            // then everything below it will be even bigger
            else if (matrix[i][j] > target) {

                // Step 8 → move LEFT to smaller numbers
                j--;
            }

            // Step 9 → if current element is smaller than target
            // then everything left of it will be even smaller
            else {

                // Step 10 → move DOWN to bigger numbers
                i++;
            }
        }

        // Step 11 → loop ended and element was not found
        return false;
    }
}