package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    List<Program> preferenceProgramList=new ArrayList<>();  
    int rank;
    Program assignedProgram;

    public int getRank() {
        return rank;
    }

}
