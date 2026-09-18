package bai08;

public class Polygon extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw Polygon");
    }

    @Override
    public void erase() {
        System.out.println("Erase Polygon");
    }

    @Override
    public void move(int x, int y) {
        System.out.println(
                "Move Polygon to (" + x + ", " + y + ")");
    }
}