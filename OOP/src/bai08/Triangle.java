package bai08;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase Triangle");
    }

    @Override
    public void move(int x, int y) {
        System.out.println(
                "Move Triangle to (" + x + ", " + y + ")");
    }
}