package coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MaxBallooPoints {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] balloons = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+", " ").split(" ")).
                mapToInt(Integer::parseInt).toArray();

        System.out.println(getMaxCount(balloons));
    }

    public static int getMaxCount(int[] nums) {

        int[][] matrix = new int[nums.length][nums.length];
        for (int length = 1; length <= nums.length; length++) {
            for (int startIndex = 0; startIndex <= nums.length - length; startIndex++) {
                int endIndex = startIndex + length - 1;
                for (int lastBallonToBeBurst = startIndex; lastBallonToBeBurst <= endIndex; lastBallonToBeBurst++) {

                    int leftNum = 1;
                    int rightNum = 1;
                    if (startIndex != 0) {
                        leftNum = nums[startIndex - 1];

                    }
                    if (endIndex != nums.length - 1) {
                        rightNum = nums[endIndex + 1];
                    }
                    int before = 0;
                    int after = 0;

                    if (startIndex != lastBallonToBeBurst) {
                        before = matrix[startIndex][lastBallonToBeBurst-1];
                    }
                    if (lastBallonToBeBurst != endIndex) {
                        after = matrix[lastBallonToBeBurst + 1][endIndex];
                    }

                    matrix[startIndex][endIndex] = Math.max((leftNum * nums[lastBallonToBeBurst] * rightNum) + after + before, matrix[startIndex][endIndex]);
                }
            }
        }

        return matrix[0][nums.length - 1];

    }
}
