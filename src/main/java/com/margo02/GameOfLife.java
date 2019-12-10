package com.margo02;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */

public class GameOfLife {
    static final int DEAD = 0;
    static final int ALIVE = 1;
    private int width;
    private int height;
    private int [][] board;

    /**
    * Constructs a new Game of Life with the specified dimensions.
    * @param width
    * @param height
    */
    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
         return height;
    }

    /**
     * Displaying the grid
     */
    public void printBoard() {
        System.out.println("---");
        for (int y = 0; y < height; y++)
        {
            String line = "|";
            for (int x = 0; x <width; x++)
            {
                if (board[x][y] == DEAD) {
                    line+=".";
               }else {
                    line+="*";
                }
            }
            line+="|";
            System.out.println(line);
        }
        System.out.println("---\n");

    }

    /**
    * Iterates the game one step forward
    */
    public void iterate(){
        int clone [][]= new int[width][height];

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {
                int liveNeighbors = countLiveNeighbours(x,y);
                if(getState(x,y) == ALIVE){
                    if(liveNeighbors<2){
                        clone[x][y]=DEAD;

                    }else if (liveNeighbors==2 || liveNeighbors==3){
                        clone[x][y]=ALIVE;
                    }else if (liveNeighbors>3){
                        clone[x][y]=DEAD;
                    }
                }else{
                    if(liveNeighbors==3){
                        clone[x][y]=ALIVE;
                    }
                }
            }
        }
        this.board = clone;
    }

    public void setAlive(int x, int y){
        this.setState(x,y,ALIVE);
    }

    public void setDead(int x, int y){
        this.setState(x,y,DEAD);
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }

    public void setState(int x, int y, int state) {
        if (x < 0 || x >= width) {
            return;
        }

        if (y < 0 || y >= height) {
            return;
        }

        this.board[x][y] = state;
    }




    public int countLiveNeighbours(int x, int y){
        int counter = 0;
        counter += getState(x - 1,y - 1);
        counter += getState(x - 1, y);
        counter += getState(x - 1,y + 1);
        counter += getState(x,y + 1);
        counter += getState(x + 1,y + 1);
        counter += getState(x + 1, y);
        counter += getState(x + 1,y - 1);
        counter += getState(x, y- 1);

        return counter;
    }




}
