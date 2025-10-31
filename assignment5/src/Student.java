public class Student {
    private String name;
    private Course course;
    private int age;

    private Student() {};

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Course getCourse() {
        return course;
    }

    public static class Builder {
        private final Student student = new Student();

        public Builder name(String name) {
            student.name = name;
            return this;
        }

        public Builder course(Course course) {
            student.course = course;
            return this;
        }

        public Builder age(int age) {
            student.age = age;
            return this;
        }

        public Student build() {
            return student;
        }
    }
}
