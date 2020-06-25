package 德州扑克;

public class Kanpai {
    protected static void kanpai(Player a, Player b) {
        print(a);
        print(b);
    }

    private static void print(Player x) {
        System.out.print(x.getName() + ":");
        for (int i = 0; i < x.getList().size(); i++) {
            int color = x.getList().get(i).getN();
            int num = x.getList().get(i).getN();

            String colorStr = signColor(x.getList().get(i).getC());
            String numStr = signNum(x.getList().get(i).getN());

            System.out.print(numStr + colorStr + " ");
        }
    }

    private static String signColor(int c) {
        if (c == 1) {
            return "D";
        } else if (c == 2) {
            return "S";
        } else if (c == 3) {
            return "H";
        } else if (c == 4) {
            return "C";
        }
        return null;
    }

    private static String signNum(int n) {
        String strNum;
        if (n < 10) {
            strNum = Integer.toString(n);
            return strNum;
        } else if (n == 10) {
            return "T";
        }else if (n == 11) {
            return "J";
        }else if (n == 12) {
            return "Q";
        }else if (n == 13) {
            return "K";
        }else if (n == 14) {
            return "A";
        }
        return null;
    }
}
