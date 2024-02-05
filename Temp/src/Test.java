import java.util.ArrayList;

public class Test {
    public static void main (String [] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("A");
        names.add(0,"B");
        names.add(0,"C");
        names.remove(1);

        for (String i:names) {
            System.out.println(i);
        }

    }

}
