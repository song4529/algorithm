package com.study.algorithm.Question;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // meetingTimings 배열의 크기를 입력 받음
        int n = scanner.nextInt();
        scanner.nextLine(); // 다음 줄로 넘어가기 위해 빈 줄 읽기

        // meetingTimings 배열 생성
        int[][] meetingTimings = new int[n][2];

        // meetingTimings 입력 받기
        for (int i = 0; i < n; i++) {
            String[] timings = scanner.nextLine().split(" ");
            meetingTimings[i][0] = Integer.parseInt(timings[0]);
            meetingTimings[i][1] = Integer.parseInt(timings[1]);
        }

        // 입력 받은 데이터 확인 (옵션)
        for (int i = 0; i < n; i++) {
            System.out.println("[" + meetingTimings[i][0] + ", " + meetingTimings[i][1] + "]");
        }

        scanner.close();
    }
}
