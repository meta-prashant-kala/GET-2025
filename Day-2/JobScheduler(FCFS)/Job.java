

public class Job {

    String name;
    int ArrivalTime;
    int BurstTime;


    // Method for completion time
    private int CompletionTime;
    public void setCompletionTime(int completionTime) {
        this.CompletionTime = completionTime;
    }
    public int getCompletionTime() {
        return this.CompletionTime;
    }
    
    
    // Method for Total Turn Around time
    private int TotalTurnAroundTime;
    public void setTotalTurnAroundTime(int totalTurnAroundTime) {
        TotalTurnAroundTime = totalTurnAroundTime;
    }
    public int getTotalTurnAroundTime() {
        return TotalTurnAroundTime;
    }
    
    
    // Method for Waiting time
    private int WaitingTime;
    public void setWaitingTime(int waitingTime) {
        WaitingTime = waitingTime;
    }
    public int getWaitingTime() {
        return WaitingTime;
    }
    
    
    // Job class Constructor
    Job(String name, int ArrivalTime, int BurstTime){
        this.ArrivalTime=ArrivalTime;
        this.name=name;
        this.BurstTime=BurstTime;
    }
}
