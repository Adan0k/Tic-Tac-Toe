import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> positions = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            positions.add(i + "");
        }
        String player1 = "x";
        String player2 = "o";
        int position;
        String winner = null;
        boolean finish = false;
        do {
            printGame(positions);
            System.out.println("player 1:");
            position = scanner.nextInt();
            positions.set(position,player1);

            winner = checkGameOver(positions);
            if (winner != null){
                break;
            }

            printGame(positions);
            System.out.println("player 2:");
            position = scanner.nextInt();
            positions.set(position,player2);

            winner = checkGameOver(positions);

        } while (winner == null);
        System.out.println("winner: " + winner);

    }

    static void printGame(ArrayList list) {
        System.out.println(" " + list.get(0) + " | " + list.get(1) + " | " + list.get(2) + "\n" +
                "---+---+---\n" + " " + list.get(3) + " | " + list.get(4) + " | " + list.get(5) + "\n" +
                "---+---+---\n" + " " + list.get(6) + " | " + list.get(7) + " | " + list.get(8)
        );
    }

    static String checkGameOver(ArrayList list) {
        if (list.get(0).equals(list.get(1)) && list.get(1).equals(list.get(2))) {
            return (String) list.get(0);
        }
        if (list.get(3).equals(list.get(4)) && list.get(4).equals(list.get(5))) {
            return (String) list.get(3);
        }
        if (list.get(6).equals(list.get(7)) && list.get(7).equals(list.get(8))) {
            return (String) list.get(6);
        }

        if (list.get(0).equals(list.get(3)) && list.get(3).equals(list.get(6))) {
            return (String) list.get(0);
        }
        if (list.get(1).equals(list.get(4)) && list.get(4).equals(list.get(7))) {
            return (String) list.get(1);
        }
        if (list.get(2).equals(list.get(5)) && list.get(5).equals(list.get(8))) {
            return (String) list.get(2);
        }

        if (list.get(0).equals(list.get(4)) && list.get(4).equals(list.get(8))) {
            return (String) list.get(0);
        }
        if (list.get(2).equals(list.get(4)) && list.get(4).equals(list.get(6))) {
            return (String) list.get(2);
        }
        return null;
    }
}