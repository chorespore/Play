package medium;

public class Leet240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        for (int[] row : matrix)
            if (row[0] <= target && target <= row[row.length - 1])
                if (searchRow(row, target))
                    return true;
        return false;
    }

    public boolean searchRow(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (target < nums[mid])
                high = mid - 1;
            else
                return true;
        }
        return false;
    }
}
