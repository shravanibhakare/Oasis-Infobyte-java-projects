import java.util.*;

import javax.swing.JOptionPane;

class NumGame {
    public static void main(String args[]) {
        JOptionPane.showMessageDialog(null, "Welcome buddy!");
        JOptionPane.showMessageDialog(null,
                "Here are some simple rules of the game buddy:\n" +
                        "1. You have 6 chances to guess the correct number.\n" +
                        "2. The highest score of the game is 6. The more chances you take, the lower your score.\n" +
                        "3. Guess the number between 1 to 100.");

        int chances = 6;
        int score = 6;
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int randn = get_random();
            boolean guess = false;

            for (int i = 0; i < chances; i++) {
                String userInput = JOptionPane.showInputDialog(null,
                        "This is chance no " + (i + 1) + "\n Enter your guess:");
                int user = Integer.parseInt(userInput);

                if (user == randn) {
                    guess = true;
                    JOptionPane.showInputDialog(null, "congratulation buddy! you won");
                    break;
                } else if (user < randn) {
                    JOptionPane.showMessageDialog(null, "Too Low!");
                    score--;
                } else {
                    JOptionPane.showMessageDialog(null, "Too High!");
                    score--;
                }
            }
            JOptionPane.showMessageDialog(null, "Buddy your final score is:" + score);
            if (guess == false) {
                JOptionPane.showMessageDialog(null,
                        "Oops buddy! you lost all the chances. \nthe actual number is: " + randn);
                score = 0;
            }
            JOptionPane.showMessageDialog(null, "Do you want to play again?(y/n) ");
            String PA = sc.next();
            playAgain = PA.equalsIgnoreCase("y");
        }

        JOptionPane.showMessageDialog(null, "See you again Buddy. BYE BYE!");
        sc.close();
    }

    public static int get_random() {
        Random r = new Random();
        return r.nextInt(100) + 1;

    }

}
