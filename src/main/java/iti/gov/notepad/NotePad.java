package iti.gov.notepad;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class NotePad extends BorderPane {

    Stage stage;
    

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final MenuItem menuItem1;
    protected final MenuItem menuItem2;
    protected final Menu menu0;
    protected final MenuItem menuItem3;
    protected final MenuItem menuItem4;
    protected final MenuItem menuItem5;
    protected final MenuItem menuItem6;
    protected final MenuItem menuItem7;
    protected final MenuItem menuItem8;
    protected final Menu menu1;
    protected final MenuItem menuItem9;
    protected TextArea textArea;
    NotepadFaction function;

    public NotePad(Stage stage) {

        this.stage=stage;

        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menuItem1 = new MenuItem();
        menuItem2 = new MenuItem();
        menu0 = new Menu();
        menuItem3 = new MenuItem();
        menuItem4 = new MenuItem();
        menuItem5 = new MenuItem();
        menuItem6 = new MenuItem();
        menuItem7 = new MenuItem();
        menuItem8 = new MenuItem();
        menu1 = new Menu();
        menuItem9 = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New");
        menuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Open");
        menuItem0.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Save");
        menuItem1.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Exit");

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Undo");

        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Cut");

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Copy");

        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Paste");

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Delete");

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("SelectAll");

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        menuItem9.setMnemonicParsing(false);
        menuItem9.setText("About");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(menuItem);
        menu.getItems().add(menuItem0);
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItem3);
        menu0.getItems().add(menuItem4);
        menu0.getItems().add(menuItem5);
        menu0.getItems().add(menuItem6);
        menu0.getItems().add(menuItem7);
        menu0.getItems().add(menuItem8);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(menuItem9);
        menuBar.getMenus().add(menu1);

        function = new NotepadFaction(textArea);

        //new 
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                function.createNewFile();
            }
        });  

        //open
        menuItem0.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                function.openExisitingFile();
            }
        }); 
        
        //save
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                function.saveFile();
            }
        }); 

        //exit
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("exit");
                 System.exit(0);

            }
        }); 

        //undo
        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("undo");
                textArea.undo();
            }
        }); 

        //cut
        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("cut");
                textArea.cut();
            }
        }); 

        //copy
        menuItem5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("copy");
                textArea.copy();
            }
        }); 

        //paste
        menuItem6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("paste");
                textArea.paste();
            }
        }); 

        //delete
        menuItem7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("delete");
                textArea.deleteText(textArea.getSelection());
            }
        }); 

        //select
        menuItem8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("selectAll");
                textArea.selectAll();
            }
        }); 

        menuItem9.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("about");

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("About");
                alert.setHeaderText("Ntepad Information");
                alert.setContentText("This is first release of my Notepad apllication \n @author Marwa");
                alert.showAndWait();
            }
        }); 

        textArea.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
            // this will run whenever text is changed
            System.out.println("text changed");
            function.setIsSaved(false);
           
        }
    });
        
    }
/*
public void createDialog() {
    //dialog creation
Dialog<String> dg = new Dialog<String>();
//set title
dg.setTitle("Notepad");
//Label myLabel = new Label();

//Set dialog content
dg.setContentText("Do you want to save changes?");


Button notSaveButton = new Button("don't save");
Button saveButton = new Button("Save");
Button cancelButton = new Button("cancel");

//To the dialog pane, add the buttons
dg.getDialogPane().addAll(saveButton,notSaveButton,cancelButton);

EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("   button   selected    ");
            }
        };
saveButton.setOnAction(event);
//Dialog display on button clicking

dg.showAndWait();

}
*/
     
    
}
