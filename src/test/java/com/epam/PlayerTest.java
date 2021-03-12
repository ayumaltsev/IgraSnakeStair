package com.epam;

import com.epam.interfaces.Cube;
import com.epam.interfaces.GameService;
import com.epam.interfaces.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlayerTest {

    private ApplicationContext context;

    private GameService gameService;

    @Autowired
    public PlayerTest(ApplicationContext context, GameService gameService) {
        this.context = context;
        this.gameService = gameService;
    }


    @Test
    public void correctInitialLocationTest() {
        //When the token is placed on the board
        //Then the token is on square 1
        Player player1 = context.getBean(Player.class);
        assertEquals(1, player1.getCurrentPosition());

        //When the token is placed on the board
        //Then the token is on square 1
        Player player2 = context.getBean(Player.class);
        assertEquals(1, player2.getCurrentPosition());
    }

    @Test
    public void makeMoveTest() {

        StubRandom stubRandom = new StubRandom();
        Cube cube = context.getBean(Cube.class);
        cube.setRandom(stubRandom);

        //Given the token is on square 1
        //When the token is moved 3 spaces
        //Then the token is on square 4
        Player player = context.getBean(Player.class);
        player.takeCube(cube);
        stubRandom.setConstValue(2); //in this case Cube toss will result 3
        player.makeMove();
        assertEquals(4, player.getCurrentPosition());

        //Given the token is on square 1
        //When the token is moved 3 spaces
        //And then it is moved 4 spaces
        //Then the token is on square 8
        Player player2 = context.getBean(Player.class);
        player2.takeCube(cube);
        stubRandom.setConstValue(2); //in this case Cube toss will result 3
        player2.makeMove();
        stubRandom.setConstValue(3); //in this case Cube toss will result 4
        player2.makeMove();
        assertEquals(8, player2.getCurrentPosition());

    }


    @Test
    public void playerCanWinGameTest() {
        StubRandom stubRandom = new StubRandom();
        Cube cube = context.getBean(Cube.class);
        cube.setRandom(stubRandom);

        //Given the token is on square 97
        //When the token is moved 3 spaces
        //Then the token is on square 100
        //And the player has won the game
        Player player = context.getBean(Player.class);
        player.setCurrentPosition(97);
        stubRandom.setConstValue(2); //in this case Cube toss will result 3
        player.makeMove();
        assertEquals(100, player.getCurrentPosition());
        assertTrue(gameService.isEndOfGame());


        gameService.setEndOfGame(false);
        //Given the token is on square 97
        //When the token is moved 4 spaces
        //Then the token is on square 97
        //And the player has not won the game
        Player player2 = context.getBean(Player.class);
        player2.setCurrentPosition(97);
        stubRandom.setConstValue(3); //in this case cube will result 4
        player.makeMove();
        assertFalse(gameService.isEndOfGame());


    }


}
