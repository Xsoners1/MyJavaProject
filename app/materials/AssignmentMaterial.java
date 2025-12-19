package app.materials;

import java.time.LocalDate;

public class AssignmentMaterial extends LearningMaterial {
    public AssignmentMaterial(String title, LocalDate date, String content) {
        super(title, date, content);
    }

    @Override
    public void info() {
        System.out.println("[AssignmentMaterial.info] Завдання: " + title + ", дедлайн: " + date);
    }

    @Override
    public void publish() {
        System.out.println("[AssignmentMaterial.publish] Завдання додано: " + title);
    }
}
