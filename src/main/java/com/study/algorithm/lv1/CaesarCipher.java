package com.study.algorithm.lv1;

class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";

        char[] ch = s.toCharArray();

        for(char c : ch) {
            if(c != 32) {
                c += n;
                if((c >= 90 && c < 97) || c >= 122) c -= 26;
                answer += c;
            } else
                answer += " ";
        }

        return answer;
    }
}