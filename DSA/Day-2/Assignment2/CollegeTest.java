package Assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CollegeTest {

    @Test
    void addProgram() {
        College college = new College("SKIT", 10);
        college.addProgram("CSE", 5);
        assertEquals(1, college.availableProgramsList.size());
        assertEquals("CSE", college.availableProgramsList.get(0).programName);
    }

    @Test
    void getProgram() {
        College college = new College("SKIT", 10);
        college.addProgram("CSE", 10);
        Program program = college.getProgram("CSE");
        assertNotNull(program);
        assertEquals("CSE", program.programName);
        assertNull(college.getProgram("DS"));
    }

    @Test
    void sortStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Prashant", List.of("CSE", "DS"), 2));
        students.add(new Student("Ankit", List.of("CSE", "DS"), 1));
        College college = new College("SKIT", 2);
        college.sortStudentList(students);
        assertEquals("Ankit", students.get(0).studentName);
        assertEquals("Prashant", students.get(1).studentName);
    }

    @Test
    void assignedProgram() {

        College college = new College("SKIT", 10);

        college.addProgram("CSE", 1);
        college.addProgram("DS", 1);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Prashant", List.of("CSE", "DS"), 1));
        students.add(new Student("Ankit", List.of("CSE", "DS"), 2));
        students.add(new Student("Charlie", List.of("DS", "CSE"), 3));

        college.sortStudentList(students);

        college.addToQueue(students);

        college.assignedProgram();

        assertEquals(2, college.successfullRegisteredStudentList.size());

        Student studentObj1 = college.successfullRegisteredStudentList.get(0);
        assertEquals("Prashant", studentObj1.studentName);
        assertEquals("CSE", studentObj1.getAssignedProgram().programName);

        Student studentObj2 = college.successfullRegisteredStudentList.get(1);
        assertEquals("Ankit", studentObj2.studentName);
        assertEquals("DS", studentObj2.getAssignedProgram().programName);

        assertNull(students.get(2).getAssignedProgram());
    }

}