interface Course {
    String deliverContent();
}

class MathCourse implements Course {
    @Override
    public String deliverContent() {
        return "Math Course";
    }
}

class ProgrammingCourse implements Course {
    @Override
    public String deliverContent() {
        return "Programming Course";
    }
}