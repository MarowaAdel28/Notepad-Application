package iti.gov.notepad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class NotepadFaction {

    boolean isSaved=true;
    File openedFile=null;
    TextArea textArea;

    public NotepadFaction(TextArea textArea) {

        this.textArea=textArea;
        
    }

    public void saveFile() {

        System.out.println("save");

        if(openedFile==null) {
            openedFile=openFileDialog("save");
        }

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(openedFile));
            bf.write(textArea.getText());
            bf.flush();
            bf.close();
            this.isSaved=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewFile() {

        System.out.println("new file");
        if(this.isSaved) {
        textArea.selectAll();
        textArea.deleteText(textArea.getSelection());
        
        } else {
            saveFile();
            textArea.selectAll();
            textArea.deleteText(textArea.getSelection());
        }
        openedFile=null;
    }

    public void openExisitingFile() {

        System.out.println("open existing file");

        if(!this.isSaved) {saveFile();}
        
        openedFile=openFileDialog("open");
        System.out.println(openedFile);
        try {
            // Create a buffered stream
            Scanner input = new Scanner(new File(openedFile.toString()));

            textArea.selectAll();

            textArea.deleteText(textArea.getSelection());
            

            // Read a line and append the line to the text area
            while (input.hasNext()) {

                String txt=input.nextLine()+'\n';
                textArea.appendText(txt);
            }
            input.close();
         } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + openedFile);
         } catch (Exception ex) {
            System.out.println(ex.getMessage());
         }
    }

    public File openFileDialog(String openOrSave) {

        File fileName;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.txt"));
        if(openOrSave=="open")
            fileName = fileChooser.showOpenDialog(null);
        else 
            fileName = fileChooser.showSaveDialog(null);
        return fileName;

    } 

    public void setIsSaved(boolean isSaved) {
        this.isSaved=isSaved;
    }
    
}
