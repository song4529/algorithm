package com.study.algorithm.lv1;


class PackOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        for(String str : goal){
            if(i < cards1.length && str.equals(cards1[i])) i++;
            else if(j < cards2.length && str.equals(cards2[j])) j++;
            else return "No";
        }
        return "Yes";
    }
}