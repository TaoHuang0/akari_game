package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

import java.util.Random;

public class ControllerImpl implements AlternateMvcController {
  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  public void clickNextPuzzle() {
    if (model.getActivePuzzleIndex() < model.getPuzzleLibrarySize() - 1) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
    } else if (model.getPuzzleLibrarySize() > 0) {
      model.setActivePuzzleIndex(0);
    }
  }

  public void clickPrevPuzzle() {
    if (model.getActivePuzzleIndex() > 0) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
    } else {
      model.setActivePuzzleIndex(model.getPuzzleLibrarySize() - 1);
    }
  }

  public void clickRandPuzzle() {
    Random rand = new Random();
    int random = rand.nextInt(model.getPuzzleLibrarySize());
    if (model.getActivePuzzleIndex() != random) {
      model.setActivePuzzleIndex(random);
    } else {
      clickRandPuzzle();
    }
  }

  public void clickResetPuzzle() {
    model.resetPuzzle();
  }

  public void clickCell(int r, int c) {
    if (model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
      if (model.isLamp(r, c)) {
        model.removeLamp(r, c);
      } else {
        model.addLamp(r, c);
      }
    }
  }

  public boolean isLit(int r, int c) {
    return model.isLit(r, c);
  }

  public boolean isLamp(int r, int c) {
    return model.isLamp(r, c);
  }

  public boolean isClueSatisfied(int r, int c) {
    return model.isClueSatisfied(r, c);
  }

  public boolean isSolved() {
    return model.isSolved();
  }

  public Puzzle getActivePuzzle() {
    return model.getActivePuzzle();
  }

  public void setModel(Model model) {
    this.model = model;
  }

  public int puzzleIndex() {
    return model.getActivePuzzleIndex();
  }

  public int getTotalPuzzles() {
    return model.getPuzzleLibrarySize();
  }
}
