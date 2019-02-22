package Cartoon;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
/*
 * this is my game class. it uses two different shapes to make up the composite shape. it also has setter/getter methods that set/get the location of
 * the composite shape.the color of the rectangle stays the same and the color of the ellipse changes according to the changeColor method found in the 
 * paneOrganizer class. 
 * 
 */
public class Game {
	private Rectangle _rect;
	private Ellipse _circle;
	
	public Game(Pane cartoonPane){
		
		_rect = new Rectangle(100,100,Color.WHITE);
		_circle = new Ellipse(50,50);
		_circle.setFill(Color.RED);
		cartoonPane.getChildren().addAll(_rect,_circle);
		this.setXLoc(200);
		this.setYLoc(205);
	}
	
	public double getYLoc(){
		return _circle.getCenterY();
	}
	public void setXLoc(double x){
		_circle.setCenterX(x);
		_rect.setX(x-50);
	}
	public void setYLoc(double y){
		_circle.setCenterY(y);
		_rect.setY(y-50);
	}
	public void setColor(Color color){
		_circle.setFill(color);
	}
	public Node getNode(){
		return _circle;
	}
}
