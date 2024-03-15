package measurer;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class DataSetTester {
    public static void main(String[] args) {

        class RectMeasurer implements Measurer {

//            @Override
//            public double measure(Object anObject) {
//                Rectangle aRectangle = (Rectangle) anObject;
//                return aRectangle.getWidth() * aRectangle.getHeight();
//            }
//
//            @Override
//            public double circleMeasure(Object anObject) {
//                Circle aCircle = (Circle) anObject;
//                return Math.pow(aCircle.getRadius(), 2) * Math.PI;
//            }
            @Override
            public double measure(Object anObject) {

                double area = 0;
                if (anObject instanceof Rectangle) {
                    Rectangle aRectangle = (Rectangle) anObject;
                    area = aRectangle.getWidth() * aRectangle.getHeight();
                }
                if (anObject instanceof Circle) {
                    Circle aCircle = (Circle) anObject;
                    area = Math.pow(aCircle.getRadius(), 2) * Math.PI;
                }
                return area;
            }

        }

        try {
            Measurer m = new RectMeasurer();
            DataSet data = new DataSet(m);

            //data.add(new Rectangle(5, 10, 20, 30));
            //data.add(new Rectangle(10, 20, 30, 40));
            data.add(new Rectangle(7,2));

            //data.add(new Circle(5, 10, 5));
            //data.add(new Circle(5, 10, 10));
            data.add(new Circle(2));


            System.out.println("Average area = "
                    + data.getAverage());

            Object max = data.getMaximum();

            System.out.println("The biggest is " + max.getClass() + " " + data.getLargestArea());


        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

