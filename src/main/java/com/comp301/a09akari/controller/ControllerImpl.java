package com.comp301.a09akari.controller;

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
    } else {
      System.out.println("This is the last puzzle");
    }
  }

  public void clickPrevPuzzle() {
    if (model.getActivePuzzleIndex() > 0) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
    } else {
      System.out.println("This is the first puzzle");
    }
  }

  public void clickRandPuzzle() {
    Random rand = new Random();
    int random = rand.nextInt(model.getPuzzleLibrarySize() - 1);
    if(model.getActivePuzzleIndex() != random) {
      model.setActivePuzzleIndex(random);
    } else {
      clickRandPuzzle();
    }
  }

  public void clickResetPuzzle() {
    model.resetPuzzle();
  }

  public void clickCell(int r, int c) {
    model.addLamp(r, c);
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
}
