package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String studentName;
    List<String> preferenceProgramList = new ArrayList<>();
    int rank;
    Program assignedProgram = null;

    public Student(String name, List<String> preferenceProgramList, int rank) {
        this.studentName = name;
        for (String program : preferenceProgramList) {
            this.preferenceProgramList.add(program);
        }
        this.rank = rank;
    }

    public boolean setAssignedProgram(Program programObj) {
        assignedProgram = programObj;
        return true;
    }

    public int getRank() {
        return rank;
    }

    public Program getAssignedProgram() {
        return assignedProgram;
    }

}
