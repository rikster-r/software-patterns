class ProgressTracker {
    public void track(String courseName, String status) {
        System.out.println("[Progress] " + courseName + " - " + status);
    }
}

class NotificationService {
    public void send(String message) {
        System.out.println("[Notification] " + message);
    }
}

class StudentPortalFacade {
    private Student student;
    private final ProgressTracker progressTracker = new ProgressTracker();
    private final NotificationService notificationService = new NotificationService();

    public void registerStudent(Student student) {
        this.student = student;
    }

    public void enrollInCourse() {
        progressTracker.track(student.getCourse().deliverContent(), "Enrolled");
        notificationService.send("You have successfully enrolled in " + student.getCourse().deliverContent());
    }

    public void startLearning() {
        progressTracker.track(student.getCourse().deliverContent(), "In Progress");
        notificationService.send("Your learning for " + student.getCourse().deliverContent() + " has started!");
    }

    public void completeCourse() {
        progressTracker.track(student.getCourse().deliverContent(), "Completed");
        notificationService.send("🎉 Congratulations! You’ve completed " + student.getCourse().deliverContent() + ".");
    }
}