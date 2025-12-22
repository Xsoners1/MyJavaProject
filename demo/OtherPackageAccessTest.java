package demo;

import app.core.LiveOnlineCourse;
import app.people.Student;

public class OtherPackageAccessTest {
    public static void main(String[] args) {

        LiveOnlineCourse c = new LiveOnlineCourse(
                "Тест",
                "Тест",
                "Опис",
                "link"
        );

        Student s = new Student(
                "Тест",
                "Студент",
                "bio"
        );

        System.out.println("Демонстрація package-private: доступ з іншого пакета заборонено.");
    }
}
