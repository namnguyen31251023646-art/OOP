package bai08;

public class Quad extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw Quad");
    }

    @Override
    public void erase() {
        System.out.println("Erase Quad");
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Move Quad to (" + x + ", " + y + ")");
    }
}