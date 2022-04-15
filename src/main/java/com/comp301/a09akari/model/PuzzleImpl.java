package com.comp301.a09akari.model;

import javafx.scene.control.Cell;

public class PuzzleImpl implements Puzzle {
  private int[][] board;
  private CellType[][] cell;
  private int[][] clue;

  public PuzzleImpl(int[][] board) {
    this.board = board;
  }

  public int getWidth() {
    return this.board[0].length;
  }

  public int getHeight() {
    return this.board.length;
  }

  public CellType getCellType(int r, int c) {
    return this.cell[r][c];
  }

  public int getClue(int r, int c) {
    return this.clue[r][c];
  }
}
