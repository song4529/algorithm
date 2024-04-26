package com.study.algorithm.test;

import java.util.*;

public class NumberSorting {
    public static void main(String[] args) {
        String[] array = {"1", "5", "3", "x", "10"};

        List<Integer> numbers = new ArrayList<>();

        // 숫자만 추출하여 리스트에 추가
        for (String element : array) {
            if (isNumeric(element)) {
                int number = Integer.parseInt(element);
                numbers.add(number);
            }
        }

        // 숫자를 정렬
        Collections.sort(numbers);

        // 결과 출력
        System.out.println("정렬된 숫자:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    // 숫자인지 확인하는 메서드
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}