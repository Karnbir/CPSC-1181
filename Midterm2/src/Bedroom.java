/**
 * A bedroom is a room that may or may not have a balcony.
 * When calculating the area of the bedroom, we add the balcony's area
 * (if there is a balcony).
 */
public class Bedroom extends Room {
    // The area in square meters of the balcony.
    private static final int BALCONY_AREA = 1;

    // determines if the bedroom has a balcony
    private boolean hasBalcony;

    //Bedroom constructor
    public Bedroom (int width, int length, boolean hasBalcony){
        super(width,length);
        this.hasBalcony = hasBalcony;
    }

   // Override the getArea method

    @Override
    public int getArea() throws Exception {
        int area = getLength() * getWidth();

        if (hasBalcony) {
            area += BALCONY_AREA;
        }

        if (area < MIN_ROOM_AREA) {
             throw new Exception();
        }

        return area;
    }

    // Override the equals method

    @Override
    public boolean equals(Object obj) {
        if (!getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }

        Bedroom temp = (Bedroom) obj;

        if (super.getWidth() == temp.getWidth() && super.getLength() == temp.getLength() && hasBalcony == temp.hasBalcony) {
            return true;
        }
        return false;
    }
}
