import java.util.Objects;

public class Employee extends Person {
    private final int hourlyRate;

    public Employee(String name, int age, int hourlyRate) {
        super(name, age);
        if (name == null) { throw new NullPointerException(); }
        if (age == 0) { throw new IllegalArgumentException(); }
        if (hourlyRate < 0) { throw new IllegalArgumentException(); }
        this.hourlyRate = hourlyRate;
    }

    public Employee(Employee employee) {
        super(employee.getName(), employee.getAge());
        if (employee == null) { throw new NullPointerException(); }
        hourlyRate = employee.getHourlyRate();
    }

    public int getHourlyRate() { return hourlyRate; }

    public int calculateIncome(int hours) {
        if (hours == 0) { throw new IllegalArgumentException(); }
        return hourlyRate * hours;
    }

    public boolean equals(Object object) {
        if (object instanceof Employee) {
            return (Objects.equals(super.getName(), ((Employee) object).getName()) &&
                    super.getAge() == ((Employee) object).getAge() &&
                    hourlyRate == ((Employee) object).getHourlyRate());
        }
        return false;
    }

    public String toString() {
        return String.format("Employee<name=%s, age=%s, hourlyRate=%d>", super.getName(), super.getAge(), hourlyRate);
    }
}
