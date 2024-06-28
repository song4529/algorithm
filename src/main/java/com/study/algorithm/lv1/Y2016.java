package com.study.algorithm.lv1;

class Y2016 {
    public String solution(int a, int b) {
        // 날짜의 요일을 담은 배열 (2016년 1월 1일은 금요일부터 시작)
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        // 각 월의 일수를 담은 배열
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};
        // 총 일 수를 담을 변수 선언
        int answer = 0;

        // a 이전의 총 일 수 더하기
        for (int i = 0; i < a - 1; i++) {
            answer += month[i];
        }

        // 남은 일수 더하기
        answer += b - 1;

        // 7로 나눈 나머지의 인덱스를 가진 요일 반환
        return day[answer % 7];
    }
}