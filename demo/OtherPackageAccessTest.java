package demo;

import app.core.LiveOnlineCourse;
import app.people.Student;

public class OtherPackageAccessTest {
    public static void main(String[] args) {
        LiveOnlineCourse c = new LiveOnlineCourse(1, "Тест", "Опис", "Zoom", "link");
        Student s = new Student(1, "Тест-студент", "bio");

        System.out.println("Демонстрація package-private: доступ з іншого пакета заборонено.");
    }
}
