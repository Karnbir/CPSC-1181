public class DataSet {
    Measure measure;
    Object maximum;

    Double largestArea;

    public DataSet(Measure measurer) {
        maximum = null;
        measure = measurer;
    }

    public void changeMeasurer(Measure measurer){
        measure = measurer;
    }

    public void add(Object anObj) {
        if (maximum == null) {
            largestArea = measure.getMeasure(anObj);
            maximum = anObj;
        }

        if (largestArea < measure.getMeasure(anObj)) {
            maximum = anObj;
            largestArea = measure.getMeasure(anObj);
        }
    }

    public void showLargest() {
        System.out.println("The largest shape is a " + maximum.getClass().getName() +" with an area of " + largestArea);
    }
}