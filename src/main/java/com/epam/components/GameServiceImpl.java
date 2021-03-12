package com.epam.components;

import com.epam.interfaces.GameService;
import com.epam.interfaces.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GameServiceImpl implements GameService {

    private boolean endOfGame = false;

    @Value("${app.testFlag}")
    private String testFlag;

    @Override
    public void endOfGameSignal() {
        endOfGame = true;

        System.out.println("End of game");
        if (!Boolean.valueOf(testFlag)) {
            System.exit(0);
        }

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
        //There is no need to implement this method here.
        // However, here, just for example, the implementation of the computer game with itself is made to
        // visually (primitive console output) observe the process of moving the token.

        //We believe that there are no Snakes and Stairs on the board


        final Player firstPlayer = ApplicationContextHolder.getApplicationContext().getBean(Player.class);
        firstPlayer.setName("First Player");
        final Player secondPlayer = ApplicationContextHolder.getApplicationContext().getBean(Player.class);
        secondPlayer.setName("Second Player");

        System.out.println("");
        System.out.println("*****************GAME STARTING******************************");

        System.out.println("First player position: " + firstPlayer.getCurrentPosition());
        System.out.println("Second player position: " + secondPlayer.getCurrentPosition());
        System.out.println("##############################");
        System.out.println("");

        while (!endOfGame) {

            System.out.println("First Player moves...");
            firstPlayer.makeMove();
            System.out.println("First player position: " + firstPlayer.getCurrentPosition());

            System.out.println("Second Player moves... ");
            secondPlayer.makeMove();
            System.out.println("Second player position: " + secondPlayer.getCurrentPosition());

            System.out.println("##############################");
            System.out.println("");

        }

        System.out.println("End of game");

    }
}