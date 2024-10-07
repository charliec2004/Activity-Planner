import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    // new scanner for this class
    private Scanner scanner = new Scanner(System.in);
    // new non-static activityManager to handle activity data and operations
    private ActivityManager manager;
    private ArrayList<Activity> chosenActivities = new ArrayList<>();

    // constructor to initialize UserInterface with an existing ActivityManager
    public UserInterface(ActivityManager manager) {
        this.manager = manager;
    }

    // method to run the main user interface
    public void run() {
        System.out.println("Welcome to TrailBlazer!");

        while (chosenActivities.size() < 3) {
            System.out.println("Available Activities:");
            // displays a list of activities available from the manager (expandable - will still print all available)
            for (int i = 0; i < manager.getActivities().size(); i++) {
                System.out.println((i + 1) + ". " + manager.getActivities().get(i).getName());
            }

            // prompt user to choose an activity by number
            System.out.print("Choose an activity (number): ");
            int choice = scanner.nextInt() - 1; // subtract 1 to align with indexes

            // validate the choice
            if (choice >= manager.getActivities().size() || choice < 0) {
                System.out.println("Invalid number. Please try again.");
                continue; // prompt user again
            }

            Activity selectedActivity = manager.getActivities().get(choice);

            // check if the activity has already been chosen
            if (chosenActivities.contains(selectedActivity)) {
                System.out.println("You already chose this activity! Please select another.");
                continue; // prompt user again
            }

            chosenActivities.add(selectedActivity);

            // prompt user to enter the month for the activity (1-12)
            System.out.print("Enter the month (1-12): ");
            int month = scanner.nextInt();

            // validate the month
            if (month < 1 || month > 12) {
                System.out.println("Invalid month. Please try again.");
                chosenActivities.remove(selectedActivity); // remove invalid choice
                continue; // prompt user again
            }

            // show location options based on the TYPE of the activity chosen
            System.out.println("Choose a location:");
            if (selectedActivity instanceof Camping) {
                System.out.println("1. South Carlsbad State Beach Campground");
                System.out.println("2. Los Padres National Forest");
                System.out.println("3. High Desert Hot Springs Hideout");
            } else if (selectedActivity instanceof Surfing) {
                System.out.println("1. Hermosa Beach");
                System.out.println("2. Carmel Beach");
                System.out.println("3. Newport Beach");
            } else if (selectedActivity instanceof Hiking) {
                System.out.println("1. Crystal Cove State Park");
                System.out.println("2. Joshua Tree National Park");
                System.out.println("3. Topanga State Park");
            }

            // ask for user's location choice (options are above)
            System.out.print("Enter your location choice: ");
            int locationChoice = scanner.nextInt();
            // find the location string based on the type of activity and user choice
            String location = null;
            boolean validLocation = true;
            switch (locationChoice) {
                case 1:
                    if (selectedActivity instanceof Camping) {
                        location = "South Carlsbad State Beach Campground";
                    } else if (selectedActivity instanceof Surfing) {
                        location = "Hermosa Beach";
                    } else if (selectedActivity instanceof Hiking) {
                        location = "Crystal Cove State Park";
                    }
                    break;
                case 2:
                    if (selectedActivity instanceof Camping) {
                        location = "Los Padres National Forest";
                    } else if (selectedActivity instanceof Surfing) {
                        location = "Carmel Beach";
                    } else if (selectedActivity instanceof Hiking) {
                        location = "Joshua Tree National Park";
                    }
                    break;
                case 3:
                    if (selectedActivity instanceof Camping) {
                        location = "High Desert Hot Springs Hideout";
                    } else if (selectedActivity instanceof Surfing) {
                        location = "Newport Beach";
                    } else if (selectedActivity instanceof Hiking) {
                        location = "Topanga State Park";
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    chosenActivities.remove(selectedActivity); // remove invalid choice
                    validLocation = false;
                    break;
            }

            if (!validLocation) {
                continue; // prompt user again
            }

            // print the selected activity's details
            System.out.println(selectedActivity.toString());
            // show data specific to the chosen activity, month, and location from the abstract method
            selectedActivity.displayActivityData(month, location);
        }

        System.out.println("Thank you for using the program!");
    }
}
