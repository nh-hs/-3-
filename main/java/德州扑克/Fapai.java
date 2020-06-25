package 德州扑克;

import java.util.ArrayList;

public class Fapai {
    public static void fapai(Player a, Player b, ArrayList<Pai> pai) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                a.getList().add(pai.get(i));
            } else if (i % 2 == 0) {
                b.getList().add(pai.get(i));
            }
        }
    }
}