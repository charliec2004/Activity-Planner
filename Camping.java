public class Camping extends Activity {
    // static final variable holds a 2D array of hardcoded camping data for each location in each month
    private static final double[][] siteData = new double[][] {
        // (Temp, Cost, Amenities Available (1 for Yes, 0 for No))
        // South Carlsbad State Beach Campground data for each month
        {15.0, 35, 1}, {16.0, 35, 1}, {17.0, 35, 1}, {18.0, 35, 1}, {19.0, 35, 1}, {20.0, 35, 1},
        {21.0, 35, 1}, {22.0, 35, 1}, {21.0, 35, 1}, {20.0, 35, 1}, {18.0, 35, 1}, {16.0, 35, 1},
        // Los Padres National Forest data for each month
        {10.0, 25, 1}, {11.0, 25, 1}, {12.0, 25, 1}, {13.0, 25, 1}, {14.0, 25, 1}, {15.0, 25, 1},
        {16.0, 25, 1}, {17.0, 25, 1}, {16.0, 25, 1}, {15.0, 25, 1}, {13.0, 25, 1}, {11.0, 25, 1},
        // High Desert Hot Springs Hideout data for each month
        {15.0, 30, 0}, {16.0, 30, 0}, {17.0, 30, 0}, {18.0, 30, 0}, {19.0, 30, 0}, {20.0, 30, 0},
        {21.0, 30, 0}, {22.0, 30, 0}, {21.0, 30, 0}, {20.0, 30, 0}, {18.0, 30, 0}, {16.0, 30, 0}
    };

    // super constructor
    public Camping() {
        super("Camping", 48, 4); // all locations have the same difficulty and duration in this version, could be expanded to be dependent
    }

    // overriden abstract method (from activity)
    // used to display activity data based on the month and location
    @Override
    public void displayActivityData(int month, String location) {
        // determines index based on location and gets the right data from siteData 2D array
        int index = switch (location) {
            case "South Carlsbad State Beach Campground" -> 0;
            case "Los Padres National Forest" -> 1;
            case "High Desert Hot Springs Hideout" -> 2;
            default -> throw new IllegalArgumentException("Invalid location");
        };

        // calculate the array index for the specified month and location.
        double[] data = siteData[index * 12 + (month - 1)];

        // print the camping data for the chosen month and location
        System.out.printf("At %s in %s:\n", location, month);
        System.out.printf("Average temperature: %.1f°C\n", data[0]);
        System.out.printf("Cost per Night: $%.0f\n", data[1]);
        System.out.printf("Amenities Available: %s\n", data[2] == 1 ? "Yes" : "No"); // ternary operator used for short haand here
    }
}
