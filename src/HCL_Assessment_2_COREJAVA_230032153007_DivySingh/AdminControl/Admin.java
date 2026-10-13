package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.AdminControl;

public interface Admin {
    void addBook(int id, String bookName, int bookCount);
    void addMagazine(int id, String magazineName, int magazineCount);
    void register(int id, String studentName);
    void deleteBook(int bookId);
    void issueBook(int bookId, int studentId);
    void showBooks();
}




/*
* A small college library lends books magazines and DVDS to members. The System must let
* a librarian add items, register members, issue and return items, calculate late fees, manage a waitlist for items that are already
* borrowed and export a report
*
*
*
*
*
*
* */