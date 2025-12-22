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

    private Teacher teacher;
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
        teacher = t;
        System.out.println("[CourseBase.setTeacherInternal] Призначено викладача: " + t.getName());
    }

    public void addScheduleEntry(String dateTime, String topic) {
        schedule.put(dateTime, topic);
    }

    public void showSchedule() {
        System.out.println("\n[CourseBase.showSchedule] Розклад курсу \"" + title + "\":");
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

    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + "'}";
    }
}
