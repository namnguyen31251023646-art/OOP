package bai08;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }

    @Override
    public void erase() {
        System.out.println("Erase Circle");
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Move Circle to (" + x + ", " + y + ")");
    }
}