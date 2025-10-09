abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public String deliverContent() {
        return decoratedCourse.deliverContent();
    }
}

class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent();
    }

    public String grantCertificate() {
        return "Certificate";
    }
}

class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent();
    }

    public String giveSupport() {
        return "Support";
    }
}

class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent();
    }

    public String gamify() {
        return "Gamification";
    }
}

