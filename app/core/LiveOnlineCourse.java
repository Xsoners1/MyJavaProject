package app.core;

public class LiveOnlineCourse extends OnlineCourse {
    private String meetingLink;

    public LiveOnlineCourse(String title, String description, String platform, String meetingLink) {
        super(title, description, platform);
        this.meetingLink = meetingLink;
    }

    @Override
    public void start() {
        System.out.println("[LiveOnlineCourse.start] Живе заняття \"" + title + "\" | посилання: " + meetingLink);
    }

    @Override
    public void printSummary() {
        System.out.println("[LiveOnlineCourse.printSummary] " + title + " | платформа=" + platform + " | link=" + meetingLink);
    }
}
