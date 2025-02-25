import java.util.ArrayList;
import java.util.List;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int capacity;
    private int enrolledStudents;
    private String prerequisite;

    public Course(String name, int capacity, String prerequisite) {
        this.name = name;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.prerequisite = prerequisite;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    public void enroll() throws CourseFullException {
        if (isFull()) {
            throw new CourseFullException("Course " + name + " is full. Cannot enroll.");
        }
        enrolledStudents++;
    }
}
class Students {
    private String name;
    private List<String> completedCourses;

    public Students(String name) {
        this.name = name;
        this.completedCourses = new ArrayList<>();
    }

    public void completeCourse(String course) {
        completedCourses.add(course);
    }

    public boolean hasCompleted(String course) {
        return completedCourses.contains(course);
    }

    public void enrollInCourse(Course course) throws CourseFullException, PrerequisiteNotMetException {
        if (course.getPrerequisite() != null && !hasCompleted(course.getPrerequisite())) {
            throw new PrerequisiteNotMetException("Complete " + course.getPrerequisite() + " before enrolling in " + course.getName());
        }
        course.enroll();
        System.out.println("Successfully enrolled in " + course.getName());
    }
}
public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Students student = new Students("Alice");
        Course coreJava = new Course("Core Java", 2, null);
        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        try {
            System.out.println("Attempting to enroll in Advanced Java...");
            student.enrollInCourse(advancedJava);
        } catch (PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nCompleting Core Java...");
        student.completeCourse("Core Java");

        try {
            System.out.println("Attempting to enroll in Advanced Java again...");
            student.enrollInCourse(advancedJava);
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}