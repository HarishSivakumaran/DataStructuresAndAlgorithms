package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gcd {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nS = bufferedReader.readLine().replaceAll("\\s+", " ").split(" ");
        int[] n = Arrays.stream(nS).mapToInt(Integer::parseInt).toArray();
        while (n[1] != 0) {
            if (n[0] > n[1]) {
                n[0] = n[0] % n[1];
                int temp = n[0];
                n[0] = n[1];
                n[1] = temp;
            } else {
                int temp = n[0];
                n[0] = n[1];
                n[1] = temp;
            }
        }
        System.out.println(n[0]);


    }
}