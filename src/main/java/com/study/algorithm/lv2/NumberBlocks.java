package com.study.algorithm.lv2;


import java.util.*;
class NumberBlocks {
    public List<Integer> solution(long begin, long end) {
        int[] answer ={};

        List<Integer> board = new ArrayList<>();

        int length=(int)(end-begin+1);
        answer= new int[length];

        for(long i=begin;i<=end;i++){
            if(i==1){
                board.add(0);
                continue;
            }
            else{
                board.add((int)block(i));
            }
            //에라토네스의 체 응용
        }

        return board;
    }

    public long block(long n){
        for(long i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i>10000000){
                    continue;
                }
                return n/i;
            }
        }
        return 1;
    }
}