package measthis is urer;


public class DataSet {

    private double sum;
    private Object maximum;
    private int count;
    private Measurer measurer;
    private double largestArea;

    public DataSet(Measurer aMeasure) {
        sum = 0;
        count = 0;
        maximum = null;
        measurer = aMeasure;
        largestArea = 0;

    }

    public void add(Object x) {
        sum = sum + measurer.measure(x);

        if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
            maximum = x;
            largestArea = measurer.measure(x);
        }

        count++;
    }

    public double getAverage() {
        if(count == 0 ) {
            throw new IllegalArgumentException("divided by 0!!! nope!!!");
        }
        return sum / count;

    }

    public Object getMaximum() {
        return maximum;
    }

    public double getLargestArea() {
        return largestArea;
    }
}

