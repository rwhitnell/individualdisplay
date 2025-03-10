package edu.guilford;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

import javafx.geometry.Insets;

public class IndividualPane extends GridPane {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    private TextField imageField;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private Label imageLabel;
    private Button submitButton;
    private Label formattedNameLabel;
    private ImageView avatar;

    // constructor
    public IndividualPane() {
        // instantiate the fields
        firstNameField = new TextField();  
        lastNameField = new TextField();
        emailField = new TextField();
        imageField = new TextField();
        firstNameLabel = new Label("First Name:");
        lastNameLabel = new Label("Last Name:");
        emailLabel = new Label("Email:");
        imageLabel = new Label("Image:");
        submitButton = new Button("Submit");
        formattedNameLabel = new Label();

        // add the fields to the gridpane, which requires a row, column, and column span
        this.add(firstNameLabel, 0, 0);
        this.add(lastNameLabel, 0, 1);
        this.add(emailLabel, 0, 2);
        this.add(imageLabel, 0, 3);
        this.add(firstNameField, 1, 0);
        this.add(lastNameField, 1, 1);
        this.add(emailField, 1, 2);
        this.add(imageField, 1, 3);
        this.add(submitButton, 2, 0, 2, 1);
        this.add(formattedNameLabel, 2, 1, 2, 1);
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        // set the action for the button
        submitButton.setOnAction(e -> {
            // get the text from the fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String image = imageField.getText();

            // create an individual object
            Individual individual = new Individual(firstName, lastName, email, image);

            File avatarFile = new File(this.getClass().getResource(individual.getAvatarImage()).getFile());
            avatar = new ImageView(avatarFile.toURI().toString());
            avatar.setPreserveRatio(true);
            avatar.setFitHeight(100);
            avatar.setRotate(90);
            this.add(avatar, 0, 4, 3, 1);


            // set the text of the label to the formatted name
            formattedNameLabel.setText(individual.toString());
        });
    }

}
