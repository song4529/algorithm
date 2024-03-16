package com.study.algorithm.lv1;

import java.util.*;

class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playersMemory = new HashMap<String, Integer>();

        for(int i = 0; i<players.length; i++) {
            playersMemory.put(players[i], i);
        }

        for(int i = 0; i<callings.length; i++) {
            int rank = playersMemory.get(callings[i]);
            String name = players[rank-1];
            players[rank-1] = players[rank];
            players[rank] = name;
            playersMemory.put(players[rank-1], rank-1);
            playersMemory.put(players[rank], rank);
        }
        return players;
    }
}