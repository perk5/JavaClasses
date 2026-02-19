public class RecursiveTwoSum {

    public static boolean twoSum(int[] arr, int k, int j, int i) {

        if (i >= arr.length) {
            return false;
        }

        if (arr[k] + arr[j] == arr[i]) {
            return true;
        }

        if (j < i - 1) {
            return twoSum(arr, k, j + 1, i);
        }

        // else if (k < j - 1 && j != 1) {
        //     if (k < j - 2) {
        //         j = 2;
        //     }
        //     return twoSum(arr, k + 1, j, i);
        // } else {
        //     k = 0;
        //     j = 1;
        //     return twoSum(arr, k, j, i + 1);
        // }

        if (k < i - 2) {
            return twoSum(arr, k + 1, k + 2, i);
        }

        return twoSum(arr, 0, 1, i + 1);

    }

    public static void main(String args[]) {
        int[] arr = new int[] { 1, 3, 10, 12, 14};
        System.out.println(twoSum(arr, 0, 1, 2));
    }
}
