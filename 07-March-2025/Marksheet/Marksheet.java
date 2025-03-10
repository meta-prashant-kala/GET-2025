import java.util.ArrayList;

public class Marksheet{
    

    /**
     * Method takes an arraylist of marks of all students and returns the average marks of all students
     * @param marksList should be an arraylist of Float
     * @return  return the average of marks of all students
     */
    public float getAvgMarks(ArrayList<Float> marksList){
        int size=marksList.size();
        float avgMarks=0f;
        for(int i=0;i<size;i++){
            avgMarks+=marksList.get(i);
        }
        avgMarks=avgMarks/size;
        return avgMarks;
    }


    /**
     * Method takes an arraylist of marks of all students and returns the Minimum marks from the arraylist
     * @param marksList should be an arraylist of Float
     * @return  return the minimum of marks of all students
     */
    public float getMinMarks(ArrayList<Float> marksList){
        int size=marksList.size();
        float minMarks=101;
        for(int i=0;i<size;i++){
            minMarks=Math.min(minMarks, marksList.get(i));
        }
        return minMarks;
    }


    /**
     * Method takes an arraylist of marks of all students and returns the maximum marks from the arraylist
     * @param marksList should be an arraylist of Float
     * @return  return the maximum of marks of all students
     */
    public float getMaxMarks(ArrayList<Float> marksList){
        int size=marksList.size();
        float maxMarks=0;
        for(int i=0;i<size;i++){
            maxMarks=Math.max(maxMarks, marksList.get(i));
        }
        return maxMarks;
    }


    /**
     * Method takes an arraylist of marks of all students and returns the percentage of marks of passed students(marks>=40)
     * @param marksList should be an arraylist of Float
     * @return  return the percentage of marks of passed students(marks>=40)
     */
    public float getPercentage(ArrayList<Float> marksList){
        int size=marksList.size();
        int passedStudentCount=0;
        for(int i=0;i<size;i++){
            if(marksList.get(i)>=40){
                passedStudentCount++;
            }
        }
        return ((passedStudentCount*100)/size);
    }
}