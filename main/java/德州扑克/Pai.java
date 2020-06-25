package 德州扑克;

public class Pai {
    private int c;
    private int n;

    public Pai() {
    }

    public Pai(int c, int n) {
        this.c = c;
        this.n = n;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Pai{" + "c=" + c + ", n=" + n + '}';
    }

    @Override
    public int compareTo(Pai pai) {
        return this.getN() - pai.getN();
    }
}
