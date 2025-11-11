import java.util.InputMismatchException;
import java.util.Random;
import java.util.*;

public class TicTacToe {
    static String board[];
    static String turn;

    static String checkWinner(){
        for(int i=0;i<8;i++){
            String line = null;

            switch(i){
                case 0:
                    line = board[0]+board[1]+board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            }
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "draw";
            }
        }
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }
    static void draw() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new String[9];
        Random rand = new Random();
        System.out.println("Enter 0 to toss");
        int toss =sc.nextInt();
        if(toss==0) System.out.println("ready for toss....");
        else System.out.println("Invalid press..........");
        if(toss==0) {
            System.out.println("Enter 1 for heads and 2 for tails");
            int choice = sc.nextInt();
            System.out.println("Tossing.......");
            int random = rand.nextInt(2) + 1;
            if (random == choice) {
                System.out.println("You won the toss");
                System.out.println("Select your turn as X or O");
                turn = sc.next();
            } else {
                System.out.println("you lost the toss");
                System.out.println("Lets your opponent choose his turn as X or O");
                turn = sc.next();
            }

            String winner = null;
            for (int i = 0; i < 9; i++) {
                board[i] = String.valueOf(i + 1);
            }
            System.out.println("Welcome to Tic_Tac_Toe....");
            System.out.println("Displaying the Board......");
            draw();
            System.out.println(turn +"will play first");
            System.out.println("Enter the position to place" +turn);

            while(winner == null){
                int input;

                try{
                    input = sc.nextInt();
                    if(!(input>0 && input<=9)){
                        System.out.println("Invalid input... re-enter ");
                        continue;
                    }

                    if(board[input-1].equals(String.valueOf(input))){
                        board[input-1] = turn;

                        turn = turn.equals("X") ? "O" : "X";
                        draw();
                        winner = checkWinner();
                    }else{
                        System.out.println("slot already taken ; re-enter");
                    }
                }catch(InputMismatchException e){
                    System.out.println("Invalid input; re-enter slot number:");
                    sc.nextLine();
                }
            }
            if(winner.equalsIgnoreCase("draw")){
                System.out.println("It's a draw! Thanks for playing.");
            }else{
                System.out.println("Congratulations!! " +winner+ "'s have won!! Thanks for playing.");
            }
        }
        sc.close();
    }
}
