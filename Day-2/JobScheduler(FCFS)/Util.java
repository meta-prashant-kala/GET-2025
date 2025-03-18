public class Util {

    private Util() {
    }

    public static Job[] sort(Job[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].arrivalTime > arr[j].arrivalTime) {
                    Job temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
