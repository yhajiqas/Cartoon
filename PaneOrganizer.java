package Cartoon;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
/* this is my PaneOrganizer class which has the following methods/private classes:
SetupTimeLine(): sets up the timeline and animations.
getRoot(): allows the scene to present the pane (canvas).
setUpButton(): sets up the quit button by instantiateing a button and holding it within a VBox.
changeColor(): uses switch statement to change the color of the composite shape and the label above it. 
private class TimeHandler: handles the actions that should be done within the timeline method.
private class keyHandler: handles the action that should be done by the quit button which is quitting the game.
*/


public class PaneOrganizer {
	private BorderPane _root;
	private VBox _buttonPane;
	private Game _game;
	private Label _label;
	private Timeline _timeline;
	private int _num;
	
	
	public PaneOrganizer(){
		_root = new BorderPane();
		_root.setStyle("-fx-background-color: black;");
		_root.setPrefSize(400,400);
		Pane cartoonPane = new Pane();
		_game = new Game(cartoonPane);
		_root.setCenter(cartoonPane);
		_label = new Label("Hello Rainbow Lovers!");
		_label.setTextFill(Color.RED);
		_root.setTop(_label);
		this.setupTimeline();
		this.setupButton();

	}
	
	public void setupTimeline(){
		KeyFrame keyframe = new KeyFrame(Duration.seconds(2), new TimeHandler());
		_timeline = new Timeline(keyframe);
		_timeline.setCycleCount(Animation.INDEFINITE);
		_timeline.play();
		
	}
	
	public Pane getRoot(){
		return _root;
	}
	
	public void setupButton(){
		_buttonPane = new VBox();
		Button btn = new Button("Quit");
		_buttonPane.getChildren().add(btn);
		_root.setBottom(_buttonPane);
		btn.setOnAction(new ClickHandler());		
	}
	
	public void changeColor(){
		switch (_num) {
		case 0:
			_num = 1;
			_game.setColor(Color.RED);
			_label.setText("This Color Is Red!");
			_label.setTextFill(Color.RED);
			break;
		case 1:
			_num = 2;
			_game.setColor(Color.ORANGE);
			_label.setText("This Color Is Orange!");
			_label.setTextFill(Color.ORANGE);
			break;
		case 2:
			_num = 3;
			_game.setColor(Color.YELLOW);
			_label.setText("This Color Is Yellow!");
			_label.setTextFill(Color.YELLOW);
			break;
		case 3:
			_num = 4;
			_game.setColor(Color.GREEN);
			_label.setText("This Color Is Green!");
			_label.setTextFill(Color.GREEN);
			break;
		case 4: 
			_num = 5;
			_game.setColor(Color.BLUE);
			_label.setText("This Color Is Blue!");
			_label.setTextFill(Color.BLUE);
			break;
		case 5:
			_num = 6;
			_game.setColor(Color.INDIGO);
			_label.setText("This Color Is Indigo!");
			_label.setTextFill(Color.INDIGO);
			break;
		case 6:
			_num = 7;
			_game.setColor(Color.VIOLET);
			_label.setText("This Color Is Violet!");
			_label.setTextFill(Color.VIOLET);
			break;
		default:
			_game.setColor(Color.RED);
			_label.setText("This Color Is Red!");
			_label.setTextFill(Color.RED);
			break;
		}
	}
	
	private class TimeHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			PaneOrganizer.this.changeColor();
			
			
			if (_game.getYLoc() < 330){
				_game.setYLoc(_game.getYLoc() + 15);
			} else{
				_timeline.stop();
				_label.setText("Now You Know the Colors of Rainbow!");
			}
		}
	}
	
	private class ClickHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event){
			System.exit(0);
		}
	}
}

