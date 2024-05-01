package com.study.algorithm.Question;

/* 문제 해결 순서
1. 가장 작은 정사각형이 되기 위해서는 해당 좌표의 오른쪽, 아래, 대각선의 좌표값이 1이어야한다.
2. 그 다음으로 큰 정사각형이 되기 위해서는 위의 작은 정사각형의 오른쪽, 아래, 대각선의 좌표에서 1번과 같은 경우여야 한다.
3. 재귀를 통해서 정사각형이 성립되지 않을 경우에 마지막 행해진 과정에서의 최솟값을 가지고 한 변의 길이를 뽑아낼 수 있다.
4. 입력받은 값을 이차원 배열에 넣은 다음 (0,0)부터 위의 재귀 함수를 for문을 통해 적용 시켜서 정사각형 중 가장 긴 변의 길이를 도출해낸다.
*/

import java.util.Scanner;

public class ProductDefects {
    public int maximalSquare(int[][] sampleCoordinate) {
        if (sampleCoordinate == null || sampleCoordinate.length == 0 || sampleCoordinate[0].length == 0) {
            return 0;
        }

        int maxSide = 0;
        int rows = sampleCoordinate.length;
        int cols = sampleCoordinate[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sampleCoordinate[i][j] == 1) {
                    maxSide = Math.max(maxSide, exploreSquare(i, j, sampleCoordinate));
                }
            }
        }

        return maxSide;
    }

    private int exploreSquare(int i, int j, int[][] cor) {
        if (i >= cor.length || j >= cor[0].length || cor[i][j] == 0) {
            return 0;
        }

        // 현재 좌표를 기준으로 정사각형의 한 변의 길이를 찾기 위해 재귀적으로 탐색
        int right = exploreSquare(i, j + 1, cor);
        int down = exploreSquare(i + 1, j, cor);
        int diagonal = exploreSquare(i + 1, j + 1, cor);

        // 주어진 좌표를 시작으로 가능한 한 변의 길이를 반환
        return 1 + Math.min(Math.min(right, down), diagonal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sampleColumnSize = scanner.nextInt();

        int sampleRowSize = scanner.nextInt();

        scanner.nextLine();

        int sampleCoordinate[][] = new int[sampleColumnSize][sampleRowSize];

        for(int i = 0; i < sampleRowSize; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            for(int j = 0; j < sampleColumnSize; j++) {
                sampleCoordinate[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        ProductDefects productDefects = new ProductDefects();
        System.out.println(productDefects.maximalSquare(sampleCoordinate));
    }
}
