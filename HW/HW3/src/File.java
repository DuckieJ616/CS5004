/**
 * Leaf node representing a file. Files do not have children.
 */
public class File extends FileSys {

  /**
   * Constructs a file with the given name.
   *
   * @param name file name (non-null)
   */
  public File(String name) {
    super(name);
  }

  /**
   * Prints this file's name with the provided indentation.
   * Files do not include the {@code d } prefix.
   *
   * @param indent the current indentation string
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + getName());
  }
}

