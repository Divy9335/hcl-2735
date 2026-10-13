package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemClasses;

public abstract class BooksInfo {
    private String bookName;
    private int bookId;
    private int countOfBooks;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
}
