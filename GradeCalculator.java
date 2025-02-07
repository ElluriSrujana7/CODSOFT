import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for each subject
        System.out.print("Enter marks for Subject 1: ");
        double marks1 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 2: ");
        double marks2 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 3: ");
        double marks3 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 4: ");
        double marks4 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 5: ");
        double marks5 = scanner.nextDouble();

        // Calculate total marks
        double total = marks1 + marks2 + marks3 + marks4 + marks5;

        // Calculate average percentage
        double average = total / 5.0;

        // Determine grade based on average percentage
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
