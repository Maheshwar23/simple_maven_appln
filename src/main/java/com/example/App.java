import java.util.Scanner;

public class ScholarshipEligibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Scholarship Eligibility Checker ---");

        // 1. Input Marks
        System.out.print("Enter your aggregate percentage: ");
        double marks = sc.nextDouble();

        // 2. Input Income
        System.out.print("Enter your annual family income (in INR): ");
        double income = sc.nextDouble();

        // 3. Input Caste Category
        System.out.print("Enter Caste Category (SC/ST/OBC/GEN): ");
        String category = sc.next().toUpperCase();

        boolean isEligible = false;
        String reason = "";

        // --- Eligibility Logic ---
        // Minimum marks requirement for all (e.g., 60%)
        if (marks >= 60) {
            
            // Caste-based and Income-based logic
            if (category.equals("SC") || category.equals("ST")) {
                if (income <= 250000) { // Rs 2.5 Lakh income ceiling
                    isEligible = true;
                } else {
                    reason = "Income too high for SC/ST Category.";
                }
            } 
            else if (category.equals("OBC")) {
                if (income <= 150000) { // Lower ceiling for OBC often applied
                    isEligible = true;
                } else {
                    reason = "Income too high for OBC Category.";
                }
            }
            else if (category.equals("GEN")) {
                if (income <= 100000) { // Strict income limit for General
                    isEligible = true;
                } else {
                    reason = "Income too high for General Category.";
                }
            }
            else {
                reason = "Invalid Category Entered.";
            }

        } else {
            reason = "Marks below 60%.";
        }

        // --- Output Result ---
        System.out.println("\n--- Results ---");
        if (isEligible) {
            System.out.println("Congratulations! You are ELIGIBLE for the scholarship.");
        } else {
            System.out.println("Sorry, you are NOT ELIGIBLE.");
            System.out.println("Reason: " + reason);
        }

        sc.close();
    }
}
