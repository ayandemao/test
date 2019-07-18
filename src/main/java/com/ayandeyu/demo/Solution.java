package com.ayandeyu.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    public static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }


    public int romanToInt(String s) {


        char[] c = s.toCharArray();
        int i = 0;
        int r = 0;
        while (i < c.length) {
            if (i == c.length - 1) {
                r += map.get(c[i]);
            } else if(map.get(c[i]) < map.get(c[i+1])) {
                r -= map.get(c[i]);
            } else {
                r += map.get(c[i]);
            }
            i++;
        }
        return r;
    }

    public String longestCommonPrefix(String[] strs) {
        Stack<Character> stack = new Stack<>();
        if (strs == null|| strs.length == 0) {
            return "";
        }
        String ret = "";
        int k = 0;
        while (true) {
            if (strs[0].length() < k + 1) {
                return ret;
            }
            char c = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < k + 1 || strs[i].charAt(k) != c) {
                    return ret;
                }
            }
            ret += c;
            k++;
        }
    }

    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.pop();
                switch (c[i]) {
                    case ')':
                        if (c1 != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (c1 != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (c1 != '[') {
                        return false;
                    }
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}"));

    }
}