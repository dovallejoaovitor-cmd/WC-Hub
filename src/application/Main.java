package application;


import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.dao.GroupDAO;
import model.entities.Group;

public class Main extends Application{

	public static void main(String[] args){
			
			GroupDAO gp = DaoFactory.createGroupDao();
			Group group = gp.findById(1);
			System.out.println(group);
			
			List<Group> list = gp.findAll();
			for (Group obj : list) {
				System.out.println(obj);
			}
			
		}

		
		public void start(Stage primaryStage){
			try {
				BorderPane root = new BorderPane();
				Scene scene = new Scene(root, 1900, 880);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	



	}


