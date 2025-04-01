package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class College {
    List<Program> availablePrograms=new ArrayList<Program>();

    public void addProgram(String programName, int totalCapacity){
        availablePrograms.add(new Program(programName,totalCapacity));
    }

    public Program isProgramAvailable(Program program){
        for(Program programObj:availablePrograms){
            if(program.programName==program.programName){
                return programObj;
            }
        }
        return null;
    }
    
}
