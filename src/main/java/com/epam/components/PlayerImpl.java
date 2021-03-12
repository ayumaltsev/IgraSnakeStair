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
    }

    public PlayerImpl() {

    }


    @Override
    public void takeCube(Cube someCube) {
        cube = someCube;
    }


    // changePosition() and  makeMove() are key methods that implement the business logic of the class.
    // Their implementation will be given only after writing tests.

    private void changePosition(int scoreOfCube) {

        // Implementation will be given after writing tests

    }

    @Override
    public void makeMove() {

        // Implementation will be given after writing tests
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
