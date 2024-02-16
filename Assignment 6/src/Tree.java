import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Tree {
    private Rectangle trunk;
    private Ellipse leaves;
    private Rectangle box;

    public Tree(int x, int y){

        trunk = new Rectangle(x-10, y -100, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(x, y, 5, 5);

        leaves = new Ellipse(x, y-100, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));
    }

    public Tree(int x, int y, int width, int height, Color color) {

        //calculate trunk width based on size of leaves
        // width is given higher weighting for trunk width than height
        int trunk_width = (width/4)+(height/200);

        //1.25 on multipliers on height to better match reference image on A6-GUI.pdf
        trunk = new Rectangle(x-trunk_width/2,y-height/1.25,trunk_width,height/1.25);
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(x,y,5,5);

        // Divide by width and height by 2 since its ellipse expects radius not diameter
        leaves = new Ellipse(x,y-height/1.25,width/2,height/2);
        leaves.setFill(color);
    }
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves, box};
    }
}
