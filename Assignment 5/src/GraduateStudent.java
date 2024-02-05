public class GraduateStudent extends Student {
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

    @Override
    public String toString() {
        return super.toString() +
                "\n Research Topic: " + getResearchTopic() +
                "\n Supervisor: " + getSupervisor();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass()!= getClass()) {
            return false;
        }
        GraduateStudent other = (GraduateStudent) otherObject;
        return toString().equals(other.toString());
    }
}
