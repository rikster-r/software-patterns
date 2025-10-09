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
    private final ProgressTracker progressTracker = new ProgressTracker();
    private final NotificationService notificationService = new NotificationService();

    public Course enrollInCourse(String courseName, Course course) {
        System.out.println("Enrolling in course: " + courseName);
        notificationService.send("You have successfully enrolled in " + courseName);
        progressTracker.track(courseName, "Enrolled");
        return course;
    }

    public void startLearning(String courseName, Course course) {
        System.out.println("Starting course: " + courseName);
        System.out.println(course.deliverContent());
        progressTracker.track(courseName, "In Progress");
        notificationService.send("Your learning for " + courseName + " has started!");
    }

    public void completeCourse(String courseName) {
        progressTracker.track(courseName, "Completed");
        notificationService.send("🎉 Congratulations! You’ve completed " + courseName + ".");
    }
}