package org.eyebora;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] baseNum = new int[3];
        int[] inputNum = new int[3];
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<inputNum.length; i++) {
            inputNum[i] = scan.nextInt();
        }

        getBaseNum(baseNum);

        playGame(baseNum, inputNum);

    }


    public static void getBaseNum(int[] baseNum) {

        for(int i=0; i<baseNum.length; i++) {
            baseNum[i] = (int) (Math.random() * 9 + 1);

            for(int j=0; j< i; j++) {
                if(baseNum[i] == baseNum[j]) {
                    i--;
                    break;
                }
            }
        }

    }

    public static void playGame(int[] baseNum, int[] inputNum) {
        int strike = 0, ball = 0;

        for(int i=0; i<baseNum.length; i++) {
            for(int j=0; j<inputNum.length; j++) {

                if(baseNum[i] == inputNum[j] && i == j) {
                    strike++;
                } else if(baseNum[i] == inputNum[j] && i != j) {
                    ball++;
                }

            }
        }

        System.out.println( strike + "S  " + ball + "B");

    }

}