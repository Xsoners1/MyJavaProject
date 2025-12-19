package app.materials;

import java.time.LocalDate;

public abstract class LearningMaterial {
    protected String title;
    protected LocalDate date;
    protected String content;

    public LearningMaterial(String title, LocalDate date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public abstract void info();

    public void publish() {
        System.out.println("[LearningMaterial.publish] Опубліковано: " + title + " (" + date + ")");
    }
}
