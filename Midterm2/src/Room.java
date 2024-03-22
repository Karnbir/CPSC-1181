import java.awt.Color;
/**
 * A room has a width, a length and a color.
 */
public abstract class Room {
    // The MIN_ROOM_AREA is used in the getArea methods by the Room subclasses
    public static final int MIN_ROOM_AREA = 6;
    public static final Color ROOM_COLOR = Color.WHITE;

    private Color color;
    private int width;
    private int length;

          // Room constructor
    public Room(int width, int length)
    {
        this.width = width;
        this.length = length;
        this.color = ROOM_COLOR;
    }

    // Override the equals method
    @Override
    public boolean equals(Object obj) {
        if (!getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }

        Room temp = (Room) obj;

        if (width == temp.getWidth() && length == temp.getLength()) {
            return true;
        }

        return false;

    }

    // Create an abstract method getArea.

    public abstract int getArea() throws Exception;

    public int getWidth() {
        return width;
    }
    public int getLength() {
        return length;
    }
}