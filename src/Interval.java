import java.util.ArrayList;
import java.util.List;

public class Interval {
    public static void main(String[] args) {
        int[][] intervals = {{4, 5},{10, 11},{-1, 7}};
        System.out.println(checkIfIntersectsAll(intervals));

/****   TEST - checkIfInteresectsTwo works correctly (not taking 0 length into account) */
//        int[] first = {0,1}; int[] second = {1,2};
//        System.out.println("1T. " + checkIfIntersects(first, second));
//        first[0] = 0; first[1] = 2; second[0] = 1; second[1] = 3;
//        System.out.println("2T. " + checkIfIntersects(first, second));
//        first[0] = 0; first[1] = 1; second[0] = 0; second[1] = 2;
//        System.out.println("3T. " + checkIfIntersects(first, second));
//        first[0] = 1; first[1] = 2; second[0] = 0; second[1] = 3;
//        System.out.println("4T. " + checkIfIntersects(first, second));
//        first[0] = 1; first[1] = 2; second[0] = 0; second[1] = 1;
//        System.out.println("5T. " + checkIfIntersects(first, second));
//        first[0] = 1; first[1] = 3; second[0] = 0; second[1] = 2;
//        System.out.println("6T. " + checkIfIntersects(first, second));
//        first[0] = 1; first[1] = 2; second[0] = 0; second[1] = 2;
//        System.out.println("7T. " + checkIfIntersects(first, second));
//        first[0] = 0; first[1] = 3; second[0] = 1; second[1] = 2;
//        System.out.println("8T. " + checkIfIntersects(first, second));
//        first[0] = 0; first[1] = 1; second[0] = 2; second[1] = 3;
//        System.out.println("9F. " + checkIfIntersects(first, second));
//        first[0] = 2; first[1] = 3; second[0] = 0; second[1] = 1;
//        System.out.println("10F. " + checkIfIntersects(first, second));
    }

    // todo: first check if "length = 0" => delete int[]

    public static int sumIntervals(int[][] intervals) {
        int sumOfInterval;
        return -1;
    }

//    public static int[][] transformToDisjointedInterval(int[][] intervals){
//        List<int[]> disjointedIntervals = new ArrayList<>();
//        boolean madeAChange = true;
//        while(madeAChange){
//            for(int[] interval : intervals){
//                if(disjointedIntervals.isEmpty()){
//                    disjointedIntervals.add(interval);
//                }
//                for(int[] disInterval : disjointedIntervals){
//
//                }
//            }
//        }
//        return disjointedIntervals;
//    }

    public static int[] joinIntersects(int[] first, int[] second){
        int[] joint = new int[2];
        joint[0] = (first[0]<second[0] ? first[0] : second[0]);
        joint[1] = (first[1]>second[1] ? first[1] : second[1]);
        return joint;
    }

    public static boolean checkIfIntersectsAll(int[][] intervals){
        for (int i = 0; i < intervals.length; i++) {
            for(int j = i+1; j < intervals.length; j++)
                if(checkIfIntersectsTwo(intervals[i], intervals[j])){
                    return true;
                }
        }
        return false;
    }

    public static boolean checkIfIntersectsTwo(int[] first, int[] second){
        if((first[1]<second[0]) || (first[0]>second[1])){
            return false;
        }
        return true;
    }

    public static int sumOfDisjointedIntervals(int[][] disjointedIntervals){
        int sum = 0;
        for(int[] interval : disjointedIntervals){
            sum += interval[1]-interval[0];
        }
        return sum;
    }

}
