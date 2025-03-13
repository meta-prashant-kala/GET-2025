package IntSet;

public class IntSet {
    private final boolean[] customSetArray = new boolean[1000];

    IntSet(int[] setImplementedArray) {
        for (int i = 0; i < setImplementedArray.length; i++) {
            customSetArray[setImplementedArray[i] - 1] = true;
        }
    }

    public void printIntSet() {
        for (int i = 0; i < 1000; i++) {
            if (customSetArray[i] == true) {
                System.out.print(i + 1 + ", ");
            }
        }
    }

    public boolean isMember(int x) {
        return customSetArray[x - 1];
    }

    public int size() {
        int sizeCount = 0;
        for (int i = 0; i < customSetArray.length; i++) {
            if (customSetArray[i]) {
                sizeCount++;
            }
        }
        return sizeCount;
    }

    public boolean isSubSet(IntSet s) {
        for (int i = 0; i < 1000; i++) {
            if (s.customSetArray[i] && !this.customSetArray[i]) {
                return false;
            }
        }
        return true;
    }

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
