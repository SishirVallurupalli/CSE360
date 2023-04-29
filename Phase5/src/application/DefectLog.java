package application;
//Ahmed Alyahya
public class DefectLog {
    private String projectType;
    private String defectType;
    private String defectDetails;
    private String userName;

    public DefectLog(String projectType, String defectType, String defectDetails, String userName) {
        this.projectType = projectType;
        this.defectType = defectType;
        this.defectDetails = defectDetails;
        this.userName = userName;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getDefectType() {
        return defectType;
    }

    public String getDefectDetails() {
        return defectDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setDefectDetails(String defectDetails) {
        this.defectDetails = defectDetails;
    }

    @Override
    public String toString() {
        return "DefectLog{" +
                "projectType='" + projectType + '\'' +
                ", defectType='" + defectType + '\'' +
                ", defectDetails='" + defectDetails + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
