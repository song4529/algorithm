package com.study.algorithm.lv1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> ingredientList = new ArrayList<Integer>(Arrays.asList(ingredient));

        for (int i = 0 ; i < ingredientList.size() && ingredientList.size() > 3 ; i++ ) {
            if (ingredientList.get(i) == 1) {
                if (i > 2) {
                    if (ingredientList.get(i-1) == 3 &&
                            ingredientList.get(i-2) == 2 &&
                            ingredientList.get(i-3) == 1) {
                        ingredientList.remove(i);
                        ingredientList.remove(i-1);
                        ingredientList.remove(i-2);
                        ingredientList.remove(i-3);
                        answer++;
                        i -= 4;
                    }
                }
            }
        }
        return answer;
    }
}