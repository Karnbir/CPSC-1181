public class Student {
    /**
     * Student is a class to store and compute information about a student such as name address loginId and GPA
     */

    private String name, address, loginId;
    private int credits;
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
    public void addCourse(int credits, double gradePoints) {
        this.credits += credits;
        this.gradePoints += gradePoints * credits; //grades are weighted based on credits
    }
    public double calculateGPA () {
        if (credits == 0) { //avoids divide by zero error
            return 0;
        } else {
            return gradePoints / credits;
        }
    }

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
}