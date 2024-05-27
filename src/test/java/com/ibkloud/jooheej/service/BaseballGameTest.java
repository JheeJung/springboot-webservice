package com.ibkloud.jooheej.service;


import com.ibkloud.jooheej.domain.BaseballGameItem;
import com.ibkloud.jooheej.service.BaseballGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseballGameTest {

    @Autowired
    BaseballGame baseballGame;

    @Test
    public void baseballGame_return() throws Exception {

        String given = "123";
        String input = "321";

        BaseballGameItem baseballGameItem = new BaseballGameItem(given, input);

        assertThat(baseballGame.getScore(baseballGameItem.getGiven(), baseballGameItem.getInput())).isEqualTo("1S2B");

    }

}
