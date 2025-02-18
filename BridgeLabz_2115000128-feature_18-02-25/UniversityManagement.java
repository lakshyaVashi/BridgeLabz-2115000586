import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;
    
    public CourseType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;
    
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public T getCourseType() {
        return courseType;
    }
    
    @Override
    public String toString() {
        return "Course: " + courseName + ", Type: " + courseType;
    }
}

class University {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        List<CourseType> courses = new ArrayList<>();
        
        courses.add(new ExamCourse("Mathematics"));
        courses.add(new AssignmentCourse("History"));
        courses.add(new ResearchCourse("Physics"));
        
        System.out.println("Available Courses:");
        University.displayCourses(courses);
    }
}
