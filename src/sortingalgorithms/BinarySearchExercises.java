package sortingalgorithms;

public class BinarySearchExercises {
    /**
     * Given a sorted array, find the index of the first element ≥ K
     * (return -1 if no element ≥ K).
     *
     * nums = [0,5,19,21,22,54,99]
     * output = 5
     */
    public int firstIndexOfNumGreaterThanK(int[] nums, int k) {
        int length = nums.length;

        if (nums[0] >= k) return 0;
        if (nums[length - 1] < k) return -1;

        int low = 0;
        int high = length - 1;

        // [0,5,19,21,22,54,99]     k = 30
        //  l      m         h      m = 6/2 = 3
        //          l  m     h      m = 9/2 = 4
        //             l  m  h      m = 10/2 = 5
        //             l  h
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            if (nums[middle] < k)
                low = middle;
            else
                high = middle;
        }
        return high;
    }


    public static void main(String[] args) {
        BinarySearchExercises bs = new BinarySearchExercises();
        int[] nums = {0,5,19,21,22,54,99};
        int result = bs.firstIndexOfNumGreaterThanK(nums, 30);
        System.out.println(result);
    }

}
