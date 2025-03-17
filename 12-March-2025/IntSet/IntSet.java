package IntSet;

public class IntSet {
    private final boolean[] customSetArray = new boolean[1000];

    /**
     * Constructor to initialise the customSetArray. The constructor takes an array
     * of integers and set the customSetArray[inputArr[i]] true if ranging in 1-1000
     * inclusively.
     * 
     * @param setImplementedArray should be of intger type and contains the set
     *                            element ranging from 1-1000
     */
    IntSet(int[] setImplementedArray) {
        for (int i = 0; i < setImplementedArray.length; i++) {
            customSetArray[setImplementedArray[i] - 1] = true;
        }
    }

    /**
     * Method to print the elements present in the set
     */
    public void printIntSet() {
        for (int i = 0; i < 1000; i++) {
            if (customSetArray[i] == true) {
                System.out.print(i + 1 + ", ");
            }
        }
    }

    /**
     * Method to check if an integer X belongs to the set
     * 
     * @param x should be of integer type and ranges from 1 to 1000
     * @return true if X belongs to the set, false if not
     */
    public boolean isMember(int x) {
        return customSetArray[x - 1];
    }

    /**
     * Method that tells about the size of set
     * 
     * @return the size of the set
     */
    public int size() {
        int sizeCount = 0;
        for (int i = 0; i < customSetArray.length; i++) {
            if (customSetArray[i]) {
                sizeCount++;
            }
        }
        return sizeCount;
    }

    /**
     * Method to check weather a set is a subet of the set for which the method is
     * invoked
     * 
     * @param s should be of type IntSet
     * @return true if the set is a subset of set for which the method is called,
     *         otherwise false
     */
    public boolean isSubSet(IntSet s) {
        for (int i = 0; i < 1000; i++) {
            if (s.customSetArray[i] && !this.customSetArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the complement of the set for which the method is invoked
     * 
     * @return the complemented set of the set for which the method is invoked with
     *         IntSet type
     */
    public IntSet getComplement() {
        int[] complementSetArray = new int[1000 - this.size()];
        int iteratorOfComplementSetArray = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!this.isMember(i)) {
                complementSetArray[iteratorOfComplementSetArray] = i;
                iteratorOfComplementSetArray++;
            }
        }
        IntSet complemIntSetObj = new IntSet(complementSetArray);
        return complemIntSetObj;
    }

    /**
     * Method to get the union of two sets
     * 
     * @param s is the set with which the set who invoked the method will get union
     * @return union set of the param set and the set who invoked the method
     */
    public IntSet getUnionSet(IntSet s) {
        int unionSetSize = this.size() + s.size();
        int[] unionSetArray = new int[unionSetSize];
        int iteratorOfUnionSet = 0;
        for (int i = 0; i < 1000; i++) {
            if (this.customSetArray[i]) {
                unionSetArray[iteratorOfUnionSet] = i + 1;
                iteratorOfUnionSet++;
            }
            if (s.customSetArray[i]) {
                unionSetArray[iteratorOfUnionSet] = i + 1;
                iteratorOfUnionSet++;
            }
        }
        IntSet unionSetObj = new IntSet(unionSetArray);
        return unionSetObj;
    }

    /**
     * Method to get the Intersection of two sets
     * 
     * @param s is the set with which the set who invoked the method will get
     *          Intersects
     * @return Intersection set of the param set and the set who invoked the method
     */
    public IntSet getIntersectionSet(IntSet s) {
        int intersectionSetSize = 0;
        for (int i = 0; i < 1000; i++) {
            if (this.isMember(i + 1) && s.isMember(i + 1)) {
                intersectionSetSize++;
            }
        }
        int[] intersectionSetArray = new int[intersectionSetSize];
        int iteratorOfIntersectionSet = 0;
        for (int i = 0; i < 1000; i++) {
            if (this.isMember(i + 1) && s.isMember(i + 1)) {
                intersectionSetArray[iteratorOfIntersectionSet] = i + 1;
                iteratorOfIntersectionSet++;
            }
        }
        IntSet intersectionSetObj = new IntSet(intersectionSetArray);
        return intersectionSetObj;
    }

    /**
     * Method to get the Differece of two sets
     * 
     * @param s is the set with which the set who invoked the method will get
     *          differenced
     * @return Differnece set of the param set and the set who invoked the method
     */
    public IntSet getDifference(IntSet s) {
        IntSet intersectionSetObj = this.getIntersectionSet(s);
        int differenceSetSize = this.size() - intersectionSetObj.size();
        System.out.println(differenceSetSize);
        int[] differenceSetArray = new int[differenceSetSize];
        int iteratorOfDifferenceSet = 0;
        for (int i = 0; i < 1000; i++) {
            if ((this.isMember(i + 1) && !intersectionSetObj.isMember(i + 1))) {
                differenceSetArray[iteratorOfDifferenceSet] = i + 1;
                iteratorOfDifferenceSet++;
            }
        }
        IntSet differenceSetObj = new IntSet(differenceSetArray);
        return differenceSetObj;
    }

    /**
     * Method to get the Complement of two sets
     * 
     * @param s is the set with which the set who invoked the method will get
     *          Complemented
     * @return Complement set of the param set and the set who invoked the method
     */
    public IntSet getComplementIntSet(IntSet s) {
        IntSet intersectionSetObj = this.getIntersectionSet(s);
        IntSet complementIntSetObj = s.getDifference(intersectionSetObj);
        return complementIntSetObj;
    }

    @Override
    public boolean equals(Object o) {
        IntSet obj = (IntSet) o;
        boolean[] another = obj.customSetArray;

        for (int i = 0; i < 1000; i++) {
            if (another[i] != this.customSetArray[i]) {
                return false;
            }
        }

        return true;
    }

}
