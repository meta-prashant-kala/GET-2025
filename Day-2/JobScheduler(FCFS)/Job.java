
public class Job {

    String name;
    int arrivalTime;
    int burstTime;

    private int CompletionTime;
    
    // Method for completion time
    public void setCompletionTime(int completionTime) {
        this.CompletionTime = completionTime;
    }

    public int getCompletionTime() {
        return this.CompletionTime;
    }

    private int totalTurnAroundTime;
    
    // Method for Total Turn Around time
    public void setTotalTurnAroundTime(int totalTurnAroundTime) {
        this.totalTurnAroundTime = totalTurnAroundTime;
    }

    public int getTotalTurnAroundTime() {
        return totalTurnAroundTime;
    }

    private int waitingTime;
    
    // Method for Waiting time
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    // Job class Constructor
    Job(String name, int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.name = name;
        this.burstTime = burstTime;
    }
}
