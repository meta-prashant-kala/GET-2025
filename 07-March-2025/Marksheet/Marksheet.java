
public class Marksheet {

    /**
     * Method takes an array of marks of all students and returns the average
     * marks of all students
     * 
     * @param marksList should be an array of Float
     * @return return the average of marks of all students
     */
    public float getAvgMarks(Float[] marksList) {
        int marksListSize = marksList.length;
        float avgMarks = 0f;
        for (int i = 0; i < marksListSize; i++) {
            avgMarks += marksList[i];
        }
        avgMarks = avgMarks / marksListSize;
        return avgMarks;
    }

    /**
     * Method takes an array of marks of all students and returns the Minimum
     * marks from the array
     * 
     * @param marksList should be an array of Float
     * @return return the minimum of marks of all students
     */
    public float getMinMarks(Float[] marksList) {
        int marksListSize = marksList.length;
        float minMarks = 101;
        for (int i = 0; i < marksListSize; i++) {
            minMarks = Util.min(minMarks, marksList[i]);
        }
        return minMarks;
    }

    /**
     * Method takes an array of marks of all students and returns the maximum
     * marks from the array
     * 
     * @param marksList should be an array of Float
     * @return return the maximum of marks of all students
     */
    public float getMaxMarks(Float[] marksList) {
        int marksListSize = marksList.length;
        float maxMarks = 0;
        for (int i = 0; i < marksListSize; i++) {
            maxMarks = Util.max(maxMarks, marksList[i]);
        }
        return maxMarks;
    }

    /**
     * Method takes an array of marks of all students and returns the percentage
     * of marks of passed students(marks>=40)
     * 
     * @param marksList should be an array of Float
     * @return return the percentage of marks of passed students(marks>=40)
     */
    public float getPercentage(Float[] marksList) {
        int marksListSize = marksList.length;
        int passedStudentCount = 0;
        for (int i = 0; i < marksListSize; i++) {
            if (marksList[i] >= 40) {
                passedStudentCount++;
            }
        }
        return ((passedStudentCount * 100) / marksListSize);
    }
}