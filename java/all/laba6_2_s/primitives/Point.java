package all.laba6_2_s.primitives;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Point created at " + String.valueOf(this));
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "x:" + this.x + ", y:" + this.y;
    }

    protected void finalize() throws Throwable {
        System.out.println("Point at " + String.valueOf(this) + " was deleted");
    }
}
