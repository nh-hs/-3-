package 德州扑克;
import java.util.ArrayList;
import java.util.Collections;
public class Compare {
    public static String compare(Player a, Player b) {
        String result = "Black";
        ArrayList<Pai> aList = a.getList();
        ArrayList<Pai> bList = b.getList();

        Collections.sort(aList);
        Collections.sort(bList);

        if (IsTonghuashun(aList) || IsTonghuashun(bList)) {
            if (IsTonghuashun(aList) && IsTonghuashun(bList)) {
                int i = aList.get(0).getN();
                int j = bList.get(0).getN();
                if (i < j) {
                    return "white";
                } else if (i == j) {
                    return "ping and none";
                } else if (i > j) {
                    return result;
                }
            } else if (!IsTonghuashun(aList) && IsTonghuashun(bList)) {
                return "white";
            } else if (IsTonghuashun(aList) && !IsTonghuashun(bList)) {
                return result;
            }
        }
        else if (IsTonghua(aList) || IsTonghua(bList)) {
            if (IsTonghua(aList) && IsTonghua(bList)) {
                for (int i = aList.size() - 1; i >= 0; i--) {
                    int x = aList.get(i).getN();
                    int y = bList.get(i).getN();

                    if (x == y) {
                        continue;
                    } else if (x < y) {
                        return "white";
                    } else {
                        return result;
                    }
                }
                return "ping and none";
            } else if (!IsTonghua(aList) && IsTonghua(bList)) {
                return "white";
            } else if (IsTonghua(aList) & !IsTonghua(bList)) {
                return result;
            }
        }
        else if (IsShunzi(aList) || IsShunzi(bList)) {
            if (IsShunzi(aList) && IsShunzi(bList)) {
                int i = aList.get(0).getN();
                int j = bList.get(0).getN();
                if (i < j) {
                    return "white";
                } else if (i == j) {
                    return "ping and none";
                } else if (i > j) {
                    return result;
                }
            } else if (!IsShunzi(aList) && IsShunzi(bList)) {
                return "white";
            } else if (IsShunzi(aList) && !IsShunzi(bList)) {
                return result;
            }
        }
        else if (IsSantiao(aList) || IsSantiao(bList)) {
            if (IsSantiao(aList) && IsSantiao(bList)) {
                int i = aList.get(2).getN();
                int j = bList.get(2).getN();
                if (i < j) {
                    return "white";
                } else if (i > j) {
                    return result;
                }
            } else if (!IsSantiao(aList) && IsSantiao(bList)) {
                return "white";
            } else if (IsSantiao(aList) && !IsSantiao(bList)) {
                return result;
            }
        }
        else if (IsLiangdui(aList) || IsLiangdui(bList)) {
            if (IsLiangdui(aList) && IsLiangdui(bList)) {
                int a4 = aList.get(4).getN();
                int b4 = bList.get(4).getN();
                int[] a_liangdui = getLiangdui(aList);
                int[] b_liangdui = getLiangdui(bList);
                if (a_liangdui[1] == b_liangdui[1] && a_liangdui[0] == b_liangdui[0]) {
                    int aNum = 0, bNum = 0;
                    for (int i = 0; i < aList.size(); i++) {
                        int listNum = aList.get(i).getN();
                        if (listNum != a_liangdui[0] && listNum != a_liangdui[1]) {
                            aNum = listNum;
                            break;
                        }
                    }
                    for (int i = 0; i < bList.size(); i++) {
                        int listNum = bList.get(i).getN();
                        if (listNum != b_liangdui[0] && listNum != b_liangdui[1]) {
                            bNum = listNum;
                            break;
                        }
                    }
                    if (aNum == bNum) {
                        return "ping and none";
                    } else if (aNum < bNum) {
                        return "white";
                    } else if (aNum > bNum) {
                        return result;
                    }


                } else if (a_liangdui[1] == b_liangdui[1] && a_liangdui[0] < b_liangdui[0]) {
                    return "white";
                } else if (a_liangdui[1] == b_liangdui[1] && a_liangdui[0] > b_liangdui[0]) {
                    return result;
                } else if (a_liangdui[1] < b_liangdui[1]) {
                    return "white";
                } else if (a_liangdui[1] > b_liangdui[1]) {
                    return result;
                }

            } else if (!IsLiangdui(aList) && IsLiangdui(bList)) {
                return "white";
            } else if (IsLiangdui(aList) && !IsLiangdui(bList)) {
                return result;
            }
        }
        else if (IsDuizi(aList) || IsDuizi(bList)) {
            int a4 = aList.get(4).getN();
            int b4 = bList.get(4).getN();
            if (IsDuizi(aList) && IsDuizi(bList)) {
                int ax = getDuizi(aList);
                int bx = getDuizi(bList);
                if (ax == bx) {
                    if (a4 == b4) {
                        for (int i = aList.size() - 2; i >= 0; i--) {
                            int x = aList.get(i).getN();
                            int y = bList.get(i).getN();

                            if (x == y) {
                                continue;
                            } else if (x < y) {
                                return "white";
                            } else {
                                return result;
                            }
                        }
                        return "ping and none";
                    } else if (a4 < b4) {
                        return "white";
                    } else if (a4 > b4) {
                        return result;
                    }
                } else if (ax < bx) {
                    return "white";
                } else {
                    return result;
                }
            } else if (!IsDuizi(aList) && IsDuizi(bList)) {
                return "white";
            } else if (IsDuizi(aList) && !IsDuizi(bList)) {
                return result;
            }
        }
        else {
            for (int i = aList.size() - 1;i >= 0; i--) {
                int x = aList.get(i).getN();
                int y = bList.get(i).getN();

                if (x == y){
                    continue;
                } else if (x < y){
                    return "white";
                } else{
                    return result;
                }
            }
            return "ping and none"
        }
        return result;
    }

