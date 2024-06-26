/**
 * Program Name: College Tester
 * Author Name: Karnbir Randhawa
 * Course: CPSC 1181
 * Date: February 5, 2024
 * JDK: 21
 */

import java.util.*;
public class CollegeTester {
    /**
     * This program is to test the proper functionality of college.java class, it attempts to achieve full code
     * coverage of the class by presenting a menu to a user to test each capability of the class.
     */

    public static void main(String[] args) {
        boolean repeat = true;

        College langara = new College();
        System.out.println("Welcome to Langara College");

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    \nPlease choose an option from the menu:
                    1. Add a Student
                    2. Remove a Student
                    3. Look up a Student
                    4. Add a course for a Student
                    5. Get Login ID for a Student
                    6. Find the Student with the highest GPA
                    7. Calculate Tuition Fees for a Student
                    8. Compare Student
                    9. Exit Program""");
            try {
            int choice = input.nextInt();

                switch (choice) {
                    case 1: addStudent(langara); break;
                    case 2: removeStudent(langara); break;
                    case 3: lookUpStudent(langara); break;
                    case 4: addCourse(langara); break;
                    case 5: getLoginID(langara); break;
                    case 6: findHighestGPA(langara); break;
                    case 7: getTuitionFees(langara); break;
                    case 8: equalsTest(langara); break;
                    case 9: repeat = false;break;
                    default: throw new InputMismatchException();
                }
            } catch (InputMismatchException exception) {
                System.out.println("ERROR: Please only enter a number shown on the menu");
            }
        } while (repeat);

    }

    /**
     * This method prints a menu of the type of student the user wishes to add and then activates the relevant method
     * @param langara is an object of college class
     */
    public static void addStudent(College langara) {
        System.out.println("""
                Which type of student would you like to add?
                1. Domestic Student
                2. International Student
                3. Graduate Student""");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        try {
            switch (choice) {
                case (1): addDomesticStudent(langara); break;
                case (2): addInternationalStudent(langara); break;
                case (3): addGraduateStudent(langara); break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException exception) {
            System.out.println("ERROR:Please only enter an option shown on the menu");
        }
    }

    /**
     * This method tests add student function and does error handing within the method to make sure college class
     * gets an appropriate input
     * @param langara is an object of college class
     */
    public static void addDomesticStudent(College langara) {
        boolean valid;
        String name;

        //check if name is valid
        do {
            System.out.println("Please enter the student's first and last name:");
            Scanner input = new Scanner(System.in);
            name = input.nextLine();
            valid = validateName(name);

        } while (!valid);

        if (valid) {
            System.out.println("Please enter the student's address:");
            Scanner input = new Scanner(System.in);
            String address = input.nextLine();

            //construct student object and send to college while printing the student's info
            Student newStudent = new Student(name,address);
            System.out.println(langara.addStudent(newStudent));
        }
    }

    /**
     * This method tests add international student function and does error handing within the method to make sure college class
     * gets an appropriate input
     * @param langara is an object of college class
     */
    public static void addInternationalStudent(College langara) {
        boolean valid;
        String name;

        //check if name is valid
        do {
            System.out.println("Please enter the student's first and last name:");
            Scanner input = new Scanner(System.in);
            name = input.nextLine();
            valid = validateName(name);

        } while (!valid);

        if (valid) {
            System.out.println("Please enter the student's address:");
            Scanner input = new Scanner(System.in);
            String address = input.nextLine();

            System.out.println("Please enter the student's country:");
            input = new Scanner(System.in);
            String country = input.nextLine();

            //construct international student object and send to college while printing the student's info
            Student newStudent = new InternationalStudent(name,address,country);
            System.out.println(langara.addStudent(newStudent));
        }
    }

    /**
     * This method tests add graduate student function and does error handing within the method to make sure college class
     * gets an appropriate input
     * @param langara is an object of college class
     */
    public static void addGraduateStudent(College langara) {
        boolean valid;
        String name;

        //check if name is valid
        do {
            System.out.println("Please enter the student's first and last name:");
            Scanner input = new Scanner(System.in);
            name = input.nextLine();
            valid = validateName(name);

        } while (!valid);

        if (valid) {
            System.out.println("Please enter the student's address:");
            Scanner input = new Scanner(System.in);
            String address = input.nextLine();

            System.out.println("Please enter the student's research topic:");
            input = new Scanner(System.in);
            String researchTopic = input.nextLine();

            System.out.println("Please enter the student supervisor's name:");
            input = new Scanner(System.in);
            String supervisor = input.nextLine();

            //construct Graduate student object and send to college while printing the student's info
            Student newStudent = new GraduateStudent(name,address,researchTopic,supervisor);
            System.out.println(langara.addStudent(newStudent));
        }
    }

    /**
     * Allows user to remove a student using a student number
     * @param langara is an object of college class
     */
    public static void removeStudent(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        if (validStudentNum(langara, studentNum)) {
            int num = Integer.parseInt(studentNum);
            System.out.println(langara.toString(num) + "\nHas been removed!");
            langara.deleteStudent(num);
        }
    }

    /**
     * Allows user to look up a student in the college class using student number
     * @param langara is an object of college
     */
    public static void lookUpStudent(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        if (validStudentNum(langara, studentNum)) {
            int num = Integer.parseInt(studentNum);
            System.out.println(langara.toString(num));
        }
    }

    /**
     * Allows user to add a course to a student's record from college class using student number
     * @param langara is an object of college class
     */
    public static void addCourse(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        if (validStudentNum(langara, studentNum)) {
            int num = Integer.parseInt(studentNum);

            System.out.println("Please enter the number of credits the course is worth");
            input = new Scanner(System.in);
            int credit = input.nextInt();

            System.out.println("Please enter the grade point achieved for the course");
            input = new Scanner(System.in);
            double gradePoint = input.nextDouble();

            if (langara.addCourse(num, credit, gradePoint)) {
                System.out.println("Course added to student record");
            } else {
                System.out.println("ERROR: Course not added to student record");
            }
        }
    }

    /**
     * Finds a student's loginID using college class
     * @param langara is an object of college class
     */
    public static void getLoginID(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        if (validStudentNum(langara, studentNum)) {
            int num = Integer.parseInt(studentNum);
            System.out.println("Login ID: " + langara.getLoginId(num));
        }
    }

    /**
     * Finds the student with the highestGPA in the college class, no additional input required from user
     * @param langara is an object of college class
     */
    public static void findHighestGPA(College langara) {
        String highestGPA = langara.highestGPA();

        if (!highestGPA.isEmpty()) {
            System.out.println(langara.highestGPA() + " has the highest GPA");
        } else {
            System.out.println("ERROR: Highest GPA not found");
        }
    }

    /**
     * Validates if student number is properly formatted and present in the college class
     * @param langara    is object of college
     * @param studentNum is a string entered by user representing the student's number
     * @return true if student number is valid, if false, prints messages to console and return false
     */
    public static boolean validStudentNum(College langara, String studentNum) {

        //check to see if student number only contains digits
        for (int i = 0; i < studentNum.length(); i++) {
            if (!Character.isDigit(studentNum.charAt(i))) {
                System.out.println("ERROR: Student number must only contain digits");
                return false;
            }
        }

        //student number length check
        if (studentNum.length() > 8) {
            System.out.println("ERROR: Student number must be 8 digits long");
            return false;
        }
        //convert student number string to number
        int num = Integer.parseInt(studentNum);

        //student numbers start at 10000001, reject any number less than that
        if (num < 10000001) {
            System.out.println("ERROR: Student number must be over 10000000");
            return false;
        }

        //check if  student number is present in college
        if (langara.toString(num) == null) {
            System.out.println("ERROR: Student not found!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks for valid name input
     * @param name name of student as entered by user
     * @return true if name is valid, false if name is invalid
     */
    public static boolean validateName (String name) {
        name = name.trim();

        if (name.isEmpty()) {
            System.out.println("ERROR: Name cannot be empty");
            return false;
        }

        int space = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                System.out.println("ERROR: Numbers are not allowed in the name");
                return false;
            }
            if (name.charAt(i) == ' ') {
                space++;
                if (space > 1) {
                    System.out.println("ERROR: Please only enter a first and last name seperated by 1 space");
                    return false;
                }
            }
        } return true;
    }

    /**
     * Calculates tuition fee for student in college from student number
     * @param langara is a college object passed from main
     */
    public static void getTuitionFees(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        if (validStudentNum(langara, studentNum)) {
            int num = Integer.parseInt(studentNum);
            System.out.println("Tuition Fee: $" + langara.getTuitionFee(num));
        }
    }

    /**
     * Tests equals method from student classes, lets user compare two students using student number
     * @param langara is a college object
     */
    public static void equalsTest(College langara) {
        System.out.println("Please enter the student's student number");
        Scanner input = new Scanner(System.in);
        String studentNum = input.nextLine();

        //validate first number and continue
        if (validStudentNum(langara, studentNum)) {
            int num1 = Integer.parseInt(studentNum);
            System.out.println("Please enter the other student's student number");
            input = new Scanner(System.in);
            String studentNum2 = input.nextLine();

            //validate second number and continue
            if (validStudentNum(langara, studentNum2)) {
                int num2 = Integer.parseInt(studentNum2);
                Student one = langara.toString(num1);
                Student two = langara.toString(num2);

                boolean equals = one.equals(two); //call equals method

                if (equals) {
                    System.out.println("Students are equal");
                } else {
                    System.out.println("Students are not equal");
                }
            }
        }
    }
}