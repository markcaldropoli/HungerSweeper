import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class TableViewSample extends Application {
 
    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("HS");
        stage.setWidth(1230);
        stage.setHeight(480);
 
        final Label label = new Label("HungerSweeper");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn z = new TableColumn("0");
        TableColumn o = new TableColumn("1");
        TableColumn t = new TableColumn("2");
        TableColumn th = new TableColumn("3");
        TableColumn f = new TableColumn("4");
        TableColumn fi = new TableColumn("5");
        TableColumn s = new TableColumn("6");
        TableColumn se = new TableColumn("7");
        TableColumn e = new TableColumn("8");
        TableColumn n = new TableColumn("9");
        TableColumn te = new TableColumn("10");
        TableColumn el = new TableColumn("11");
        TableColumn tw = new TableColumn("12");
        TableColumn thi = new TableColumn("13");
        TableColumn fo = new TableColumn("14");

        
        table.getColumns().addAll(z,o,t,th,f,fi,s,se,e,n,te,el,tw,thi,fo);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}