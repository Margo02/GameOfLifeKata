# Game Of Life 

*An implementation of Conway's Game of Life in Java.*

## History
The **Game of Life** (often referred to as Conway's Game of Life) 
is a cellular automata devised by mathematician John Conway in 1970.

More information about the Game of Life can be found on
[Wikipedia page](https://en.wikipedia.org/wiki/Conway's_Game_of_Life).

## Ambition

The goals of this project:
- Providing a Javafx graphical interface
- Current generation can be modified using mouse clicks
- Calculating and displaying the next generations

## About
Conway’s Game of Life takes place on a two-dimensional grid of cells. Ideally, the game is carried out on an infinite two-dimensional array of cells. I cannot represent the game board using an infinite array. Instead I use an array of some fixed size. A 2D array represents the grid, with each element of the array representing the content of one cell in the grid. In the game, an initial grid is set up in which each cell is marked as either alive or dead.
After that, the grid evolves through a series of time steps. The contents of the grid at each time step are completely determined by the contents at the previous time step, according to simple rules. Each cell in the grid looks at its eight neighbors (horizontal, vertical, and diagonal) and counts how many of its neighbors are alive. Then the state of the cell in the next step is determined by the rules:
1. Any live cell with fewer than two live neighbours dies, as if by under population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 
Algorithm
1. Make a copy of the original board which will remain unchanged throughout the process.
2. Iterate the cells of the Board one by one.
3. While computing the results of the rules, use the copy board and apply the result in the original board.   
