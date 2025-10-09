interface Course {
    String deliverContent();
}

class MathCourse implements Course {
    @Override
    public String deliverContent() {
        return "Delivering Math Course content.";
    }
}

class ProgrammingCourse implements Course {
    @Override
    public String deliverContent() {
        return "Delivering Programming Course content.";
    }
}