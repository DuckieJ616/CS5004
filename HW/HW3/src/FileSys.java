import java.util.Objects;

/**
 * Abstract base class for nodes in a pretend file system tree (Composite pattern).
 * <p>
 * Each node has a name and supports a pretty-print method that renders the
 * node (and, for folders, its subtree) with a provided indentation prefix.
 */
public abstract class FileSys {
  /** The display name of this file or folder. */
  private final String name;

  /**
   * Creates a new file-system node with the given name.
   *
   * @param name non-null name of the file or folder to display
   * @throws NullPointerException if {@code name} is null
   */
  public FileSys(String name) {
    this.name = Objects.requireNonNull(name, "name must not be null");
  }

  /**
   * Returns the display name of this node.
   *
   * @return the node name (never null)
   */
  public String getName() {
    return name;
  }

  /**
   * Pretty-prints this node. Implementations should print one line for this node,
   * prefixed by the provided indentation; folders should then pretty-print their children
   * with additional indentation.
   *
   * @param indent a string used as the current indentation (e.g., "    ")
   */
  public abstract void prettyPrintName(String indent);
}

