public class Hiking extends Activity {
    private static final double[][] trailData = new double[][] {
        // temp, elevation gain, trail length (format for 2d array)

        // Crystal Cove
        {15, 300, 9}, {16, 300, 9}, {17, 300, 9}, {18, 300, 9}, {15, 300, 9}, {16, 300, 9}, 
        {17, 300, 9}, {18, 300, 9},{15, 300, 9}, {16, 300, 9}, {17, 300, 9}, {18, 300, 9},
        // Joshua Tree
        {16, 400, 12}, {17, 400, 12}, {18, 400, 12}, {19, 400, 12}, {16, 400, 12}, {17, 400, 12},
        {18, 400, 12}, {19, 400, 12},{16, 400, 12}, {17, 400, 12}, {18, 400, 12}, {19, 400, 12},
        // Topanga
        {15, 500, 5}, {16, 500, 5}, {17, 500, 5}, {18, 500, 5}, {15, 500, 5}, {16, 500, 5}, {17, 500, 5},
        {18, 500, 5},{15, 500, 5}, {16, 500, 5}, {17, 500, 5}, {18, 500, 5},
    };

    // super constructor 
    public Hiking() {
        super("Hiking", 3, 2);
    }

    // using default method to show data
    @Override
    public void displayActivityData(int month, String location) {
        // determines index based on location and gets the right data from siteData 2D array
        int index = switch (location) {
            case "Crystal Cove State Park" -> 0;
            case "Joshua Tree National Park" -> 1;
            case "Topanga State Park" -> 2;
            default -> throw new IllegalArgumentException("Invalid location");
        };

        // calculate the array index for the specified month and location.
        double[] data = trailData[index * 12 + (month - 1)];

        // print the hiking data for the chosen month and location
        System.out.printf("At %s in %s:\n", location, month);
        System.out.printf("Average Temperature: %.1f°C\n", data[0]);
        System.out.printf("Elevation Gain: %.1f meters\n", data[1]);
        System.out.printf("Trail Length: %.1f kilometers\n", data[2]);
    }
}
