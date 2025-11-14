package model;
/**
 * Represents who occupies a cell or whose turn it is in Tic Tac Toe.
 *
 * We deliberately include a value NONE instead of using null to represent
 * an empty cell or "no winner yet". This avoids NullPointerExceptions
 * and forces callers to handle the "no player" case explicitly.
 */
public enum Player {
  X,      // First player
  O,      // Second player
  NONE;   // Empty cell / no winner

  // Inline dev-note:
  // Using a special enum constant (NONE) instead of null makes the model API
  // easier and safer to use: callers never need to check for null.
}
