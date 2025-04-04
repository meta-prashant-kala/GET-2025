import Assignment2.CustomPriorityQueue;
import Assignment2.PriorityQueue;
public class Captain {

    PriorityQueue<Bowler> priorityQueue;;
    
    /**
     * Constructor to initialise a priority queue of size
     * @param size should be of int type
     */
    public Captain(int size){
        priorityQueue=new CustomPriorityQueue<Bowler>(size);
    }

    /**
     * Method to add the bowler to the priority queue
     * @param bowler should be of bowler type
     */
    public void addToQueue(Bowler bowler){
        priorityQueue.push(bowler);
    }

    /**
     * Method to assign bowlers as per their reamaining balls
     */
    public void assignBowlers(){
        while (!priorityQueue.isEmpty()) {
            Bowler bowler=priorityQueue.pop();
            if(bowler!=null){
                System.out.println(bowler.bowlerName+" bowling");
                bowler.bowlerQuota--;
                if(bowler.bowlerQuota>0){
                    priorityQueue.push(bowler);
                }
            }
        }
    }
}
