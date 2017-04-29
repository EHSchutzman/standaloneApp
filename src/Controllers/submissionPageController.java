package Controllers;

import Entities.Form;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import Entities.Form;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Joe Lombardi on 4/29/2017.
 */
public class submissionPageController {

    private Form form;


    /**
     * Always pass a form to this controller upon instantiation
     * @param form
     */
    public submissionPageController(Form form) {
        this.form = form;
    }

    /**
     * But just in case you don't, here's an empty controller call that yields a null form.
     */
    public submissionPageController(){
        this.form = new Form();
        System.out.println("Form is Null");
    }

    public void setForm(Form theForm){
        this.form = theForm;
    }


    @FXML
    Button submitToTTB, printableForm;



    @FXML
    public void displayPrintable() throws IOException{
        System.out.println("Displaying Printable Version");

        Stage stage = new Stage();
        stage.setTitle("Workflow Results");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("printableVersion.fxml"));
        ScrollPane newWindow = loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(newWindow, 1020, 700);

        stage.setScene(scene);

        stage.setFullScreen(false);

        stage.getScene().setRoot(newWindow);
        stage.show();

        printableVersionController controller = loader.getController();
        controller.setFormPrintableVersion(this.form);
    }



    @FXML
    public void displaySubmit(){
        System.out.println("Submitting to TTB");
    }

}
