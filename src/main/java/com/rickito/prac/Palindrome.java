package com.rickito.prac;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public static Set<CharSequence> printAllPalindromes(String input) {
        if (input.length() <= 2) {
            return Collections.emptySet();
        }
        Set<CharSequence> out = new HashSet<CharSequence>();
        int length = input.length();
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
                if (input.charAt(j) == input.charAt(k)) {
                    out.add(input.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        return out;
    }

    public static void main(String args[])
    {
        Set<CharSequence> s = printAllPalindromes("abaccdc");
        for(CharSequence c: s)
        {
            System.out.println(c);
        }
    }
}
