package app.core;

import app.people.Student;
import app.people.Teacher;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CourseBase {
    protected int id;
    protected String title;
    protected String description;

    private Teacher teacher;
    private Map<String, String> schedule = new LinkedHashMap<>();

    public CourseBase(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    void addStudentInternal(Student s) {
        System.out.println("[CourseBase.addStudentInternal] Додано студента: " + s.getName());
    }

    void setTeacherInternal(Teacher t) {
        teacher = t;
        System.out.println("[CourseBase.setTeacherInternal] Призначено викладача: " + t.getName());
    }

    public void addScheduleEntry(String dateTime, String topic) {
        schedule.put(dateTime, topic);
        System.out.println("[CourseBase.addScheduleEntry] " + dateTime + " → " + topic);
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

    public void start() {
        System.out.println("[CourseBase.start] Старт курсу: " + title);
    }

    public void printSummary() {
        System.out.println("[CourseBase.printSummary] " + title + " — " + description);
    }
}
