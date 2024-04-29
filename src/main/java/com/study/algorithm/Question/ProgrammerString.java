package com.study.algorithm.Question;

/* 문제 해결 순서
1. programmer의 문자가 순서 상관없이 모두 나오는 순간 앞쪽 구역이 끝이 난다.
2. 뒤에서부터 programmer의 문자가 순서 상관없이 모두 나오는 순간 뒤쪽 구역이 끝이 난다.
3. 앞쪽 구역 끝의 인덱스와 뒤쪽 구역 앞의 인덱스 값의 차이에서 1을 빼주면 남은 구역의 길이를 알 수 있다.
*/

import java.util.Scanner;

public class ProgrammerString {
    public int midIndexCount(String s) {
        // 'programmer' 에서 p*1 r*3 o*1 g*1 a*1 m*2 e*1
        //앞쪽 구역
        int[] minTargetCounts = {1, 3, 1, 1, 1, 2, 1};
        //뒤쪽 구역
        int[] maxTargetCounts = {1, 3, 1, 1, 1, 2, 1};

        int n = s.length();
        int min = 0;
        int max = n;

        //처음에 programmer 문자가 나온위치 중에서 제일 큰 값의 인덱스 확인
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = "progame".indexOf(ch);
            if (index != -1) {
                minTargetCounts[index]--;
                if (minTargetCounts[index] == 0) {
                    min = Math.max(min, i);
                }
            }
        }

        //뒤에서부터 programmer 문자가 나온위치 중에서 제일 작은 값의 인덱스 확인
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int index = "progame".indexOf(ch);
            if (index != -1) {
                maxTargetCounts[index]--;
                if (maxTargetCounts[index] == 0) {
                    max = Math.min(max, i);
                }
            }
        }

        //programmer programmer인 경우 min은 첫번째 programme'r' 인덱스, max는 두번째 'p'rogrammer 인덱스이므로 1을 빼줘야한다
        return max - min - 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ProgrammerString programmerString = new ProgrammerString();
        System.out.println(programmerString.midIndexCount(input));

        scanner.close();
    }
}
