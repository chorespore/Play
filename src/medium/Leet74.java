package medium;

public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            int cur = matrix[mid / col][mid % col];
            if (cur < target) {
                low = mid + 1;
            } else if (cur > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