    public static boolean IsTonghuashun(ArrayList<Pai> list) {
        boolean b = false;
        int color = list.get(0).getC();
        int num = list.get(0).getN();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getC() != color) {
                return b;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getN() - num != i) {
                return b;
            }
        }
        return true;
    }
    public static boolean IsTonghua(ArrayList<Pai> list) {
        boolean b = false;
        int color = list.get(0).getC();
        int num = list.get(0).getN();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getC() != color) {
                return b;
            }
        }
        return true;
    }
    public static boolean IsShunzi(ArrayList<Pai> list) {
        boolean b = false;
        int num = list.get(0).getN();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getN() - num != i) {
                return b;
            }
        }
        return true;
    }
    public static boolean IsSantiao(ArrayList<Pai> list) {
        boolean b = true;
        int num0 = list.get(0).getN();
        int num1 = list.get(1).getN();
        int num2 = list.get(2).getN();
        int num3 = list.get(3).getN();
        int num4 = list.get(4).getN();
        if (num1 == num2 && num0 == num2) {
            return b;
        } else if (num1 == num2 && num3 == num2) {
            return b;
        } else if (num3 == num2 && num4 == num2) {
            return b;
        }

        return false;
    }
    public static boolean IsLiangdui(ArrayList<Pai> list) {
        boolean b = true;
        int num0 = list.get(0).getN();
        int num1 = list.get(1).getN();
        int num2 = list.get(2).getN();
        int num3 = list.get(3).getN();
        int num4 = list.get(4).getN();
        if (num0 != num1) {
            if (num1 == num2 && num3 == num4) {
                return b;
            }
        } else if (num0 == num1) {
            if (num2 != num3) {
                if (num3 == num4) {
                    return b;
                }
            } else if (num2 == num3) {
                return b;
            }
        }
        return false;
    }
    public static boolean IsDuizi(ArrayList<Pai> list) {
        boolean b = true;
        int num0 = list.get(0).getN();
        int num1 = list.get(1).getN();
        int num2 = list.get(2).getN();
        int num3 = list.get(3).getN();
        int num4 = list.get(4).getN();
        if (num0 == num1 || num1 == num2 || num2 == num3 || num3 == num4) {
            return b;
        }
        return false;
    }
    public static int getDuizi(ArrayList<Pai> list) {
        int dui = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int x = list.get(i).getN();
            int y = list.get(i + 1).getN();
            if (x == y) {
                dui = x;
                break;
            }
        }
        return dui;
    }
    public static int[] getLiangdui(ArrayList<Pai> list) {
        int[] liangdui = {0, 0};
        int smallNum = list.get(1).getN();
        int bigNum = list.get(3).getN();
        int max;
        if (smallNum > bigNum) {
            max = smallNum;
            bigNum = max;
            smallNum = bigNum;
        }
        liangdui[0] = smallNum;
        liangdui[1] = bigNum;
        return liangdui;
    }
}
