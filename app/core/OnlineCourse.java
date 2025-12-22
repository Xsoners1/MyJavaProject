package app.core;

public class OnlineCourse extends CourseBase {
    protected String platform;

    public OnlineCourse(String title, String description, String platform) {
        super(title, description);
        this.platform = platform;
    }

    @Override
    public void start() {
        System.out.println("[OnlineCourse.start] Онлайн-курс \"" + title + "\" стартував на платформі: " + platform);
    }
}
