package com.ibkloud.jooheej.service;

import org.springframework.stereotype.Service;

@Service
public class BaseballGame {

    public String getScore(String given, String input) {

        int strike = 0, ball = 0;
        String result;

        for(int i=0; i<given.length(); i++) {
            for(int j=0; j<input.length(); j++) {

                if(given.charAt(i) == input.charAt(j) && i == j) {
                    strike++;
                } else if(given.charAt(i) == input.charAt(j) && i != j) {
                    ball++;
                }

            }
        }

        result = strike + ball == 0 ? "(null)" : strike + "S" + ball + "B";

//        return "(INPUT) Given " + given + ", Input " + input + " -> (ONTPUT)" + result;
        return result;
    }

}
