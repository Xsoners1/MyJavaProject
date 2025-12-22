package app;

import app.core.LiveOnlineCourse;
import app.materials.AssignmentMaterial;
import app.materials.LectureMaterial;
import app.people.Student;
import app.people.Teacher;

import java.time.LocalDate;

public final class ObjectFactory {

    private ObjectFactory() { }

    public static Student createStudent(String firstName, String lastName, String bio) {
        return new Student(firstName, lastName, bio);
    }

    public static Teacher createTeacher(String firstName, String lastName, String bio) {
        return new Teacher(firstName, lastName, bio);
    }

    public static LiveOnlineCourse createCourse(String title, String desc, String platform, String link) {
        return new LiveOnlineCourse(title, desc, platform, link);
    }

    public static LectureMaterial createLecture(String title, String content) {
        return new LectureMaterial(title, LocalDate.now(), content);
    }

    public static AssignmentMaterial createAssignment(String title, String content, int daysToDeadline) {
        return new AssignmentMaterial(title, LocalDate.now().plusDays(daysToDeadline), content);
    }
}
