package VoorraadBeheer.MedicationListView;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MedicationListView extends BorderPane{
    private static BorderPane medicationListViewRoot = new BorderPane();
    public static Scene scene=new Scene(medicationListViewRoot, 400, 500);


    public MedicationListView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes(){

    }
    private void layoutNodes(){
         this.scene = scene;




    }
    public BorderPane getMedicationListViewRoot() {
        return medicationListViewRoot;
    }




}
