import java.util.ArrayList;

public class College {
    /**
     * College is a class that stores student class variables as an arraylist
     */
    //instance variable
    private ArrayList<Student> list;

    //constructor
    public College() {
        list = new ArrayList<>();
    }

    /**
     * Adds a student object to arraylist and returns a string showing student info
     */
    public String addStudent(Student studentObj) {
        list.add(studentObj);
        return list.getLast().toString();
    }

    /**
     * Deletes a student from the arraylist
     * @param studentNumber is number of the student you wish to delete
     */
    public void deleteStudent(int studentNumber) {
        for (Student x : list) {
            if (studentNumber == x.getStudentsNum()) {
                list.remove(x);
                break;
            }
        }
    }

    /**
     * Gets the name of a student from student number
     * @param studentNumber is number of the student you want to identify
     * @return Name of the student, as an extra failsafe this method returns student not found if number is present
     */
    public Student toString(int studentNumber) {
        for (Student x : list) {
            if (studentNumber == x.getStudentsNum()) {
                return x;
            }
        }
        return null;
    }

    /**
     * Allows student to have a GPA by inputting course credits and grade achieved
     * @param studentNumber is number of the student whom you wish to add the course to
     * @param credits       is credits of the course
     * @param gradePoints   is the grade point achieved in the course
     * @return true or false if course was added successfully
     */
    public boolean addCourse(int studentNumber, int credits, double gradePoints) {
        for (Student x : list) {
            if (studentNumber == x.getStudentsNum()) {
                x.addCourse(credits, gradePoints);
                return true;
            }
        }
        return false;
    }

    /**
     * Return loginID of a student using student number
     * @param studentNumber is the number of the student whom you wish to find the Login ID for
     * @return LoginID as a string, if not found return Student not found.
     */
    public String getLoginId(int studentNumber) {
        for (Student x : list) {
            if (studentNumber == x.getStudentsNum()) {
                return x.getLoginId();
            }
        }
        return "Student not found";
    }

    /**
     * Find the student with the highestGPA in the college arraylist
     * @return name of the student with the highest GPA
     */
    public String highestGPA() {
        double highest = 0;
        String student = "";

        for (Student x : list) {
            if (x.calculateGPA() >= highest) {
                highest = x.calculateGPA();
                student = x.getName();
            }
        }
        return student;
    }

    /**
     * Calculates tuition fee for a student and returns the fee as a double
     * @param studentNumber used to find student in college
     * @return double representing fee
     */
    public double getTuitionFee(int studentNumber) {
        for (Student x : list) {
            if (studentNumber == x.getStudentsNum()) {
                return x.getTuitionFees();
            }
        }
        return 0;
    }
}