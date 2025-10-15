public final class EmptyNode implements IListOfBooks {
  @Override
  public int size() {
    return 0;
  }

  @Override
  public IListOfBooks add(Book b) {
    return new ElementNode(b, this);
  }

  @Override
  public boolean contains(Book b) {
    return false;
  }

  @Override
  public int countByAuthor(String author) {
    return 0;
  }

  @Override
  public String toString() {
    return "[]";
  }
}
