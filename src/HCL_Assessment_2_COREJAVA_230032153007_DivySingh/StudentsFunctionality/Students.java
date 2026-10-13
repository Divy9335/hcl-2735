package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.StudentsFunctionality;

import HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemsObject.Book;

import java.util.HashMap;

public abstract class Students {
    private String studentName;
    private int studentId;
    private String department;
    private String course;
    static private HashMap<Integer,Book> booksTakenByStudent = new HashMap<>();

    static public HashMap<Integer, Book> getBooksTakenByStudent() {
        return booksTakenByStudent;
    }

    public void setBooksTakenByStudent(int id, Book book) {
        booksTakenByStudent.put(id,book);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
