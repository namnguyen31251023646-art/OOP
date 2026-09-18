package bai08;

public class Main {

    public static void main(String[] args) {

        Drawing drawing = new Drawing();

        Shape[] shapes = {
                new Circle(),
                new Quad(),
                new Rectangle(),
                new Triangle(),
                new Polygon()
        };

        for (Shape shape : shapes) {

            drawing.drawShape(shape);

            shape.erase();

            shape.move(10, 20);

            System.out.println();
        }
    }
}