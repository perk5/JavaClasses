public class MinMaxRecursive {


    public static int findMinimum(int[] arr, int min, int n){

        if(n >= arr.length){
            return min;
        }

        if(arr[n] < min){
            min = arr[n];
        }

        return findMinimum(arr, min, n + 1);

    }

    public static int findMaximum(int[] arr, int max, int n){

        if(n >= arr.length){
            return max;
        }

        if(arr[n] > max){
            max = arr[n];
        }

        return findMaximum(arr, max, n + 1);

    }

    public static void main(String args[]){

        int[] arr = new int[]{5, 7, 1, 4, 0, 4};

        System.out.println(findMinimum(arr, arr[0] , 0 ));
        System.out.println(findMaximum(arr, arr[0] , 0 ));

    }
}
