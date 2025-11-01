/**
 * Build a simple file system tree using the Composite pattern.
 * Expected output:
 * d root
 *     d home
 *         d mlmiller
 *             markFileA.txt
 *             markFileB.txt
 */
public class Main {
  public static void main(String[] args) {
    // Build the tree:
    Folder root = new Folder("root");
    Folder home = new Folder("home");
    Folder mlmiller = new Folder("mlmiller");

    File markFileA = new File("markFileA.txt");
    File markFileB = new File("markFileB.txt");

    root.addNode(home);
    home.addNode(mlmiller);
    mlmiller.addNode(markFileA);
    mlmiller.addNode(markFileB);

    // Pretty print the whole tree:
    root.prettyPrintName("");
  }
}

