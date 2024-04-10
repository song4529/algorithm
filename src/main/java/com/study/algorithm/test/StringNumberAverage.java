package com.study.algorithm.test;

public class StringNumberAverage {
    public static void main(String[] args) {
        // 주어진 문자열
        String numbersString = "123 456 789 321 654";

        // 문자열을 공백으로 분리하여 문자열 배열로 변환
        String[] numberStrings = numbersString.split(" ");

        // 합계를 저장할 변수
        int sum = 0;

        // 문자열 배열을 반복하여 각 숫자를 정수로 변환하고 합계를 계산
        for (String number : numberStrings) {
            sum += Integer.parseInt(number);
        }

        // 평균 계산
        double average = (double) sum / numberStrings.length;

        // 결과 출력
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}