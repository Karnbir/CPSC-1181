import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Animal {
    /**
     * This class creates a cat animal using JavaFX
     */
    private Ellipse body,head,lEye,lEyeP,rEye,rEyeP,lEar,rEar,nose,tail,arm,leg,collar;
    private Rectangle lWhisker1,lWhisker2,lWhisker3,rWhisker1,rWhisker2,rWhisker3,nameTag;
    private Text name;

    /**
     * This method constructs the cat
     * @param x axis coordinate to place the generated cat
     * @param y axis coordinate to place the generated cat
     */
    public Animal(int x, int y) {

        //for code reuse for the colour of the fur
        Color fur = Color.rgb(157,134,100);

        body = new Ellipse(x,y,100,40);
        body.setFill(fur);
        body.setStroke(Color.BLACK);

        arm = new Ellipse(x-60,y+25,40,10);
        arm.setFill(Color.rgb(153,144,120));
        arm.setStroke(Color.BLACK);

        leg = new Ellipse(x+60,y+25,40,10);
        leg.setFill(Color.rgb(153,144,120));
        leg.setStroke(Color.BLACK);

        tail = new Ellipse(x+120,y,5,40);
        tail.setFill(Color.rgb(153,144,120));
        tail.setStroke(Color.BLACK);
        tail.setRotate(-80);

        collar = new Ellipse(x-70,y-30,35,30);

        nameTag = new Rectangle(x-85,y,30,15);
        nameTag.setFill(Color.DODGERBLUE);
        nameTag.setStroke(Color.SILVER);

        name = new Text(x-85,y+11,"SIMBA");
        Font f = Font.font(10);
        name.setFont(f);
        name.setFill(Color.SILVER);

        lEar = new Ellipse(x-90,y-80,15,30);
        lEar.setRotate(-35);
        lEar.setFill(Color.rgb(225,230,231));
        lEar.setStroke(fur);
        lEar.setStrokeWidth(2);

        rEar = new Ellipse(x-50,y-80,15,30);
        rEar.setRotate(35);
        rEar.setFill(Color.rgb(225,230,231));
        rEar.setStrokeWidth(2);
        rEar.setStroke(fur);

        head = new Ellipse(x-70,y-50,40,40);
        head.setFill(Color.rgb(157,134,100));
        head.setStroke(Color.BLACK);

        nose = new Ellipse(x-70,y-45,7,3);
        nose.setFill(Color.LIGHTPINK);
        nose.setStroke(Color.BLACK);

        lEye = new Ellipse(x-85,y-60,10,10);
        lEye.setFill(Color.rgb(160,181,141));
        lEye.setStroke(Color.BLACK);

        rEye = new Ellipse(x-55,y-60,10,10);
        rEye.setFill(Color.rgb(160,181,141));
        rEye.setStroke(Color.BLACK);

        lEyeP = new Ellipse(x-87,y-60,4,7);
        lEyeP.setFill(Color.BLACK);

        rEyeP = new Ellipse(x-55,y-60,4,7);
        rEyeP.setFill(Color.BLACK);

        lWhisker1 = new Rectangle(x-120,y-45,40,1);
        lWhisker1.setRotate(10);
        lWhisker2 = new Rectangle(x-120,y-40,40,1);
        lWhisker3 = new Rectangle(x-120,y-35,40,1);
        lWhisker3.setRotate(-10);

        rWhisker1 = new Rectangle(x-60,y-45,40,1);
        rWhisker1.setRotate(350);
        rWhisker2 = new Rectangle(x-60,y-40,40,1);
        rWhisker3 = new Rectangle(x-60,y-35,40,1);
        rWhisker3.setRotate(10);
    }

    /**
     * Collects all instance variables in the class in the proper order
     * @return Node array to add to the scene graph
     */
    public Node [] getAllNodes(){
        return new Node[]{tail,arm,leg,body,collar, nameTag,name,lEar,rEar,head,nose,lEye,rEye,lEyeP,rEyeP,
        lWhisker1,lWhisker2,lWhisker3,rWhisker1,rWhisker2,rWhisker3};
    }
}