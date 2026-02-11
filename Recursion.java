import java.util.Random;

class TwoDArray {

    int[][] arr = new int[2][2];
    Random rand = new Random();
    int number;
    int count = 0;

    public void fillTwoDArray() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                number = rand.nextInt(10) + 1;
                arr[i][j] = number;
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    public int addNumbers(int value1, int value2) {

        if (value1 == arr.length) {
            return 0;
        }

        int nextRow = value1;
        int nextCol = value2 + 1;

        if (nextCol == arr[value1].length) {
            nextRow = value1 + 1;
            nextCol = 0;
        }

       
        return arr[value1][value2] + addNumbers(nextRow, nextCol);
    }

}

public class Recursion {
    public static void main(String args[]) {
        TwoDArray Ta = new TwoDArray();
        System.out.println(Ta.arr);
        Ta.fillTwoDArray();
        System.out.println(Ta.addNumbers(0, 0));
    }
}
