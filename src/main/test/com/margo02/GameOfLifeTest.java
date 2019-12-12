package com.margo02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private GameOfLife gameOfLife;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gameOfLife = new GameOfLife(8,6);
    }

    @Test
    public void testAllDead(){
        gameOfLife.iterate();
        for (int x = 0; x < gameOfLife.getWidth(); x++){
            for (int y = 0; y < gameOfLife.getHeight(); y++){
                assertEquals(gameOfLife.DEAD, gameOfLife.getState(x, y));
            }
        }
    }

    @Test
    public void foundsNoLivingNeighboursInAnEmptyGrid() {

        int neighboursCount = gameOfLife.countLiveNeighbours(1,4);
        assertEquals(0, neighboursCount);
    }

    @Test
    public void foundsOneLivingNeighbour() {

        gameOfLife.setAlive(0,3);

        int neighboursCount = gameOfLife.countLiveNeighbours(1,4);
        assertEquals(1, neighboursCount);
    }

    @Test
    public void foundsTwoLivingNeighbours() {

        gameOfLife.setAlive(0, 3);
        gameOfLife.setAlive(0, 4);

        int neighboursCount = gameOfLife.countLiveNeighbours(1, 4);

        assertEquals(2,neighboursCount);
    }

    @Test
    public void foundsThreeLivingNeighbours() {

        gameOfLife.setAlive(0, 3);
        gameOfLife.setAlive(0, 4);
        gameOfLife.setAlive(0, 5);

        int neighboursCount = gameOfLife.countLiveNeighbours(1, 4);

        assertEquals(3,neighboursCount);
    }

    @Test
    public void aCellWithFewerThanTwoNeighboursDies() {

        gameOfLife.setAlive(0, 0);
        gameOfLife.setAlive(0, 1);

        gameOfLife.iterate();

        //assertThat(gameOfLife.setDead(0,0);).isTrue();
        assertEquals(gameOfLife.DEAD,gameOfLife.getState(0,0));
    }

    @Test
    public void aCellWithMoreThanThreeNeighboursDies() {

        gameOfLife.setAlive(1, 4);
        gameOfLife.setAlive(0, 3);
        gameOfLife.setAlive(0, 4);
        gameOfLife.setAlive(0, 5);
        gameOfLife.setAlive(1, 5);

        gameOfLife.iterate();

        assertEquals(gameOfLife.DEAD,gameOfLife.getState(1,4));

    }

    @Test
    public void aDeadCellWithThreeNeighboursGetsAlive() {

        gameOfLife.setAlive(0, 3);
        gameOfLife.setAlive(0, 4);
        gameOfLife.setAlive(0, 5);

        gameOfLife.iterate();

        assertEquals(gameOfLife.ALIVE,gameOfLife.getState(1,4));

    }
}