package app.materials;

import java.time.LocalDate;

public abstract class LearningMaterial {
    protected String title;
    protected LocalDate date;
    protected String content;

    public static LocalDate today() {
        return LocalDate.now();
    }

    public LearningMaterial(String title, LocalDate date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public abstract void info();

    public void publish() {
        System.out.println("[LearningMaterial.publish] Опубліковано: " + title + " (" + date + ")");
    }
}
