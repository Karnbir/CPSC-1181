import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Inheritance {
    private interface Shape {
        double calculateArea();
    }

    public static void main(String[] args){
         class Rectangle implements Shape {

            javafx.scene.shape.Rectangle rectangle;

            public Rectangle(int width,int height){
                this.rectangle = new javafx.scene.shape.Rectangle(width,height);
            }

            @Override
            public double calculateArea(){
                return rectangle.getHeight()*rectangle.getWidth();
            }
        }
         class Circle implements Shape {

            javafx.scene.shape.Circle circle;

            public Circle(int radius){
                this.circle = new javafx.scene.shape.Circle(radius);
            }

            @Override
            public double calculateArea() {
                return Math.PI*(Math.pow(circle.getRadius(),2));
            }
        }

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Rectangle(5,10));
        shapes.add(new Circle(5));

        for (Shape x : shapes) {
            System.out.println(x.calculateArea());
        }
    }
}
