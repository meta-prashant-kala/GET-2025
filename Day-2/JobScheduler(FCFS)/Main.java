import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List<Job> jobObjsList = new ArrayList<Job>();
        Job[] jobObjsArr;
        Scanner sc = new Scanner(System.in);

        int numOfJobs;

        System.out.println(" ---------- First Come First Serve Job Schedular ---------- ");

        // Program to take Jobs as input
        while (true) {
            try {
                System.out.println("Enter the number of Jobs");
                numOfJobs = Integer.parseInt(sc.nextLine());
                if (numOfJobs <= 0) {
                    System.out.println("Number of jobs should be a positive integer");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }
        }

        // Creating Job array of number of job size
        jobObjsArr = new Job[numOfJobs];
        int jobObjsArrIterator = 0;

        // Taking job name, job's arrival time and burst time as input

        while (numOfJobs > 0) {
            try {
                String jobName = "Job- " + (jobObjsArrIterator + 1);

                // Taking whole row as input
                System.out.println("Enter the Arrival time and BurstTime of Job- " + (jobObjsArrIterator + 1));

                String rowElements = sc.nextLine();

                // Extracting digits of a row from the the string input
                String[] rowDigits = rowElements.split(" ");

                if (rowDigits.length != 2) {
                    System.out.println("Do not add redundant digits");
                    continue;
                }

                int arrivalTime = Integer.parseInt(rowDigits[0]);
                int burstTime = Integer.parseInt(rowDigits[1]);

                Job jobObj = new Job(jobName, arrivalTime, burstTime);
                jobObjsArr[jobObjsArrIterator] = jobObj;

                jobObjsArrIterator++;
                numOfJobs--;
            } catch (Exception e) {
                System.out.println("Please make valid entries");
                continue;
            }
        }

        // Sorting the Jobs as per their arrival time
        jobObjsArr = Util.sort(jobObjsArr);

        // Calculation of Completion time, Total Turn around time and waiting time for
        // every job
        int waitTime = 0;
        for (Job job : jobObjsArr) {
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
                    System.out.println();
                    System.out.println("Completion Time of each Job:");
                    System.out.println();
                    System.out.println("|   Job Name    |       Completion Time     ");
                    for (Job job : jobObjsArr) {
                        System.out.println("|  " + job.name + "       |              " + job.getCompletionTime());
                    }
                    System.out.println();
                    break;

                // Handling waiting time for each job
                case 2:
                    System.out.println();
                    System.out.println("Waiting Time of each Job:");
                    System.out.println();
                    System.out.println("|   Job Name    |       Waiting Time     ");
                    for (Job job : jobObjsArr) {
                        System.out.println("|  " + job.name + "       |              " + job.getWaitingTime());
                    }
                    System.out.println();
                    break;

                // Handling turn around time for each job
                case 3:
                    System.out.println();
                    System.out.println("Turn Around Time of each Job:");
                    System.out.println();
                    System.out.println("|   Job Name    |       Turn Around Time     ");
                    for (Job job : jobObjsArr) {
                        System.out.println(
                                "|  " + job.name + "       |              " + job.getTotalTurnAroundTime());
                    }
                    System.out.println();
                    break;

                // Handling Average waiting time of every job
                case 4:
                    int size = jobObjsArr.length;
                    int avgWaitTime = 0;
                    for (Job job : jobObjsArr) {
                        avgWaitTime += job.getWaitingTime();
                    }
                    avgWaitTime = avgWaitTime / size;
                    System.out.println();
                    System.out.println("Average waiting time of all Jobs : " + avgWaitTime);
                    System.out.println();
                    break;

                // Handling Maximum waiting time period for a process in queue
                case 5:
                    int maxWaitTime = 0;
                    String maxWaitTimeJob = "";
                    for (Job job : jobObjsArr) {
                        if (maxWaitTime < job.getWaitingTime()) {
                            maxWaitTimeJob = job.name;
                            maxWaitTime = job.getWaitingTime();
                        }
                    }
                    System.out.println();
                    System.out.println(maxWaitTimeJob + " have Maximum wait time of : " + maxWaitTime);
                    System.out.println();
                    break;

                // Handling exit from the program
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }

        }

        sc.close();
    }
}