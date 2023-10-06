package CheckDataFormat;

public class Student {

    private String studentName;
    private String className;
    private double math;
    private double physics;
    private double chemistry;
    private double average;
    private char type;

    public Student() {
    }

    public Student(String studentName, String className, double maths, double physical, double chemistry) {
        this.studentName = studentName;
        this.className = className;
        this.math = maths;
        this.physics = physical;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return (math + chemistry + physics) / 3;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public char getType() {
        if (getAverage() > 7.5) {
                return 'A';
            } else if (getAverage() >= 6 && getAverage() <= 7.5) {
                return 'B';
            } else if (getAverage() >= 4 && getAverage() < 6) {
                return 'C';
            } else {
                return 'D';
            }
    }

    public void setType(char type) {
        this.type = type;
    }

}
