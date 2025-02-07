import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Course Class
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int registeredStudents;

    // Constructor
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    // Check availability
    public boolean isAvailable() {
        return registeredStudents < capacity;
    }

    // Register student
    public void registerStudent() {
        if (isAvailable()) {
            registeredStudents++;
        }
    }

    // Drop student
    public void dropStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }
}

// Student Class
class Student {
    private String studentId;
    private String name;
    private List<String> registeredCourses;

    // Constructor
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    // Register for a course
    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    // Drop a course
    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

// CourseRegistrationSystem Class
public class CourseRegistrationSystem {
    private Map<String, Course> courses;
    private Map<String, Student> students;

    public CourseRegistrationSystem() {
        courses = new HashMap<>();
        students = new HashMap<>();
    }

    // Add a new course
    public void addCourse(String courseCode, String title, String description, int capacity, String schedule) {
        courses.put(courseCode, new Course(courseCode, title, description, capacity, schedule));
    }

    // Add a new student
    public void addStudent(String studentId, String name) {
        students.put(studentId, new Student(studentId, name));
    }

    // Register student for a course
    public void registerCourse(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);

        if (course != null && student != null && course.isAvailable()) {
            course.registerStudent();
            student.registerCourse(courseCode);
            System.out.println("Student " + studentId + " registered for course " + courseCode);
        } else {
            System.out.println("Registration failed");
        }
    }

    // Drop student from a course
    public void dropCourse(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);

        if (course != null && student != null && student.getRegisteredCourses().contains(courseCode)) {
            course.dropStudent();
            student.dropCourse(courseCode);
            System.out.println("Student " + studentId + " dropped course " + courseCode);
        } else {
            System.out.println("Drop failed");
        }
    }

    // List all courses
    public void listCourses() {
        for (Course course : courses.values()) {
            System.out.println(course.getCourseCode() + ": " + course.getTitle() + " (" + course.getRegisteredStudents() + "/" + course.getCapacity() + " slots filled)");
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Add courses
        system.addCourse("CS101", "Intro to CS", "Basics of computing", 100, "Mon/Wed 10-11am");
        system.addCourse("MATH123", "Calculus I", "Differential calculus", 80, "Tue/Thu 12-1pm");

        // Add students
        system.addStudent("S001", "Alice Johnson");
        system.addStudent("S002", "Bob Smith");

        // Register students for courses
        system.registerCourse("S001", "CS101");
        system.registerCourse("S002", "CS101");

        // List courses
        system.listCourses();

        // Drop a course
        system.dropCourse("S001", "CS101");

        // List courses again
        system.listCourses();
    }
}
