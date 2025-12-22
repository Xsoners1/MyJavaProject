package app.core;

import app.people.Student;
import app.people.Teacher;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CourseBase {
    protected int id;
    protected String title;
    protected String description;

    private static int courseIdCounter = 1;

    public static int generateCourseId() {
        return courseIdCounter++;
    }

    private Map<String, String> schedule = new LinkedHashMap<>();

    public CourseBase(String title, String description) {
        this.id = generateCourseId();
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    void addStudentInternal(Student s) {
        System.out.println("[CourseBase.addStudentInternal] Додано студента: " + s.getName());
    }

    void setTeacherInternal(Teacher t) {
        System.out.println("[CourseBase.setTeacherInternal] Призначено викладача: " + t.getName());
    }

    public void addScheduleEntry(String dateTime, String topic) {
        schedule.put(dateTime, topic);
    }

    public void showSchedule() {
        System.out.println("\n[CourseBase.showSchedule] Розклад курсу \"" + title + "\":");
        if (schedule.isEmpty()) {
            System.out.println("  (порожньо)");
            return;
        }
        for (Map.Entry<String, String> e : schedule.entrySet()) {
            System.out.println("  " + e.getKey() + " → " + e.getValue());
        }
    }

    public abstract void start();
    public abstract void printSummary();
    public abstract String getPlatform();
}
