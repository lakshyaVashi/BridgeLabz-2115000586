public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int balance = petrol[i] - distance[i];
            totalSurplus += balance;
            currentSurplus += balance;

            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        int start = findStartingPoint(petrol, distance);
        System.out.println(start);
    }
}
