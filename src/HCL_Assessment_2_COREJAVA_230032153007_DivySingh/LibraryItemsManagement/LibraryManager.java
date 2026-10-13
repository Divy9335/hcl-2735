package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsManagement;

import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.AdminControl.Admin;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemClasses.Books;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemClasses.DVD;
import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemClasses.Magazines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManager implements Admin {
    HashMap<Integer, Books> booksList = new HashMap<>();
    List<DVD> dvdList = new ArrayList<>();
    List<Magazines> magazinesList = new ArrayList<>();



    public void addBook(int id, String bookName, int bookCount) {
        Books book = new Books() {
            @Override
            public void setBookName(String bookName) {
                super.setBookName(bookName);
            }

            @Override
            public void setBookId(int bookId) {
                super.setBookId(bookId);
            }

            @Override
            public int getCountOfBooks() {
                return super.getCountOfBooks();
            }

            @Override
            public void setCountOfBooks(int countOfBooks) {
                super.setCountOfBooks(getCountOfBooks()+1);
            }
        };
        booksList.put(id,book);
    }


    public void addMagazine(int id, String magazineName, int magazineCount) {
        Magazines magazine = new Magazines() {
            @Override
            public void setMagazineName(String magazineName) {
                super.setMagazineName(magazineName);
            }

            @Override
            public int getCountOfMagazine() {
                return super.getCountOfMagazine();
            }

            @Override
            public void setCountOfMagazine(int count) {
                super.setCountOfMagazine(getCountOfMagazine()+1);
            }
        };
    }

    @Override
    public void register(int id, String studentName) {

    }

    @Override
    public void deleteBook(int bookId) {
        if(booksList.containsKey(bookId)){
            Books b = booksList.get(bookId);
            b.setCountOfBooks(b.getCountOfBooks()-1);
            booksList.put(bookId,b);
            if(b.getCountOfBooks() == 0){
                booksList.remove(bookId);
            }
        }else{
            System.out.println("--------Book is not present in the Library -------");
        }
    }

    @Override
    public void issueBook(int bookId, int studentId) {

    }

    @Override
    public void showBooks() {
        for(int key : booksList.keySet()){
            Books b = booksList.get(key);
            System.out.println(b.getBookId()+" "+b.getBookName()+" "+b.getCountOfBooks());
        }
    }
}
