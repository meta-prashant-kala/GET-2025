package Assignment2;

public class Program {
    String programName;
    int totalCapacity;
    int currentCapacity;


    /**
     * Contructor to initiate a program
     * @param progName  should be String type
     * @param totCapacity   should be of int type
     */
    public Program(String progName, int totCapacity) {
        this.programName = progName;
        this.totalCapacity = totCapacity;
        this.currentCapacity = totCapacity;
    }

    /**
     * Method to reduce the current program capacity if a student is assigned to a program
     */
    public void reduceProgramCapacity() {
        this.currentCapacity--;
    }

    /**
     * Method to get the program name of a program
     * @return program name of a program
     */
    public String getProgramName() {
        return programName;
    }

}
