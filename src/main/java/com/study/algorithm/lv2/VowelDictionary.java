package com.study.algorithm.lv2;

import java.util.*;

class VowelDictionary {
    int size;
    Set<String> set;
    String[] arr = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        set = new TreeSet();

        // 사전 만들기
        for (int i = 0; i < 5; ++i)
            makeWord(arr[i], 1);

        // 사전의 앞에서부터 원하는 단어 찾기
        int count = 0;
        for (String s : set) {
            count++;
            if (s.equals(word))
                return count;
        }
        return answer;
    }

    public void makeWord(String base, int depth) {
        set.add(base);
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 5; ++i)
            makeWord(base + arr[i], depth + 1);
    }
}