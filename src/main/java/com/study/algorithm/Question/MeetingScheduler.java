package com.study.algorithm.Question;

import java.util.*;

/* 문제 해결 순서
1. 시작 시간과 끝나는 시간은 독립적으로 존재해도 된다. ex) [[1, 5], [2, 4]] 배열과 [[1, 4], [2, 5]]의 결과는 같다
2. 시작 시간에는 사람이 들어오고, 끝나는 시간에는 사람이 나간다고 생각해서 회의실 개수를 조절하면 된다.
*/
public class MeetingScheduler {
    public int minMeetingRooms(int[][] meetingTimes) {
        int n = meetingTimes.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = meetingTimes[i][0];
            end[i] = meetingTimes[i][1];
        }

        //시작 시간과 끝나는 시간 값을 정렬
        Arrays.sort(start);
        Arrays.sort(end);

        int minRoomCount = 0;
        int currentRoomCount = 0;
        int startTime = 0;
        int endTime = 0;

        // 문제를 간단히 생각하면 startTime에는 사람이 들어오고 endTime에는 사람이 나가는 것으로 생각하면 된다
        while (startTime < n) {
            // startTime < endTime이면 사람이 들어온다 > 필요 회의실 증가 > currentRoomCount++
            if (start[startTime] < end[endTime]) {
                startTime++;
                currentRoomCount++;
                // 현재 회의실의 개수와 최소 회의실의 개수를 비교하여 최대값을 갱신한다
                minRoomCount = Math.max(minRoomCount, currentRoomCount);
            } else {
                // startTime >= endTime이면 사람이 나간다 > 필요 회의실 감소 > currentRoomCount--
                endTime++;
                currentRoomCount--;
            }
        }

        return minRoomCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int constantInteger = scanner.nextInt();
        scanner.nextLine();

        int[][] meetingTimings = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] time = scanner.nextLine().split(" ");
            meetingTimings[i][0] = Integer.parseInt(time[0]);
            meetingTimings[i][1] = Integer.parseInt(time[1]);
        }

        MeetingScheduler meetingScheduler = new MeetingScheduler();
        System.out.println(meetingScheduler.minMeetingRooms(meetingTimings));

        scanner.close();
    }
}


