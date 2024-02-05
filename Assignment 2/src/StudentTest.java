/**
 * Program Name: StudentTest
 * Author: Karnbir Randhawa
 * Course: CPSC 1181
 * Date: January 18th 2024
 * JDK: 21
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {
    /**
     * This program uses JUnit to achieve compete code coverage of Student.java class. It verifies if student class
     * is giving expected output based on the parameters passed through and the order of the tests
     */

    @Order(1)
    @Test
    void getName() {
        String name = "Peter Thiel";
        String address = "9200 W Sunset Blvd Ste 1110 West Hollywood, CA, 90069-3616";
        Student peter = new Student (name,address);
        assertEquals(name,peter.getName());
    }

    @Order(2)
    @Test
    void getAddress() {
        String name = "George Soros";
        String address = "136 Cantitoe Street Katonah, New York";
        Student george = new Student (name,address);
        assertEquals(address,george.getAddress());
    }

    @Order(3)
    @Test
    void getStudentsNum() {
        String name = "Justin Escalona";
        String address = "900 W 34th St, Los Angeles, CA 90007, USA";
        Student justin = new Student (name,address);
        //expect 10000003 because this is the third student created in the sequence of tests
        assertEquals(10000003,justin.getStudentsNum());
    }

    @Order(4)
    @Test
    void calculateGPA() {
        String name = "Naval Ravikant";
        String address = "90 Gold St, San Francisco, California 94133, US";
        Student naval = new Student (name,address);
        naval.addCourse(4,4.3);
        naval.addCourse(2,3);
        naval.addCourse(3,4);
        assertEquals(3.91,naval.calculateGPA(),0.01);
    }

    @Order(5)
    @Test
    void getLoginId() {
        String name = "Barack O";
        String address = "1600 Pennsylvania Avenue NW, Washington, DC 20500, USA";
        Student barack = new Student (name,address);
        //since this is the 5th student we expect the student number to end with 05
        assertEquals("bo05",barack.getLoginId());
    }
}