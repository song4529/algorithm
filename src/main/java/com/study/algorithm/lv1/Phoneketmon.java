package com.study.algorithm.lv1;

import java.util.*;

public class Phoneketmon {
    public int solution(int[] nums) {
        HashSet<Integer> numsSorted = new HashSet<>();

        for (int num : nums) {
            numsSorted.add(num);
        }

        if (numsSorted.size() > nums.length / 2) return nums.length / 2;
        else return numsSorted.size();
    }
}