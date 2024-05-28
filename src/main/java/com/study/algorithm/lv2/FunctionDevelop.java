package com.study.algorithm.lv2;


import java.util.*;

class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int level = 1;
        int count = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            if(progresses[i] + speeds[i] * level < 100) {
                if(count > 0) list.add(count);
                count = 0;

                while(progresses[i] + speeds[i] * level < 100) {
                    level++;
                }
            }
            if(progresses[i] + speeds[i] * level >= 100) count++;
        }

        list.add(count);

        int[] answer = new int[list.size()];

        for(int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}