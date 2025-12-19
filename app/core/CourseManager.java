package app.core;

import app.materials.LearningMaterial;
import app.people.Student;
import app.people.Teacher;

import java.util.LinkedHashMap;
import java.util.Map;

public class CourseManager {
    private CourseBase course;

    private Map<String, Integer> grades = new LinkedHashMap<>();

    public CourseManager(CourseBase course) {
        this.course = course;
    }

    public void enrollStudent(Student s) {
        course.addStudentInternal(s); // package-private
    }

    public void assignTeacher(Teacher t) {
        course.setTeacherInternal(t);
    }

    public void publishMaterial(LearningMaterial m) {
        System.out.println("[CourseManager.publishMaterial] Додано матеріал до курсу.");
        m.info();
        m.publish();
    }

    public void recordGrade(Student s, int grade) {
        grades.put(s.getName(), grade);
        System.out.println("[CourseManager.recordGrade] Оцінка " + grade + " для " + s.getName());
    }

    public void showAllGrades() {
        System.out.println("\n[CourseManager.showAllGrades] Оцінки студентів:");
        if (grades.isEmpty()) {
            System.out.println("  (оцінок немає)");
            return;
        }
        for (Map.Entry<String, Integer> e : grades.entrySet()) {
            System.out.println("  " + e.getKey() + " → " + e.getValue());
        }
    }
}
