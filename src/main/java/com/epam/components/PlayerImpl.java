package com.epam.components;

import com.epam.interfaces.Board;
import com.epam.interfaces.Cube;
import com.epam.interfaces.Player;


public class PlayerImpl implements Player {

    private static Cube cube = ApplicationContextHolder.getApplicationContext().getBean(Cube.class);
    private static final int cellsCount = ApplicationContextHolder.getApplicationContext().getBean(Board.class).getCellsCount();
    private static final GameServiceImpl gameService = ApplicationContextHolder.getApplicationContext().getBean(GameServiceImpl.class);



    private int currentPosition;
    private String name;


    public PlayerImpl(String name) {
        this.name = name;
        currentPosition = 1;
    }

    public PlayerImpl() {
        currentPosition = 1;
    }


    @Override
    public void takeCube(Cube someCube) {
        cube=someCube;
    }

    private void changePosition(int scoreOfCube) {

        if (!gameService.isEndOfGame()) {

            if (currentPosition + scoreOfCube < cellsCount) {
                currentPosition += scoreOfCube;
                return;
            }

            if (currentPosition + scoreOfCube == cellsCount) {
                currentPosition = cellsCount;
                gameService.endOfGameSignal();

            }

            // If the previous two possibilities are not realized, then currentPosition+scoreOfCube>cellsCount
            //the player does not win
            // and the currentPosition does not change
        }

    }

    @Override
    public void makeMove() {
        int scoreOfCube = cube.toss();
        changePosition(scoreOfCube);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


}
