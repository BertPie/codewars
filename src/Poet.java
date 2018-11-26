import java.util.*;

public class Poet {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(pendulum(new int[]{0, 1, 2, 3, 4, 5})));
    }

    public static int[] pendulum(final int[] values) {
        int size = values.length;

        int[] sortedValues = Arrays.copyOf(values, size);
        Arrays.sort(sortedValues);

        Deque<Integer> resultAsLinkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                resultAsLinkedList.addFirst(sortedValues[i]);
            } else {
                resultAsLinkedList.addLast(sortedValues[i]);
            }
        }

        return resultAsLinkedList.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * O CO CHODZI W LINIJCE 34? Dlaczego przecinki??
     *
     * public static int[] pendulum(final int[] arr) {
     *     java.util.Arrays.sort(arr);
     *     int ret[] = new int[arr.length], i = (arr.length-1)/2, j = i+1, n = 0;
     *     for (int x : arr) ret[n++%2==0 ? i-- : j++] = x;
     *     return ret;
     *   }
     */
}
