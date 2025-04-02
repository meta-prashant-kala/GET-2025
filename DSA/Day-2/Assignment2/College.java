package Assignment2;

import java.util.ArrayList;
import java.util.List;

import Assignment1.CircularQueue;
import Assignment1.Queue;

public class College {
    String collegeName;
    int numberOfStudents;

    List<Program> availableProgramsList = new ArrayList<Program>();
    List<Student> successfullRegisteredStudentList = new ArrayList<Student>();
    Queue<Student> registeredStudentQueue;

    public College(String collegeName, int maxRegistration) {
        this.collegeName = collegeName;
        registeredStudentQueue = new CircularQueue<Student>(maxRegistration);
    }

    public void addProgram(String programName, int totalCapacity) {
        availableProgramsList.add(new Program(programName, totalCapacity));
    }

    public Program getProgram(String programName) {
        for (Program programObj : availableProgramsList) {
            if (programName.equals(programObj.getProgramName()) && programObj.currentCapacity > 0) {
                return programObj;
            }
        }
        return null;
    }

    public void sortStudentList(List<Student> registeredStudentQueue) {
        for (int i = 0; i < registeredStudentQueue.size() - 1; i++) {
            for (int j = i + 1; j < registeredStudentQueue.size(); j++) {
                if (registeredStudentQueue.get(i).getRank() > registeredStudentQueue.get(j).getRank()) {
                    Student tempStudent = registeredStudentQueue.get(i);
                    registeredStudentQueue.set(i, registeredStudentQueue.get(j));
                    registeredStudentQueue.set(j, tempStudent);
                }
            }
        }
    }

    public void addToQueue(List<Student> registeredStudentList) {
        for (Student studentObj : registeredStudentList) {
            registeredStudentQueue.push(studentObj);
        }
    }

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
