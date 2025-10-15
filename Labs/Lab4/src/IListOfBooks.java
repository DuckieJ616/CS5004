public interface IListOfBooks {
  int size();
  IListOfBooks add(Book b);
  boolean contains(Book b);
  int countByAuthor(String author);
  @Override
  String toString();
}
