class Solution {
    public String[] createGrid(int k, int n) {

        char[][] grid = new char[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        for (int i = 0; i < k; i++) {
            grid[i][n - 1] = '.';
        }

        String[] ans = new String[k];

        for (int i = 0; i < k; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}