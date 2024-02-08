import java.sql.Array;
import java.util.ArrayList;
public class ArrayListTester {

    public static void main (String [] args) {
        ArrayList<String> myList = new ArrayList<String>();

        myList.add("Hello");
        myList.add("World");
        myList.add(1,"Karnbir");
        myList.remove(2);
        myList.set(1,"Yen");
        System.out.println(myList);
    }
}
