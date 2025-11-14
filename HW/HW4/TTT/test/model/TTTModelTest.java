package model;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Black-box tests for the TTTModel interface.
 *
 * NOTE: These tests assume there will be a concrete implementation
 * class called BasicTTTModel that implements TTTModel.
 * For HW4 we only design the tests; they may not compile or run yet.
 */
public class TTTModelTest {

  // Helper method to create a fresh 3x3 game.
  private TTTModel newGame() {
    // This class does not exist yet; it will be implemented in a later HW.
    return new BasicTTTModel(3);
  }

  // ---- getBoardSize() ----

  @Test
  public void testGetBoardSize() {
    TTTModel model = newGame();
    assertEquals(3, model.getBoardSize());        // normal case
    assertTrue(model.getBoardSize() > 0);         // size is always positive
  }

  // ---- getCellAt(row, col) ----

  @Test(expected = IllegalArgumentException.class)
  public void testGetCellAtOutOfBoundsThrows() {
    TTTModel model = newGame();
    model.getCellAt(-1, 0);                       // invalid row
  }

  @Test
  public void testGetCellAtInitiallyEmpty() {
    TTTModel model = newGame();
    assertEquals(Player.NONE, model.getCellAt(0, 0));  // empty at start
  }

  // ---- getCurrentPlayer() ----

  @Test
  public void testGetCurrentPlayerAlternates() {
    TTTModel model = newGame();
    Player first = model.getCurrentPlayer();
    assertTrue(first == Player.X || first == Player.O);     // valid player

    model.playAt(0, 0);
    assertNotEquals(first, model.getCurrentPlayer());       // turn changed
  }

  // ---- playAt(row, col) ----

  @Test(expected = IllegalArgumentException.class)
  public void testPlayAtOnOccupiedCellThrows() {
    TTTModel model = newGame();
    model.playAt(0, 0);
    model.playAt(0, 0);                                     // second time = error
  }

  @Test(expected = IllegalStateException.class)
  public void testPlayAtAfterGameOverThrows() {
    TTTModel model = newGame();

    // Force a quick win for X: (0,0), (1,0), (0,1), (1,1), (0,2)
    model.playAt(0, 0);  // X
    model.playAt(1, 0);  // O
    model.playAt(0, 1);  // X
    model.playAt(1, 1);  // O
    model.playAt(0, 2);  // X wins

    assertTrue(model.isGameOver());
    model.playAt(2, 2);  // any further move should throw IllegalStateException
  }

  // ---- isGameOver() ----

  @Test
  public void testIsGameOverFalseAtStart() {
    TTTModel model = newGame();
    assertFalse(model.isGameOver());                          // not over initially
  }

  @Test
  public void testIsGameOverTrueOnWin() {
    TTTModel model = newGame();
    model.playAt(0, 0);
    model.playAt(1, 0);
    model.playAt(0, 1);
    model.playAt(1, 1);
    model.playAt(0, 2);                                       // X wins
    assertTrue(model.isGameOver());
  }

  // ---- getWinner() ----

  @Test
  public void testGetWinnerNoneBeforeGameOver() {
    TTTModel model = newGame();
    model.playAt(0, 0);
    model.playAt(1, 1);
    assertEquals(Player.NONE, model.getWinner());             // game not over yet
  }

  @Test
  public void testGetWinnerXWins() {
    TTTModel model = newGame();
    model.playAt(0, 0);
    model.playAt(1, 0);
    model.playAt(0, 1);
    model.playAt(1, 1);
    model.playAt(0, 2);                                       // X wins
    assertEquals(Player.X, model.getWinner());
  }

  // ---- reset() ----

  @Test
  public void testResetClearsBoard() {
    TTTModel model = newGame();
    model.playAt(0, 0);
    model.reset();
    assertEquals(Player.NONE, model.getCellAt(0, 0));         // cell cleared
    assertFalse(model.isGameOver());                          // game not over
  }

  @Test
  public void testResetRestoresFirstPlayer() {
    TTTModel model = newGame();
    Player first = model.getCurrentPlayer();
    model.playAt(0, 0);
    assertNotEquals(first, model.getCurrentPlayer());         // turn changed

    model.reset();
    assertEquals(first, model.getCurrentPlayer());            // back to first player
  }
}

