package model;
/**
 * The model (back end) for a Tic Tac Toe game.
 * <p>
 * This interface is responsible for storing and updating game state:
 * - board contents
 * - whose turn it is
 * - whether the game is over and who (if anyone) has won
 *
 * The controller should use this interface only; it should not know how the
 * model is implemented internally.
 */
public interface TTTModel {

  /**
   * Returns the length of one side of the game board.
   *
   * @return the board size (number of rows and also number of columns).
   * @implNote We assume a square board. If we ever wanted a rectangular
   * board, we could instead expose getRowCount() and getColumnCount().
   */
  int getBoardSize();

  /**
   * Returns which player occupies the given cell.
   *
   * @param row the row index, 0-based (0 is the top row).
   * @param col the column index, 0-based (0 is the leftmost column).
   * @return the {@link Player} occupying this cell:
   *         X, O, or {@code Player.NONE} if the cell is empty.
   * @throws IllegalArgumentException if (row, col) is outside the board.
   *
   * @implNote We deliberately throw IllegalArgumentException for out-of-range
   * coordinates so that controller bugs are caught early. Returning null is
   * avoided on purpose; we use Player.NONE instead to represent an empty cell.
   */
  Player getCellAt(int row, int col) throws IllegalArgumentException;

  /**
   * Returns whose turn it currently is to play.
   *
   * @return the player who should make the next move (X or O).
   *         This method must never return {@code Player.NONE}.
   *
   * @implNote The model owns the turn logic; the controller should always
   * ask the model whose turn it is instead of tracking turns itself.
   */
  Player getCurrentPlayer();

  /**
   * Attempts to place the current player's mark at the given cell.
   * If the move is valid, the model updates the board and advances
   * the turn to the other player.
   *
   * @param row the row index, 0-based
   * @param col the column index, 0-based
   *
   * @throws IllegalArgumentException if (row, col) is outside the board
   *                                  OR if the specified cell is already
   *                                  occupied by X or O.
   * @throws IllegalStateException if the game is already over (win or tie)
   *                               and no further moves are allowed.
   *
   * @implNote The model is responsible for enforcing all game rules:
   * - no moving outside the board
   * - no playing on occupied cells
   * - no moves after the game is over
   * This keeps the controller simpler and makes the model easier to test.
   */
  void playAt(int row, int col)
      throws IllegalArgumentException, IllegalStateException;

  /**
   * Returns whether this game has ended.
   * The game is over if someone has won or if the board is full (a tie).
   *
   * @return true if no further legal moves are possible; false otherwise.
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, if any.
   *
   * @return
   *   <ul>
   *     <li>{@code Player.X} if X has won</li>
   *     <li>{@code Player.O} if O has won</li>
   *     <li>{@code Player.NONE} if there is no winner (either the game
   *         is not over yet, or it ended in a tie)</li>
   *   </ul>
   *
   * @implNote The controller should call {@link #isGameOver()} first;
   * if it is true and this method returns {@code Player.NONE}, the
   * outcome is a tie.
   */
  Player getWinner();

  /**
   * Resets the model to its initial state:
   * - all cells empty
   * - current player restored to the starting player (typically X)
   * - game-over and winner state cleared
   *
   * Board size is not changed by reset.
   */
  void reset();
}
