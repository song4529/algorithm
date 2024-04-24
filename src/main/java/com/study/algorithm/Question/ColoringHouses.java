package com.study.algorithm.Question;

/* 문제 해결 순서
1. 3가지 색을 사용할 수 있으며, 1번째에서 한 가지 색을 사용하면 그 뒤로는 다른 2가지 색상만을 사용할 수 있으므로 3 * 2 * 2 * 2 * 2... 으로 인접할 경우의 수를 알 수 있다.
2. 인접한 색상이 달라도 대칭된 곳에서의 색상이 같으면 안되므로 이때 칠할 수 있는 색상의 경우의 수를 구해야 한다.
3. 2번의 경우 짝수인 경우는 n을 반으로 나눈 다음 1번과 같은 방식으로 구할 수 있으며, 홀수인 경우 n을 반을 나눈 값에서 반올림을 한 값으로 1번과 같은 방식으로 구하면 된다.
4. 1번에서 2번의 경우의 수를 뺸 값이 결과값이다.
*/

import java.util.Scanner;

public class ColoringHouses {
    public int CountEvent(int n) {
        //3가지 색을 칠할 수 있으며, 인접하거나 대칭되는 위치의 색은 달라야한다.

        int result = 0;

        int countAdjacent = 3;

        // 인접한 색만 다른 경우
        for(int i = 0; i < n - 1; i++) {
            countAdjacent *= 2;
        }

        int countOverlap = 3;

        //홀수인 경우 짝수인 경우 구분
        int m = 0;
        if(n % 2 == 0) {
            m = n/2;
        } else {
            m = n/2 + 1;
        }

        // 대칭되는 색이 같아 중복된 경우 제외
        if(n > 2) {
            for(int j = 0; j < m - 1; j++) {
                countOverlap *= 2;
            }
            result = countAdjacent - countOverlap;
        } else {
            result = countAdjacent;
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ColoringHouses coloringHouses = new ColoringHouses();
        System.out.println(coloringHouses.CountEvent(n));

        scanner.close();
    }
}
