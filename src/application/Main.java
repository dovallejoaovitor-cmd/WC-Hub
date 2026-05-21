package application;


import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.dao.GroupDAO;
import model.dao.NationalTeamDAO;
import model.entities.Group;
import model.entities.NationalTeam;

public class Main extends Application{

	public static void main(String[] args){
			
		GroupDAO groupDao =
			    DaoFactory.createGroupDao();

			NationalTeamDAO ntDao =
			    DaoFactory.createNationalTeamDao();

			List<Group> groups =
			    groupDao.findAll();

			for(Group gp : groups) {

			    System.out.println(
			        gp.getName()
			    );

			    List<NationalTeam> teams =
			        ntDao.findByGroup(gp);

			    for(NationalTeam team : teams) {

			        System.out.println(
			            team.getName()
			        );
			    }

			    System.out.println();
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


