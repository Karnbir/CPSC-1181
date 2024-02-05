public class Student {
    /**
     * Student is a class to store and compute information about a student such as name address loginId and GPA
     */

    private String name, address, loginId;
    protected int credits;
    private double creditFee = 107.62;
    private final int STUDENT_NUM;
    private double gradePoints;

    //nextStudentNum will be incremented each time a new student is created
    private static int nextStudentNum = 10000001;

    public Student(String name, String address) {
        this.name = name.trim();
        this.address = address.trim();
        STUDENT_NUM = nextStudentNum++; //increment student num by 1 after generating student
    }

    public String getName() {
        return name;
    }
    public String getAddress () {
        return address;
    }
    public int getStudentsNum() {
        return STUDENT_NUM;
    }
    /**
     Updates student's file with the credits and grade point achieved by course
     @param credits the number of credits the course is worth
     @param gradePoints is the grade achieved in the course in grade point format.
     */
    public void addCourse(int credits, double gradePoints) {
        this.credits += credits;
        this.gradePoints += gradePoints * credits; //grades are weighted based on credits
    }
    /**
     * Calculates GPA using student's gradepoints and credits from addCourse
     @return the student's current GPA
     */
    public double calculateGPA () {
        if (credits == 0) { //avoids divide by zero error
            return 0;
        } else {
            return gradePoints / credits;
        }
    }

    /**
     Uses student's first name, last name, and student number to generate a login ID
     @return loginId as a string for the student
     */
    public String getLoginId() {
        String firstname = name.substring(0,1);
        String lastname = name.substring(name.indexOf(" ") + 1);
        //loginId only allows up to 3 characters of last name
        if (lastname.length() > 3) {
            lastname = lastname.substring(0,3);
        }
        //adds last two digits of studentNum to end of loginId
        String twoDigits = String.format("%02d",(STUDENT_NUM % 100000));
        String genLogin = firstname + lastname + twoDigits;
        loginId = genLogin.toLowerCase();
        return loginId;
    }

    /**
     * Calculates student's fees for a course based on number of credits
     */
    public double getTuitionFees() {
        return credits * creditFee;
    }

    @Override
    public String toString() {
        return "Student: " + getName() +
                "\n Address: " + getAddress() +
                "\n LoginID: " + getLoginId() +
                "\n Student Number: " + getStudentsNum() +
                "\n GPA: " + calculateGPA() +
                "\n Tuition Fees: $" + getTuitionFees();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if(getClass() != other.getClass()) {
            return false;
        }

        Student otherS = (Student) other;
        return toString().equals(otherS.toString());
    }
}