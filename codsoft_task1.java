import java.util.Scanner;

public class task1 {

    public static int getrandomN(int min, int max)//method used to return value
    {
        return(int)(Math.random()*(max-min+1)+min);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int attempt = 7;//total number of attempts
        int f_score = 0;//to store the score
        boolean p_again = true;
        System.out.println("- Welcome To Number Game -");
        System.out.println("You have "+attempt+" chances to win");
        while (p_again) {
            int rand = getrandomN(1,100);
            boolean guess = false;
            for (int i = 0; i < attempt ; i++) {
                System.out.println("Attempt "+(i+1)+"  Guess the number");        
                int user = sc.nextInt();
                if (user == rand) {
                    guess = true;
                    f_score = +1;
                    System.out.println("Congratulations match found successfully");
                    break;
                }
                else if (user>rand) {
                    System.out.println("Too High");
                }
                else{
                System.out.println("Too Low");
            }
        }
        if (guess==false) {
            System.out.println("Better luck next time the correct number is "+rand);
        }
        System.out.println("Wish to play again(y/n)");
        String playAgain = sc.next();
        p_again=playAgain.equalsIgnoreCase("y");
    }
    System.out.println("Your Score is "+f_score);
    System.out.println("Hope your done now");
    System.out.println("Thankyou for playing");
    System.out.println("Please Come Again !");
    }
}
