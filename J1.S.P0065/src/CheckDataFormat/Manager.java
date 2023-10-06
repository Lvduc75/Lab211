package CheckDataFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {

    private  final Scanner sc = new Scanner(System.in);
    
    List<Student> students = new ArrayList<>();
    

    public void display() {

        createStudent();

        averageStudent();

        displayInformationStudent();

        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent();
        
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }

    public void createStudent() {

        while (true) {
            System.out.print("Name:");
            String name = checkInputString();
            System.out.print("Classes:");
            String className = checkInputString();
            System.out.print("Maths:");
            double math = checkInputMark("Maths");
            System.out.print("Chemistry:");
            double chemistry = checkInputMark("Chemistry");
            System.out.print("Physics:");
            double physics = checkInputMark("Physics");

            students.add(new Student(name, className, math, physics, chemistry));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!checkYN()) {
                return;
            }
        }
    }

    public List<Student> averageStudent() {
        for (Student student : students) {
            student.getType();
        }
        return students;
    }

    public HashMap<String, Double> getPercentTypeStudent() {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        int totalStudent = students.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (students.get(i).getType() == 'A') {
                typeA++;
            }
            if (students.get(i).getType() == 'B') {
                typeB++;
            }
            if (students.get(i).getType() == 'C') {
                typeC++;
            }
            if (students.get(i).getType() == 'D') {
                typeD++;
            }
        } 
        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
        return getPercentTypeStudent;
    }

    public void displayInformationStudent() {
        int i = 0;
        for (Student mem : students) {
            System.out.println("------ Student " + (++i) + " info ------");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
    }

    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public double checkInputMark(String inputString) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    System.err.println(inputString + " is greater than equal zero");
                    System.out.print(inputString + ":");
                    continue;
                }
                if (result > 10) {
                    System.err.println(inputString + " is less than equal ten");
                    System.out.print(inputString + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(inputString + " is digit");
                System.out.print(inputString + ":");
            }
        }
    }

    public boolean checkYN() {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }
}
