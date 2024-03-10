public class GraduateStudent extends Student {
    /**
     * Graduate student is a class that adds graduate student specific functionality to student class
     */
    private String researchTopic;
    private String supervisor;

    /**
     * Constructs Graduate Student object
     * @param name student's name
     * @param address student's address
     * @param researchTopic graduate student's research topic
     * @param supervisor name of student's supervisor
     */
    public GraduateStudent (String name, String address, String researchTopic, String supervisor) {
        super(name,address);
        this.researchTopic = researchTopic;
        this.supervisor = supervisor;
    }

    /**
     * Get value of researchTopic variable
     * @return graduate student's research topic
     */
    public String getResearchTopic() {
        return researchTopic;
    }

    /**
     * Get value of supervisor variable
     * @return name of student's supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Returns graduate student instance variables as String
     * @return string block
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n Research Topic: " + getResearchTopic() +
                "\n Supervisor: " + getSupervisor();
    }

    /**
     * Checks to see if two graduate students are identical
     * @param otherObject is other student object
     * @return true or false if identical
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
                return false;
        if (getClass() != otherObject.getClass())
            return false;
        GraduateStudent other = (GraduateStudent) otherObject;

        return super.getName().equals(other.getName()) &&
                super.getAddress().equals(other.getAddress()) &&
                super.calculateGPA() == other.calculateGPA() &&
                researchTopic.equals(other.getResearchTopic()) &&
                supervisor.equals(other.getSupervisor());
    }
}
