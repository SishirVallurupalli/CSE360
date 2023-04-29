
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Defect {
    private StringProperty type;
    private StringProperty details;
    private StringProperty username;

    public Defect(String type, String details, String username) {
        this.type = new SimpleStringProperty(type);
        this.details = new SimpleStringProperty(details);
        this.username = new SimpleStringProperty(username);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getDetails() {
        return details.get();
    }

    public void setDetails(String details) {
        this.details.set(details);
    }

    public StringProperty detailsProperty() {
        return details;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public StringProperty usernameProperty() {
        return username;
    }
}
