///Author: Sishir Vallurupalli
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    public Login() {
    }

    @FXML
    private Button button;

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;

    @FXML
    private TextField passwordText;

    @FXML
    private Button resetPassword;

    @FXML
    private Button signUp;

    // Variables to keep track of attempts and unlockCounter
    private int attempts = 0;
    private int unlockCounter = 0;

    // Login method called when the user clicks the login button
    public void login(ActionEvent event) throws IOException {
        // Check if the user has reached the maximum number of attempts
        if (attempts >= 3) {
            // If the user has reached the unlock counter limit, lock the account and require a password reset
            if (unlockCounter >= 1) {
                wrongLogIn.setText("Account locked. Please reset your password.");
                button.setDisable(true);
                return;
            } else {
                // If the user has not reached the unlock counter limit, show an error message and start the unlock timer
                wrongLogIn.setText("Too many attempts. Please try again later.");
                button.setDisable(true);
                startUnlockTimer();
                return;
            }
        }

        Main m = new Main();

        // Retrieve the list of users
        ArrayList<UserInfo> users = m.getUsers();

        // Get the entered username and password
        String user = username.getText().toString();
        String pass = passwordText.getText().toString();
        boolean loggedIn = false;

        // Iterate through the list of users to check if the entered username and password match any user
        for (int x = 0; x < users.size(); x++) {
            if (users.get(x).getUserName().equals(user)) {
                if (users.get(x).getPassword().equals(pass)) {
                    // If a match is found, set the current user and change the scene to the main menu
                    m.setCurrentUser(users.get(x));
                    m.changeScene("Menu.fxml");
                    loggedIn = true;
                    break;
                }
            }
        }

        // If no match is found, increment the attempts counter and display an error message
        if (!loggedIn) {
            wrongLogIn.setText("Wrong Log In Information");
            attempts++;
            // If the user reaches the maximum number of attempts
            if (attempts >= 3) {
                // If the user has reached the unlock counter limit, lock the account and require a password reset
                if (unlockCounter >= 1) {
                    wrongLogIn.setText("Account locked. Please reset your password.");
                    button.setDisable(true);
                } else {
                    // If the user has not reached the unlock counter limit, show an error message and start the unlock timer
                    wrongLogIn.setText("Too many attempts. Please try again later.");
                    button.setDisable(true);
                    startUnlockTimer();
                }
            }
        }
    }
    
    // Method to start the unlock timer
    private void startUnlockTimer() {
        // Create a pause transition with a specified duration (240 seconds in this case)
        PauseTransition pause = new PauseTransition(Duration.seconds(240));
        // Set an event handler that will be executed when the pause transition is finished
pause.setOnFinished(e -> {
// Re-enable the login button
button.setDisable(false);
// Reset the attempts counter
attempts = 0;
// Clear the error message
wrongLogIn.setText("");
// Increment the unlock counter
unlockCounter++;
});
// Start the pause transition
pause.play();
}
    // Method called when the user clicks the reset password button
public void ResetPassword(ActionEvent event) throws IOException {
    Main m = new Main();
    // Change the scene to the reset password screen
    m.changeScene("ResetPassword.fxml");
}

// Method called when the user clicks the sign-up button
public void SignUp(ActionEvent event) throws IOException {
    Main m = new Main();
    // Change the scene to the sign-up screen
    m.changeScene("SignUp.fxml");
    }
}
