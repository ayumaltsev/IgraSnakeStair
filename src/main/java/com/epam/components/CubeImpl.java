package com.epam.components;

import com.epam.interfaces.Cube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CubeImpl implements Cube {


    private Random random;

    //We may not write this annotation. But the code becomes more readable with it.
    @Autowired
    public CubeImpl(Random random) {

        this.random = random;
    }

    @Override
    public int toss() {
        return random.nextInt(6) + 1;
    }

    @Override
    public Random getRandom() {
        return random;
    }

    @Override
    public void setRandom(Random random) {
        this.random = random;
    }
}
