package 德州扑克;
import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList<Pai> list;

    public Player() {
    }

    public Player(String name, ArrayList<Pai> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pai> getList() {
        return list;
    }

    public void setList(ArrayList<Pai> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", list=" + this.getList() +
                '}';
    }
}
