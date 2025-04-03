package Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static void addProgramToCollege(College collegeObj){
        collegeObj.addProgram("CSE", 2);
        collegeObj.addProgram("AI", 3);
        collegeObj.addProgram("DS", 1);
    }

    public static List<Student> getStudentList(){

        Student studentObj1 = new Student("Prashant", new ArrayList<String>(Arrays.asList("CSE", "DS", "AI")), 3);
        Student studentObj2 = new Student("Mohit", new ArrayList<String>(Arrays.asList("CSE", "DS", "AI")), 4);
        Student studentObj3 = new Student("Rohit", new ArrayList<String>(Arrays.asList("DS", "AI", "CSE")), 2);
        Student studentObj4 = new Student("Virat", new ArrayList<String>(Arrays.asList("DS", "AI", "CSE")), 1);
        Student studentObj5 = new Student("Ashwin", new ArrayList<String>(Arrays.asList("AI", "DS", "CSE")), 7);
        Student studentObj6 = new Student("Dhoni", new ArrayList<String>(Arrays.asList("AI", "CSe", "DS")), 6);

        List<Student> registeredStudentList = new ArrayList<Student>(
                Arrays.asList(studentObj1, studentObj2, studentObj3, studentObj4, studentObj5, studentObj6));
                
        return registeredStudentList;
    }
}
