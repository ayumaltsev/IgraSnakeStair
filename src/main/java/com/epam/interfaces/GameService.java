package com.epam.interfaces;

public interface GameService {

    boolean isEndOfGame();

    void setEndOfGame(boolean endOfGame);

    void endOfGameSignal();

    void play();

}
