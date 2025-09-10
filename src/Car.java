public class Car {
    private final String engine;
    private final String transmission;
    private final String paintJob;
    private final boolean spoiler;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.paintJob = builder.paintJob;
        this.spoiler = builder.spoiler;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                (paintJob != null ? ", paint='" + paintJob + '\'' : "") +
                (spoiler ? ", spoiler" : "") +
                '}';
    }

    public static class Builder {
        private String engine;
        private String transmission;
        private String paintJob;
        private boolean spoiler;

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder paint(String color) {
            this.paintJob = color;
            return this;
        }

        public Builder addSpoiler() {
            this.spoiler = true;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
