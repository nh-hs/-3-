package 德州扑克;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<Integer> color = new ArrayList<Integer>();
        ArrayList<Pai> poker = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            color.add(i);
        }
        for (int i = 2; i <= 14; i++) {
            num.add(i);
        }
        for (int i : color) {
            for (int j : num) {
                poker.add(new Pai(i, j));
            }
        }

        Collections.shuffle(poker);

        Player player1 = new Player("Black", new ArrayList<Pai>());
        Player player2 = new Player("White", new ArrayList<Pai>());

        Fapai.fapai(player1, player2, poker);

        Kanpai.kanpai(player1, player2);

        String result = Compare.compare(player1, player2);

        System.out.println("\n" + result + ":wins");
    }


}