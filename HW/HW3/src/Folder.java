import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite node representing a folder (directory) that can contain children
 * (both files and folders).
 */
public class Folder extends FileSys {
  /** Children of this folder, in insertion order. */
  private final List<FileSys> children = new ArrayList<>();

  /**
   * Constructs a folder with the given name.
   *
   * @param name folder name (non-null)
   */
  public Folder(String name) {
    super(name);
  }

  /**
   * Adds a child (file or folder) to this folder.
   *
   * @param child the node to add (non-null)
   * @throws NullPointerException if {@code child} is null
   */
  public void addNode(FileSys child) {
    if (child == null) {
      throw new NullPointerException("child must not be null");
    }
    children.add(child);
  }

  /**
   * Returns an unmodifiable view of this folder's children.
   *
   * @return the children list (never null)
   */
  public List<FileSys> getChildren() {
    return Collections.unmodifiableList(children);
  }

  /**
   * Prints this folder with a {@code d } prefix and then recursively prints
   * all children, each indented by four more spaces.
   *
   * @param indent the current indentation string
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + "d " + getName());
    String childIndent = indent + "    ";
    for (FileSys child : children) {
      child.prettyPrintName(childIndent);
    }
  }
}

