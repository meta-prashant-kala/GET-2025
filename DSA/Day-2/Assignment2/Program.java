package Assignment2;

public class Program {
    String programName;
    int totalCapacity;
    int currentCapacity;

    public Program(String progName, int totCapacity) {
        this.programName = progName;
        this.totalCapacity = totCapacity;
        this.currentCapacity = totCapacity;
    }

    public void reduceProgramCapacity() {
        this.currentCapacity--;
    }

    public String getProgramName() {
        return programName;
    }

}
