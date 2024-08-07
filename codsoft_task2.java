import java.util.Scanner;

public class task2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("*** STUDENT GRADE CALCULATOR ***");
        System.out.println("Enter total number of subjects");
        int n = sc.nextInt();//numbers of subjects
        int total = 0;//empty variable created to store total marks

        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter marks obtained in each subject "+i+" :");
            int marks = sc.nextInt();
            total+=marks;    //calculate total marks obtained
        }
        double average_percentage = (double)total/n;//calculate average percentage obtained
        char Grade;
        switch ((int) average_percentage / 10) 
        {
            case 10:
            case 9:
                    Grade = 'A';
                    break;
            case 8:
                    Grade = 'B';
                    break;
            case 7:
                    Grade = 'C';
                    break;
            case 6:
                    Grade = 'D';
                    break;
            case 5:
                    Grade = 'E';
                    break;
            default:
                    Grade = 'F';
        }

        // Display results
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", average_percentage);
        System.out.println("Grade: " + Grade);

        sc.close();
        } 
}

