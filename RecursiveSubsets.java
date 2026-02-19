import java.util.*;

public class RecursiveSubsets {

    public static void printSubsets(List<Integer> arr, List<Integer> subSets, List<List<Integer>> allSubsets, int n) {
        if (n == arr.size()) {
            if (!allSubsets.contains(subSets)) {
                allSubsets.add(new ArrayList<>(subSets));
            }
            return;
        }

        subSets.add(arr.get(n));
        printSubsets(arr, subSets, allSubsets, n + 1);
        subSets.remove(subSets.size() - 1);
        printSubsets(arr, subSets, allSubsets, n + 1);

    }

    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        List<Integer> subSets = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();

        printSubsets(arr, subSets, allSubsets, 0);
        System.out.println(allSubsets);
    }
}