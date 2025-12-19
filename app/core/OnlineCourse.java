package app.core;

public class OnlineCourse extends CourseBase {
    protected String platform;

    public OnlineCourse(int id, String title, String description, String platform) {
        super(id, title, description);
        this.platform = platform;
    }

    @Override
    public void start() {
        System.out.println("[OnlineCourse.start] Онлайн-курс \"" + title + "\" стартував на платформі: " + platform);
    }

    @Override
    public void printSummary() {
        System.out.println("[OnlineCourse.printSummary] " + title + " (" + platform + "): " + description);
    }
}
