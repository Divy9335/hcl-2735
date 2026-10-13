package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.Operation;


import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsManagement.LibraryManager;

import java.util.Scanner;

class Library extends LibraryManager {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------This is Library Management System ---------");

        System.out.println("1 - For adding books");
        System.out.println("2 - For Deleting books");
        System.out.println("3 - For Accessing books");
        System.out.println("4 - For Assigning magazine");
        System.out.println("5 - See no. of Students having books borrowed");
        System.out.println("0 - For exiting");

        Library manager = new Library();

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
                    manager.addBook(id,bookName,countOfBooks);
                    break;
                }
                case 2 : {
                    System.out.print("Enter book id which you want to remove : ");
                    int id = sc.nextInt();
                    manager.deleteBook(id);
                    break;
                }
                case 3 :{
                    manager.showBooks();
                    break;
                }
                case 4 :{
                    System.out.print("Enter student id - ");
                    int sId = sc.nextInt();
                    System.out.print("Enter book id - ");
                    int bId = sc.nextInt();
                    boolean b = manager.issueBook(bId,sId);
                    if(b) manager.deleteBook(bId);
                    break;
                }
                case 5 :{
                    manager.showStudents();
                    break;
                }
                default:
                    System.out.println("Exiting the System");
                    flag = false;

            }
        }



    }
}
