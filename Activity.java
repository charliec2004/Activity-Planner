public abstract class Activity {
    // attributes
    private String name;
    private int duration;  // in hours
    private int difficulty;  // scale 1-10

    // argumented constructor
    public Activity(String name, int duration, int difficulty) {
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    // get methods
    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getDifficulty() {
        return difficulty;
    }

    // overridden toString that gives all attributes formatted
    @Override
    public String toString() {
        return "Activity: " + name + "\nDuration: " + duration + " hours\nDifficulty: " + difficulty;
    }

    // abstract method - used to be dynamically (output depends on the class) called in subclasses of Activity
    public abstract void displayActivityData(int month, String location);

    // overridden equals method to compare activities based on their name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Activity activity = (Activity) obj;
        return name.equals(activity.name);
    }
}
