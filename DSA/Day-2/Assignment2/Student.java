package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String studentName;
    List<String> preferenceProgramList = new ArrayList<>();
    int rank;
    Program assignedProgram = null;

    /**
     * Constructor initialise a Student
     * 
     * @param name                  should be of String type
     * @param preferenceProgramList should be a list of student preference for the
     *                              programs
     * @param rank                  should be of int type
     */
    public Student(String name, List<String> preferenceProgramList, int rank) {
        this.studentName = name;
        for (String program : preferenceProgramList) {
            this.preferenceProgramList.add(program);
        }
        this.rank = rank;
    }

    /**
     * Method to assign a program to a student
     * 
     * @param programObj should be of Program type
     * @return true if the program is assigned succesfully, otherwise false
     */
    public boolean setAssignedProgram(Program programObj) {
        try {
            assignedProgram = programObj;
            return true;
        } catch (Exception e) {
            System.out.println("Cannot assign this program");
            return false;
        }
    }

    /**
     * To get the rank of the student
     * @return rank of the program
     */
    public int getRank() {
        return rank;
    }

    /**
     * Method to get the assigned program to the student
     * @return program assigned to the student
     */
    public Program getAssignedProgram() {
        return assignedProgram;
    }

}
