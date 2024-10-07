import java.util.ArrayList;
import java.util.List;

// class is used to manage a list of activity objects

public class ActivityManager {
    // list to store the activities
    private List<Activity> activities = new ArrayList<>();

    // method to add an activity to the list
    public void addActivity(Activity activity) {
        activities.add(activity); 
    }

    // method to get list of activities
    public List<Activity> getActivities() {
        // return a NEW list of the activities (for encapulation)
        return new ArrayList<>(activities);
    }
}
