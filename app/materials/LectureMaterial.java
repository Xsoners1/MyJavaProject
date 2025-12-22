package app.materials;

import java.time.LocalDate;

public class LectureMaterial extends LearningMaterial {
    public LectureMaterial(String title, LocalDate date, String content) {
        super(title, date, content);
    }

    @Override
    public void info() {
        System.out.println("[LectureMaterial.info] Лекція: " + title + ", символів: " + content.length());
    }

    @Override
    public void publish() {
        System.out.println("[LectureMaterial.publish] Лекцію опубліковано: " + title);
    }

    @Override
    public String getType() {
        return "Лекція";
    }
}
