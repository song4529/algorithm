package com.study.algorithm.lv2;

import java.util.*;

class Pos{
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class TripUninhabitedIsland {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> q = new LinkedList<>();
    static boolean[][] visit;
    static int N;
    static int M;
    static char[][] map;

    public int[] solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();

        visit = new boolean[N][M];
        map = new char[N][M];

        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) map[i][j] = maps[i].charAt(j);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 'X' && visit[i][j] != true) {
                    q.add(new Pos(i, j));
                    list.add(bfs(i, j));
                }
            }
        }

        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i);

        Arrays.sort(answer);
        return answer;
    }

    public static int bfs(int x, int y) {

        visit[x][y] = true; // 탐색 시작 구간 방문 표시
        int count = 0;

        while(!q.isEmpty()) {

            Pos pos = q.poll();
            int posX = pos.x;
            int posY = pos.y;

            count += map[posX][posY] - 48;
            for(int i=0; i<4; i++) {
                int disX = posX + dx[i];
                int disY = posY + dy[i];

                if(disX >= N || disX < 0 || disY >= M || disY < 0) continue;

                if(map[disX][disY] != 'X' && visit[disX][disY] != true) {
                    q.add(new Pos(disX, disY));
                    visit[disX][disY] = true;
                }
            }
        }
        return count;
    }
}