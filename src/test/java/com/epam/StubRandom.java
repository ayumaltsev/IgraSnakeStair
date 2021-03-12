package com.epam;

import java.util.Random;

public class StubRandom extends Random {

    private int constValue;

    public void setConstValue(int constValue) {
        this.constValue = constValue;
    }

    @Override
    public int nextInt(int number){ //number must be more than constValue
        return constValue;
    }
}
