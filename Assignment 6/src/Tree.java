import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Tree {
    /**
     * This class creates a tree using JavaFX
     */
    private Rectangle trunk;
    private Ellipse leaves;

    /**
     * This method constructs a default tree
     * @param x axis coordinate to place the generated tree
     * @param y axis coordinate to place the generated tree
     */
    public Tree(int x, int y){

        trunk = new Rectangle(x-10, y -100, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);

        leaves = new Ellipse(x, y-100, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));
    }

    /**
     * This method constructs a tree with user inputted tree width, height, and colour
     * @param x axis coordinate to place generated tree
     * @param y axis coordinate to place generated tree
     * @param width diameter for the width of the leaves
     * @param height to determine the height of the leaves
     * @param color of the leaves
     */
    public Tree(int x, int y, int width, int height, Color color) {

        //calculate trunk width based on size of leaves
        // width is given higher weighting for trunk width than height
        int trunk_width = (width/4)+(height/200);

        //1.25 on multipliers on height to better match reference image on A6-GUI.pdf
        trunk = new Rectangle(x-trunk_width/2,y-height/1.25,trunk_width,height/1.25);
        trunk.setFill(Color.SADDLEBROWN);

        // Divide by width and height by 2 since its ellipse expects radius not diameter
        leaves = new Ellipse(x,y-height/1.25,width/2,height/2);
        leaves.setFill(color);
    }

    /**
     * Collects all instance variables in the class in the proper order
     * @return Node array to add to the scene graph
     */
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves};
    }
}