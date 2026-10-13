package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsManagement;

import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.AdminControl.Admin;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsObject.Book;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsObject.Magazine;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.StudentsFunctionality.Student;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.StudentsFunctionality.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManager implements Admin {

    static HashMap<Integer, Book> booksList = new HashMap<>();
    static List<Magazine> magazineList = new ArrayList<>();

    @Override
    public void addBook(int id, String bookName, int bookCount) {
        Book book = new Book();
        book.setBookId(id);
        book.setBookName(bookName);
        if(booksList.containsKey(id)){
            int countOfBooks = booksList.get(id).getCountOfBooks();
            book.setCountOfBooks(countOfBooks+bookCount);
        }else book.setCountOfBooks(bookCount);
        booksList.put(id,book);
    }



    @Override
    public void addMagazine(String magazineName, int magazineCount) {
        Magazine magazine = new Magazine();
        magazine.setMagazineName(magazineName);
        magazine.setCountOfMagazine(magazine.getCountOfMagazine()+magazineCount);
        magazineList.add(magazine);
    }

    @Override
    public void register(int id, String studentName) {

    }

    @Override
    public void deleteBook(int bookId) {
        if(booksList.containsKey(bookId)){
            Book book = booksList.get(bookId);
            int count = book.getCountOfBooks();
            book.setCountOfBooks(count-1);
            booksList.put(bookId,book);
            if(book.getCountOfBooks()==0) booksList.remove(bookId);

        }else{
            System.out.println("No book is available in the library of id "+bookId);
        }
    }

    @Override
    public boolean issueBook(int bookId, int studentId) {
        if(!booksList.containsKey(bookId)){
            System.out.println("Book is not Available");
        }else {
            Student student = new Student();
            if (!student.getBooksTakenByStudent().containsKey(studentId)) {
                Book book = booksList.get(bookId);
                Book temBook = new Book();
                temBook.setBookId(bookId);
                temBook.setCountOfBooks(1);
                temBook.setBookName(book.getBookName());
                student.setBooksTakenByStudent(bookId, temBook);
                return true;
            } else {
                System.out.println("Student already has that book");
            }
        }
        return false;
    }

    @Override
    public void showBooks() {
        if(booksList.isEmpty()){
            System.out.println("---No Books are Available at this time---");
        }else{
            System.out.println("---Books available are---");
            for(int key : booksList.keySet()){
                Book book = booksList.get(key);
                System.out.println(book.getBookId()+" "+book.getBookName()+" "+book.getCountOfBooks());
            }
        }
    }

    @Override
    public void showStudents() {
        HashMap<Integer,Book> temBook  = Students.getBooksTakenByStudent();
        if(temBook.isEmpty()) System.out.println("No students have borrowed the books");
        else for(int key : temBook.keySet()){
            Book tem = temBook.get(key);
            System.out.println(key+" "+tem.getBookId()+" "+tem.getBookName()+" "+ tem.getCountOfBooks());
        }
        //System.out.println(Students.getBooksTakenByStudent().values().stream().toList());
    }
}