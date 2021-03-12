package com.epam.interfaces;

public interface Player {

    void takeCube(Cube cube);

    void makeMove();

    int getCurrentPosition();

    void setCurrentPosition(int position);


    void setName(String name);

    String getName();


}