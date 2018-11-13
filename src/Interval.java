import java.util.ArrayList;
import java.util.List;

public class Interval {
    public static void main(String[] args) {
        int[][] intervals = {{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},};
        System.out.println("Sum: " + sumIntervals(intervals));
    }

    public static int sumIntervals(int[][] intervals) {
        if(intervals == null){
            return 0;
        }
        int sumOfInterval;
        ArrayList<int[]> intervalsList = arrayToArrayList(intervals);
        deleteNullsAndZeroLength(intervalsList);
        ArrayList<int[]> disjointedList = transformToDisjointedInterval(intervalsList);
        if(disjointedList.size() == 0){
            return 0;
        }
        sumOfInterval = sumOfDisjointedIntervals(disjointedList);
        return sumOfInterval;
    }

    public static ArrayList<int[]> deleteNullsAndZeroLength(ArrayList<int[]> arrayList){
        boolean madeChange = true;
        while(madeChange) {
            madeChange = false;
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) == null){
                    arrayList.remove(i);
                    madeChange = true;
                    break;
                }
                if(arrayList.get(i)[0] == arrayList.get(i)[1]){
                    arrayList.remove(i);
                    madeChange = true;
                    break;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<int[]> arrayToArrayList(int[][] intArrayArray) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] intArray : intArrayArray) {
            list.add(intArray);
        }
        return list;
    }

    public static ArrayList<int[]> transformToDisjointedInterval(ArrayList<int[]> intervalsList) {
        boolean madeChange = true;
        while (madeChange) {
            madeChange = false;
            System.out.println();
            for (int i = 0; i < (intervalsList.size() - 1); i++) {
                for (int j = i + 1; j < intervalsList.size(); j++) {
                    int[] intervalOne = intervalsList.get(i);
                    int[] intervalTwo = intervalsList.get(j);
                    if (checkIfIntersectsTwo(intervalOne, intervalTwo)) {
                        madeChange = true;
                        int[] intervalNew = joinIntersects(intervalOne, intervalTwo);
                        intervalsList.add(intervalNew);
                        intervalsList.remove(i);
                        // have to subtract one, because index is lower after removing the first one
                        intervalsList.remove(j-1);
                    }
                }
            }
        }
        return intervalsList;
    }

    public static int[] joinIntersects(int[] first, int[] second) {
        int[] joint = new int[2];
        joint[0] = (first[0] < second[0] ? first[0] : second[0]);
        joint[1] = (first[1] > second[1] ? first[1] : second[1]);
        return joint;
    }

    public static boolean checkIfIntersectsTwo(int[] first, int[] second) {
        if ((first[1] < second[0]) || (first[0] > second[1])) {
            return false;
        }
        return true;
    }

    public static int sumOfDisjointedIntervals(List<int[]> disjointedIntervals) {
        int sum = 0;
        for (int[] interval : disjointedIntervals) {
            sum += interval[1] - interval[0];
        }
        return sum;
    }
}
/**
 * Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
 *
 * Intervals
 * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
 *
 * Overlapping Intervals
 * List containing overlapping intervals:
 *
 * [
 *    [1,4],
 *    [7, 10],
 *    [3, 5]
 * ]
 * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
 *
 * Examples:
 * // null argument
 * Interval.sumIntervals(null);  // => 0
 *
 * // empty intervals
 * Interval.sumIntervals(new int[][]{});  // => 0
 * Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0
 *
 * // disjoined intervals
 * Interval.sumIntervals(new int[][]{
 *   {1,2},{3,5}
 * });  // => (2-1) + (5-3) = 3
 *
 * // overlapping intervals
 * Interval.sumIntervals(new int[][]{
 *   {1,4},{3,6},{2,8}
 * });  // [1,8] => 7
*/
