package com.epam.components;


import com.epam.interfaces.Board;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BoardImpl implements Board {

    @Value("${board.cells.count}")
    private int cellsCount;

    private List figures = new ArrayList();

    @Override
    public int getCellsCount() {
        return cellsCount;
    }

    @Override
    @PostConstruct
    public void init() {
        //Some algorithm, for example stochastic.....
        //After that, the Snakes and Stairs (the location of the figures on the board) will be saved in the corresponding list (figures)
    }
}
