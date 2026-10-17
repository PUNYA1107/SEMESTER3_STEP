public class BusRowSolution {
    
    // Function that returns an array containing {row_index, total}
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;
        
        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            
            // Update only when total is strictly larger to handle ties by smaller index
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }
        
        return new int[] { bestRow, maxTotal };
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
