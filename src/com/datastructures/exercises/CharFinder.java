package com.datastructures.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    // Map is an interface with several implementations such as HashMap.
    // "a green apple"
    public Character firstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        if (str.length() == 0) return null;
        if (str.length() == 1) return str.charAt(0);
        var chars = str.toCharArray();

        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }

    public Character firstRepeatedCharacter(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        CharFinder charFinder = new CharFinder();
        char ch = charFinder.firstNonRepeatingChar("abcaadbcfgomlp");
        System.out.println(ch);
        ch = charFinder.firstNonRepeatingChar("a green apple");
        System.out.println(ch);

        ch = charFinder.firstRepeatedCharacter("abclskdmabc");
        System.out.println(ch);
    }
}
