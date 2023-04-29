package application;

public class EffortLog {
    //variables for the type of project that user chooses to work on, their username, and the time spent on the project
    private String projectType;
    private String projectName;
    private String userName;
    private double time;

    //constructor
    public EffortLog(String projectType, String projectName, String userName, double time) {
        this.projectType = projectType;
        this.projectName = projectName;
        this.userName = userName;
        this.time = time;
    }

    //returns the type of project
    public String getProjectType() {
        return projectType;
    }

    //returns the name of the project
    public String getProjectName(){
        return projectName;
    }

    //returns the username
    public String getUserName() {
        return userName;
    }

    //returns the time spent on the project
    public double getTime(){
        return time;
    }

    //sets the project type to the input parameter
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    //sets the project name to the input parameter
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    //sets the username to the input parameter
    public void setUserName(String userName){
        this.userName = userName;
    }

    //sets the time spent on the project input parameter
    public void setTime(double time){
        this.time = time;
    }

    //sets the output for each of the variables
    @Override
    public String toString() {
        return "EffortLog{" +
                "Project Type ='" + projectType + '\'' +
                ", Project Name ='" + projectName + '\'' +
                ", Time ='" + time + '\'' +
                ", User Name ='" + userName + '\'' +
                '}';
    }
}