public class InternationalStudent extends Student {
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

    @Override
    public double getTuitionFees() {
        return credits * creditFee;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Country: " + getCountry();
    }

    @Override
    public boolean equals(Object other) {
        return toString().equals(other.toString());
    }
}