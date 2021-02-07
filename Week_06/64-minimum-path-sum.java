// problem[m][n] = min(sub[m - 1][n], sub[m][n-1])
// dp[i][j] = min(dp[m - 1][n], dp[m][n-1]) + grid[i][j]
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j]; 
                } else if(j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}