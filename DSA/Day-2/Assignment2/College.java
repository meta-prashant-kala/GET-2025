package Assignment2;

import java.util.ArrayList;
import java.util.List;

import Assignment3.CircularQueue;
import Assignment3.Queue;

public class College {

    String collegeName;
    int numberOfStudents;

    List<Program> availableProgramsList = new ArrayList<Program>();
    List<Student> successfullRegisteredStudentList = new ArrayList<Student>();
    Queue<Student> registeredStudentQueue;

    /**
     * Constructor to create college instance
     * 
     * @param collegeName     should be of String type
     * @param maxRegistration should be of int type
     */
    public College(String collegeName, int maxRegistration) {
        this.collegeName = collegeName;
        registeredStudentQueue = new CircularQueue<Student>(maxRegistration);
    }

    /**
     * Method to add a program to the College class
     * 
     * @param programName   should be of string type
     * @param totalCapacity should be of int type
     */
    public void addProgram(String programName, int totalCapacity) {
        availableProgramsList.add(new Program(programName, totalCapacity));
    }

    /**
     * Method to get the program details by using the program name
     * 
     * @param programName should be of string type
     * @return Program if program exist for the program name, otherwise null
     */
    public Program getProgram(String programName) {
        for (Program programObj : availableProgramsList) {
            if (programName.equals(programObj.getProgramName()) && programObj.currentCapacity > 0) {
                return programObj;
            }
        }
        return null;
    }

    /**
     * Method to sort the student list based on their rank
     * 
     * @param registeredStudentList holds the student data registered for the
     *                              program
     */
    public void sortStudentList(List<Student> registeredStudentList) {
        for (int i = 0; i < registeredStudentList.size() - 1; i++) {
            for (int j = i + 1; j < registeredStudentList.size(); j++) {
                if (registeredStudentList.get(i).getRank() > registeredStudentList.get(j).getRank()) {
                    Student tempStudent = registeredStudentList.get(i);
                    registeredStudentList.set(i, registeredStudentList.get(j));
                    registeredStudentList.set(j, tempStudent);
                }
            }
        }
    }

    /**
     * Method to add the sorted student list to the queue
     * 
     * @param registeredStudentList
     */
    public void addToQueue(List<Student> registeredStudentList) {
        for (Student studentObj : registeredStudentList) {
            registeredStudentQueue.push(studentObj);
        }
    }

    /**
     * Method to display the registered student list
     */
    public void displayRegisteredStudentsList() {
        for (Student studentObj : successfullRegisteredStudentList) {
            System.out.print(studentObj.studentName + "  ->  ");
            System.out.print(studentObj.getRank() + "  ->  ");
            if (studentObj.getAssignedProgram() != null) {
                System.out.print(studentObj.getAssignedProgram().programName);
            } else {
                System.out.print("No program assigned");

            }
            System.out.println();
        }
    }

    /**
     * Method to assign program as per the availability of the pragram and student
     * preference list
     */
    public void assignedProgram() {
        while (!registeredStudentQueue.isEmpty()) {
            Student studentObj = registeredStudentQueue.peek();
            for (String programName : studentObj.preferenceProgramList) {
                Program programObj = this.getProgram(programName);
                if (programObj != null) {
                    studentObj.setAssignedProgram(programObj);
                    programObj.reduceProgramCapacity();
                    successfullRegisteredStudentList.add(studentObj);
                    break;
                }
            }
            registeredStudentQueue.pop();
        }
    }

}
