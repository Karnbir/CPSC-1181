public class InternationalStudent extends Student {
    /**
     * International student is a class that adds international student functionality to student class
     */
    private String country;
    private double creditFee = 637.91;

    /**
     * Construct International Student object
     * @param name student's name
     * @param address student's address
     * @param country name of the country the student is coming from before studying
     */
    public InternationalStudent(String name, String address, String country) {
        super(name,address);
        this.country = country;
    }

    /**
     * Get value of country variable
     * @return name of the country the student is coming from before studying
     */
    public String getCountry () {
        return country;
    }

    /**
     * Calculates student's fees based on number of credits taken
     * @return fees as double
     */
    @Override
    public double getTuitionFees() {
        return super.credits * creditFee;
    }

    /**
     * Returns international graduate student instance variables as string
     * @return string block
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n Country: " + getCountry();
    }

    /**
     * Checks to see if two international students are identical
     * @param otherObject is other student object
     * @return true or false if identical
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
                return false;
        if (getClass() != otherObject.getClass())
            return false;

        InternationalStudent other = (InternationalStudent) otherObject;

        return super.equals(other) && country.equalsIgnoreCase(other.country);
    }
}