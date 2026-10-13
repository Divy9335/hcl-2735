package HCL_Assessment_2_COREJAVA_230032153007_DivySingh;

import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsManagement.LibraryManager;

import java.util.Scanner;

public class Library extends LibraryManager {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------This is Library Management System ---------");

        System.out.println("1 - For adding books");
        System.out.println("2 - For Deleting books");
        System.out.println("3 - For Accessing books");
        System.out.println("4 - For Assigning magazine");
        System.out.println("0 - For exiting");
        LibraryManager admin = new Library();

        boolean flag = true;
        while(flag){
            System.out.print("Enter the aboue options - ");
            int option = sc.nextInt();
            switch (option) {
                case 1 : {
                    System.out.print("Enter the book id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the book name : ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter the book count : ");
                    int countOfBooks = sc.nextInt();
                    admin.addBook(id,bookName, countOfBooks);
                    break;
                }
                case 2 : {
                    System.out.print("Enter book id which you want to remove : ");
                    int id = sc.nextInt();
                    admin.deleteBook(id);
                    break;
                }
                case 3 :{
                    System.out.println("Showing books - ");
                    admin.showBooks();
                }
                default:
                    System.out.println("Exiting the System");
                    flag = false;

            }
        }



    }
}
