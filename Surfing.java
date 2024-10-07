public class Surfing extends Activity {
    // beachData array holds temperature, water temperature, and wave height data for each month at different surfing spots
    private static final double[][] beachData = new double[][] {
        // Hermosa Beach data for each month (average air temp, water temp, wave height)
        {15, 14, 2}, {16, 15, 1.8}, {17, 16, 1.5}, {19, 17, 1.2}, {20, 18, 1.0}, {15, 14, 2}, 
        {16, 15, 1.8}, {17, 16, 1.5}, {19, 17, 1.2}, {20, 18, 1.0}, {15, 14, 2}, {16, 15, 1.8},
        // Carmel Beach data for each month
        {16, 15, 1.9}, {17, 16, 1.7}, {18, 17, 1.5}, {20, 18, 1.3}, {21, 19, 1.1}, {16, 15, 1.9},
        {17, 16, 1.7}, {18, 17, 1.5}, {20, 18, 1.3}, {21, 19, 1.1}, {16, 15, 1.9}, {17, 16, 1.7},
        // Newport Beach data for each month
        {15, 13, 2.1}, {16, 14, 2.0}, {17, 15, 1.8}, {19, 16, 1.6}, {20, 17, 1.4}, {15, 13, 2.1},
        {16, 14, 2.0}, {17, 15, 1.8}, {19, 16, 1.6}, {20, 17, 1.4}, {15, 13, 2.1}, {16, 14, 2.0}
    };

    // super constructor
    public Surfing() {
        super("Surfing", 2, 6);
    }

    //overridden displayActivityData to give specific surfing data based on the users chosen month and location
    @Override
    public void displayActivityData(int month, String location) {
        // finds index based on location to fetch the right data from beachData 2D array
        int index = switch (location) {
            case "Hermosa Beach" -> 0;
            case "Carmel Beach" -> 1;
            case "Newport Beach" -> 2;
            default -> throw new IllegalArgumentException("Invalid location"); // short hand
        };

        // calculate the array index for the specified month and location.
        double[] data = beachData[index * 12 + (month - 1)]; // Corrected index formula to account for 12 months per location

        // print surfing data for chosen month and location
        System.out.printf("At %s in month %d:\n", location, month);
        System.out.printf("Average Temperature: %.1f°C\n", data[0]);
        System.out.printf("Average Water Temperature: %.1f°C\n", data[1]);
        System.out.printf("Average Wave Height: %.1f meters\n", data[2]);
    }
}
