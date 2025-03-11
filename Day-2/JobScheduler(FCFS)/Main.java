import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Job> jobList = new ArrayList<Job>();

        Scanner sc = new Scanner(System.in);

        // Program to take Jobs as input
        System.out.println(" ---------- First Come First Server Schedular ---------- ");
        System.out.println("Enter the number of Jobs");
        int numOfJobs = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numOfJobs; i++) {
            System.out.println("Enter the name of the Job");
            String jobName = sc.nextLine();
            System.out.println("Enter the ArrivalTime");
            int arrivalTime = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the BurstTime");
            int burstTime = Integer.parseInt(sc.nextLine());
            Job job = new Job(jobName, arrivalTime, burstTime);
            jobList.add(job);
        }

        // Sorting the Jobs as per their arrival time
        Collections.sort(jobList, new Comparator<Job>() {
            public int compare(final Job job1, final Job job2) {
                return Integer.compare(job1.arrivalTime, job2.arrivalTime);
            }
        });

        // Calculation of Completion time, Total Turn around time and waiting time for
        // every job
        int waitTime = 0;
        for (Job job : jobList) {
            if (job.arrivalTime > waitTime) {
                waitTime = waitTime + job.arrivalTime;
            }
            job.setCompletionTime(waitTime + job.burstTime);
            job.setTotalTurnAroundTime(job.getCompletionTime() - job.arrivalTime);
            job.setWaitingTime(job.getTotalTurnAroundTime() - job.burstTime);
            waitTime = waitTime + job.burstTime;
        }

        // Displaying Available options to the user
        int selectedOption = 1;
        while (selectedOption != 0) {
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To get the completion time of each Job");
            System.out.println("2. To get the waiting time of each Job");
            System.out.println("3. To get the turn around time for each Job");
            System.out.println("4. To get the Average waiting time of every Job");
            System.out.println("5. To check the Maximum waiting time period for a Job in queue");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid option");
                continue;
            }

            switch (selectedOption) {

                // Handling Completion time for each job
                case 1:
                    System.out.println("Completion Time of each Job:");
                    for (Job job : jobList) {
                        System.out.println(job.name + " -> " + job.getCompletionTime());
                    }
                    System.out.println();
                    break;

                // Handling waiting time for each job
                case 2:
                    System.out.println("Waiting Time of each Job:");
                    for (Job job : jobList) {
                        System.out.println(job.name + " -> " + job.getWaitingTime());
                    }
                    System.out.println();
                    break;

                // Handling turn around time for each job
                case 3:
                    System.out.println("Turn Around Time of each Job:");
                    for (Job job : jobList) {
                        System.out.println(job.name + " -> " + job.getWaitingTime());
                    }
                    System.out.println();
                    break;

                // Handling Average waiting time of every job
                case 4:
                    int size = jobList.size();
                    int avgWaitTime = 0;
                    for (Job job : jobList) {
                        avgWaitTime += job.getTotalTurnAroundTime();
                    }
                    avgWaitTime = avgWaitTime / size;
                    System.out.println("Average waiting time of all Jobs : " + avgWaitTime);
                    System.out.println();
                    break;

                // Handling Maximum waiting time period for a process in queue
                case 5:
                    int maxWaitTime = 0;
                    String maxWaitTimeJob = "";
                    for (Job job : jobList) {
                        if (maxWaitTime < job.getWaitingTime()) {
                            maxWaitTimeJob = job.name;
                            maxWaitTime = job.getWaitingTime();
                        }
                    }
                    System.out.println(maxWaitTimeJob + " have Maximum wait time of : " + maxWaitTime);
                    System.out.println();
                    break;

                // Handling exit from the program
                case 0:
                    break;
                default:
                    break;
            }

        }

        sc.close();
    }
}