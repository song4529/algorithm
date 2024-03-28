package com.study.algorithm;
import java.util.Random;

public class RandomPick {
    public static void main(String[] args) {
        int numSimulations = 1000000;
        int successes = countSuccesses(numSimulations);
        System.out.println("성공한 횟수 : " + successes);
    }

    public static boolean simulateTrial() {
        int countA = 0;
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            String result = getRandomResult(random);
            if (result.equals("a")) {
                countA++;
                if (countA >= 38) {

                    return true; // 'a'를 30번 이상 획득하여 종료
                }
            }
        }
        return false; // 'a'를 30번 이상 획득하지 못하고 종료
    }

    public static int countSuccesses(int numSimulations) {
        int successCount = 0;
        for (int i = 0; i < numSimulations; i++) {
            if (simulateTrial()) {
                successCount++;
            }
        }
        return successCount;
    }

    public static String getRandomResult(Random random) {
        String[] options = {"a", "b", "c"};
        int index = random.nextInt(options.length);
        return options[index];
    }
}
