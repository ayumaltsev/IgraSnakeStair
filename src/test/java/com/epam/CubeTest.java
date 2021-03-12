package com.epam;

import com.epam.components.CubeImpl;
import com.epam.interfaces.Cube;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CubeTest {

    //cover with tests Cube

    @Test
    public void testToss() {
        StubRandom stubRandom = new StubRandom();
        Cube cube = new CubeImpl(stubRandom);

        for (int i = 0; i <= 5; i++) {
            stubRandom.setConstValue(i);
            assertEquals(i + 1, cube.toss());
        }

    }

}
