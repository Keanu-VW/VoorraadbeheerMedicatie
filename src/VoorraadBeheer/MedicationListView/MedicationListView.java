package VoorraadBeheer.MedicationListView;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MedicationListView extends BorderPane{
    private static BorderPane medicationListViewRoot = new BorderPane();
    public static Scene scene;


    public MedicationListView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes(){

    }
    private void layoutNodes(){
         scene = new Scene(medicationListViewRoot, 400, 500);




    }
    public BorderPane getMedicationListViewRoot() {
        return medicationListViewRoot;
    }




}
