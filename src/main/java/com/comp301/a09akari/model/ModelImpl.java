package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private PuzzleLibrary library;
  private int activePuzzle;
  private boolean[][] lamp;
  private List<ModelObserver> observers;

  public ModelImpl(PuzzleLibrary library) {
    if (library.size() == 0) {
      throw new IllegalArgumentException();
    }
    this.library = library;
    this.activePuzzle = 0;
    this.lamp =
        new boolean[this.library.getPuzzle(0).getHeight()][this.library.getPuzzle(0).getWidth()];
    this.observers = new ArrayList<ModelObserver>();
  }

  public void addLamp(int r, int c) {
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    if (!this.lamp[r][c]) {
      this.lamp[r][c] = true;
    }
  }

  public void removeLamp(int r, int c) {
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    if (this.lamp[r][c]) {
      this.lamp[r][c] = false;
    }
  }

  public boolean isLit(int r, int c) {
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    if (this.lamp[r][c]) {
      return true;
    }
    if (this.library.getPuzzle(this.activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      return true;
    }
    for (int i = c; i >= 0; i--) {
      if (this.library.getPuzzle(this.activePuzzle).getCellType(r, i) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[r][i]) {
        return true;
      }
    }
    for (int i = c; i < this.library.getPuzzle(this.activePuzzle).getWidth(); i++) {
      if (this.library.getPuzzle(this.activePuzzle).getCellType(r, i) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[r][i]) {
        return true;
      }
    }
    for (int i = r; i >= 0; i--) {
      if (this.library.getPuzzle(this.activePuzzle).getCellType(i, c) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[i][c]) {
        return true;
      }
    }
    for (int i = r; i < this.library.getPuzzle(this.activePuzzle).getHeight(); i++) {
      if (this.library.getPuzzle(this.activePuzzle).getCellType(i, c) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[i][c]) {
        return true;
      }
    }
    return false;
  }

  public boolean isLamp(int r, int c) {
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    return this.lamp[r][c];
  }

  public boolean isLampIllegal(int r, int c) {
    System.out.println("row: " + r + " column: " + c);
    System.out.println(this.library.getPuzzle(this.activePuzzle).getHeight());
    System.out.println(this.library.getPuzzle(this.activePuzzle).getWidth());
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      System.out.println("123");
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CORRIDOR) {
      System.out.println("456");
      throw new IllegalArgumentException();
    }
    if (!this.lamp[r][c]) {
      System.out.println("789");
      return false;
    }
    for (int i = c - 1; i >= 0; i--) {
      System.out.println("abc");
      if (this.library.getPuzzle(this.activePuzzle).getCellType(r, i) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[r][i]) {
        return true;
      }
    }
    for (int i = c + 1; i < this.library.getPuzzle(this.activePuzzle).getWidth(); i++) {
      System.out.println("def");
      if (this.library.getPuzzle(this.activePuzzle).getCellType(r, i) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[r][i]) {
        return true;
      }
    }
    for (int i = r - 1; i >= 0; i--) {
      System.out.println("ghi");
      if (this.library.getPuzzle(this.activePuzzle).getCellType(i, c) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[i][c]) {
        return true;
      }
    }
    for (int i = r + 1; i < this.library.getPuzzle(this.activePuzzle).getHeight(); i++) {
      System.out.println("jkl");
      if (this.library.getPuzzle(this.activePuzzle).getCellType(i, c) != CellType.CORRIDOR) {
        break;
      }
      if (this.lamp[i][c]) {
        return true;
      }
    }
    return false;
  }

  public Puzzle getActivePuzzle() {
    return this.library.getPuzzle(this.activePuzzle);
  }

  public int getActivePuzzleIndex() {
    return this.activePuzzle;
  }

  public void setActivePuzzleIndex(int index) {
    if (index < 0 || index >= this.library.size()) {
      throw new IndexOutOfBoundsException();
    }
    this.activePuzzle = index;
  }

  public int getPuzzleLibrarySize() {
    return this.library.size();
  }

  public void resetPuzzle() {
    this.lamp =
        new boolean[this.library.getPuzzle(this.activePuzzle).getHeight()]
            [this.library.getPuzzle(this.activePuzzle).getWidth()];
  }

  public boolean isClueSatisfied(int r, int c) {
    if (r < 0
        || c < 0
        || r >= this.library.getPuzzle(this.activePuzzle).getHeight()
        || c >= this.library.getPuzzle(this.activePuzzle).getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (this.library.getPuzzle(activePuzzle).getCellType(r, c) != CellType.CLUE) {
      throw new IllegalArgumentException();
    }
    int lampCounter = 0;
    if (r - 1 >= 0) {
      if (this.lamp[r - 1][c]) {
        lampCounter++;
      }
    }
    if (r + 1 < this.library.getPuzzle(this.activePuzzle).getHeight()) {
      if (this.lamp[r + 1][c]) {
        lampCounter++;
      }
    }
    if (c - 1 >= 0) {
      if (this.lamp[r][c - 1]) {
        lampCounter++;
      }
    }
    if (c + 1 < this.library.getPuzzle(this.activePuzzle).getWidth()) {
      if (this.lamp[r][c + 1]) {
        lampCounter++;
      }
    }
    if (r - 1 >= 0 && c - 1 >= 0) {
      if (this.lamp[r - 1][c - 1]) {
        lampCounter++;
      }
    }
    if (r + 1 < this.library.getPuzzle(this.activePuzzle).getHeight() && c - 1 >= 0) {
      if (this.lamp[r + 1][c - 1]) {
        lampCounter++;
      }
    }
    if (r + 1 < this.library.getPuzzle(this.activePuzzle).getHeight()
        && c + 1 < this.library.getPuzzle(this.activePuzzle).getWidth()) {
      if (this.lamp[r + 1][c + 1]) {
        lampCounter++;
      }
    }
    if (r - 1 >= 0 && c + 1 < this.library.getPuzzle(this.activePuzzle).getWidth()) {
      if (this.lamp[r - 1][c + 1]) {
        lampCounter++;
      }
    }
    return lampCounter == this.library.getPuzzle(this.activePuzzle).getClue(r, c);
  }

  public boolean isSolved() {
    for (int i = 0; i < this.library.getPuzzle(this.activePuzzle).getHeight(); i++) {
      for (int j = 0; j < this.library.getPuzzle(this.activePuzzle).getWidth(); j++) {
        System.out.println("999");
        if (!isLit(i, j)) {
          System.out.println("a");
          return false;
        }
        if (isLampIllegal(i, j)) {
          System.out.println("b");
          return false;
        }
        if (this.library.getPuzzle(this.activePuzzle).getCellType(i, j) == CellType.CLUE) {
          System.out.println("c");
          if (!isClueSatisfied(i, j)) {
            System.out.println("d");
            return false;
          }
        }
      }
    }
    return true;
  }

  public void addObserver(ModelObserver observer) {
    this.observers.add(observer);
  }

  public void removeObserver(ModelObserver observer) {
    this.observers.remove(observer);
  }
}
