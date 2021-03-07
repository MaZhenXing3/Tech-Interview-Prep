package BinarySearch;

public class SearchInMatrix {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if (matrix[r][c] == target) {
                return new int[] {r, c};
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
