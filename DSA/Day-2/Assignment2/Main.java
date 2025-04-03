package Assignment2;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        College collegeObj = new College("SKIT", 10);

        Util.addProgramToCollege(collegeObj);
        List<Student> registeredStudentList = Util.getStudentList();

        collegeObj.sortStudentList(registeredStudentList);

        collegeObj.addToQueue(registeredStudentList);

        collegeObj.assignedProgram();

        collegeObj.displayRegisteredStudentsList();

    }
}
