package com.epam.components;

import com.epam.interfaces.GameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GameServiceImpl implements GameService {

    private boolean endOfGame = false;

    @Value("${app.testFlag}")
    private String testFlag;

    @Override
    public void endOfGameSignal() {

        //Implementation will be given after writing tests

    }

    @Override
    public boolean isEndOfGame() {
        return endOfGame;
    }

    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }

    @Override
    public void play() {
        //Implementation will be given after writing tests
    }
}
