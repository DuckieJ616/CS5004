import java.util.Objects;

public final class ElementNode implements IListOfBooks {
  private final Book first;
  private final IListOfBooks rest;

  public ElementNode(Book first, IListOfBooks rest) {
    this.first = Objects.requireNonNull(first);
    this.rest  = Objects.requireNonNull(rest);
  }

  @Override
  public int size() {
    return 1 + rest.size();
  }

  @Override
  public IListOfBooks add(Book b) {
    return new ElementNode(b, this);
  }

  @Override
  public boolean contains(Book b) {
    return first.equals(b) || rest.contains(b);
  }

  @Override
  public int countByAuthor(String author) {
    int here = first.author().equals(author) ? 1 : 0;
    return here + rest.countByAuthor(author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    buildString(sb);
    sb.append("]");
    return sb.toString();
  }

  private void buildString(StringBuilder sb) {
    sb.append(first.toString());
    if (rest instanceof ElementNode) {
      sb.append(", ");
      ((ElementNode) rest).buildString(sb);
    } else if (rest instanceof EmptyNode) {
    } else {
      String tail = rest.toString();
      if (tail.length() > 2) {
        sb.append(", ").append(tail.substring(1, tail.length() - 1));
      }
    }
  }
}