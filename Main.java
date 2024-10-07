public class Main {
    public static void main(String[] args) {
        // create an instance of ActivityManager
        ActivityManager manager = new ActivityManager();
        
        // add different types of activities to the manager

        manager.addActivity(new Camping());

        manager.addActivity(new Surfing());

        manager.addActivity(new Hiking());


        // creates an instance of UserInterface, with the manager (that now has activities loaded on to it) as its argument
        /* this way of initilizting the program allows for further expansion of more activities to be MUCH easier and streamlined
           becuase the system to handle and implement now activities is already here, it is just a matter of coming up with new
           activities and not implementing them however, the activities databases are still hardcoded which means they cant be used
           for any year and do not update, further expansion on this project could benefit from API implementation to have dynamic 
           and more accurate databases for relevant activitiy info. */   
        UserInterface ui = new UserInterface(manager);
        
        // start the user interface
        ui.run();
    }
}

