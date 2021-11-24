package com.datastructures.exercises;

import java.util.*;

public class HashTableExercises {
    /**
     *1- Find the most repeated element in an array of integers.
     * What is the time complexity of this method? (A variation of this exercise
     * is finding the most repeated word in a sentence. The algorithm is the same.
     * ere we use an array of numbers for simplicity.)  Input: [1, 2, 2, 3, 3, 3, 4]
     * Output: 3
     */
    public int mostFrequentNum(int[] numbers) {
        if (numbers.length == 0) return -1;
        if (numbers.length == 1) return numbers[0];

        Map<Integer, Integer> map  = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int currHighestFreq = -1;
        int currKey = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > currHighestFreq) {
                currHighestFreq = entry.getValue();
                currKey = entry.getKey();
            }
        }
        return currKey;
    }

    public String mostFrequentWord(String sentence) {
        if (sentence.length() == 0) return "";


        String[] splitSentence = sentence.split(" ");
        if (splitSentence.length == 1) return splitSentence[0];
        Map<String, Integer> map = new HashMap<>();
        System.out.println(Arrays.toString(splitSentence));
        for (String word : splitSentence) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int currHighestFreq = -1;
        String currWord = splitSentence[0];
        System.out.println(map.keySet());
        for (String key : map.keySet()) {
            if (map.get(key) > currHighestFreq) {
                currHighestFreq = map.get(key);
                currWord = key;
            }
        }
        return currWord;
    }

    /**
     * 2- Given an array of integers, count the number of unique pairs of integers that ha
     * ve difference k.
     * Input: [1, 7, 5, 9, 2, 12, 3] K=2
     * Output: 4 We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
     * Note that we only want the number of these pairs, not the pairs themselves.
     *
     **/
    public int countPairsWithDiff(int[] nums, int k) {
        // array -> set [1,7,5,9,2,12,3]
        // check if set has num + k
        // check if set has num - k
        // 1 + 2 = 3, 1 - 2 = -1   contains(3) -> remove 1 from set
        // 7 + 2 = 9, 7 - 2 = 5    contains(9), contains(5) remove 7 from set
        // 5 + 2 = 7, 5 - 2 = 3
        // 9 - 2 = 7, 9 + 2 = 11
        // 2 - 2 = 0, 2 + 2 = 4
        // 12 - 2 = 10, 12 + 2 = 14
        // 3 - 2 = 1, 3 + 2 = 5     contains(1)     remove 3 from set
        //                          total = 4
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (set.contains(num - k)) {
                count++;
            }
            if (set.contains(num + k)) {
                count++;
            }
            set.remove(num);
        }
        return count;
    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * Input: [2, 7, 11, 15] - target = 9 Output: [0, 1] (because 2 + 7 = 9)Assume that each input has
     * exactly one solution, and you may not use the same element twice.
     *
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        HashTableExercises hashTable = new HashTableExercises();

//        int res = hashTable.mostFrequentNum(new int[]{1,1,1,1,2,2,3,1,2,3,4});
//        System.out.println(res);
//        res = hashTable.mostFrequentNum(new int[]{});
//        System.out.println(res);
//        res = hashTable.mostFrequentNum(new int[]{99});
//        System.out.println(res);
//
//        String wordRes = hashTable.mostFrequentWord("Hello Hello Hello Word a a x ma b c ab ab ba ba c l f g");
//        System.out.println(wordRes);

//        int numPairsWithDiff = hashTable.countPairsWithDiff(new int[]{1, 7, 5, 9, 2, 12, 3}, 2);
//        System.out.println(numPairsWithDiff);


        int[] twoSumResult = hashTable.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(twoSumResult));
    }
}
