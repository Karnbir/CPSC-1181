import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DataSetTester {
    public static void main (String [] args) {
         class RectMeasure implements Measure {
            @Override
            public double getMeasure(Object anObj) {

                double area;

                Rectangle temp = (Rectangle)anObj;

                area = temp.getWidth()*temp.getHeight();
                return area;
            }
        }

        class CircleMeasure implements Measure {
             @Override
            public double getMeasure(Object anObj) {
                 double area;
                 Circle temp = (Circle)anObj;

                 area = Math.PI*Math.pow(temp.getRadius(),2);
                 return area;
             }
        }

        Measure r = new RectMeasure();
         DataSet data = new DataSet(r);

         data.add(new Rectangle(7,2));

         Measure c = new CircleMeasure();
         data.changeMeasurer(c);
         data.add(new Circle(5));

         data.showLargest();

    }
}
