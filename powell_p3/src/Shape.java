abstract public class Shape {
    String shapeName;
    double area;
    public abstract String getName();
}

abstract class Shape2D extends Shape {
    public abstract double getArea();
}

abstract class Shape3D extends Shape2D {
    double volume;
    public abstract double getVolume();
}

class Square extends Shape2D {

    public Square(double sideLength) {
        shapeName = "square";
        area = sideLength * sideLength;
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

}

class Triangle extends Shape2D {

    public Triangle(double base, double height) {
        shapeName = "triangle";
        area = (base * height)/2;
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

}

class Circle extends Shape2D {

    public Circle(double radius) {
        shapeName = "circle";
        area = (Math.PI * radius * radius);
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

}

class Cube extends Shape3D {

    public Cube(double sideLength) {
        shapeName = "cube";
        area = 6 * (sideLength * sideLength);
        volume = (sideLength * sideLength * sideLength);
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

}

class Pyramid extends Shape3D {

    public Pyramid(double length, double width, double height) {
        shapeName = "pyramid";
        area = (length * width) + (length * Math.sqrt(Math.pow(width / 2, 2) +
                Math.pow(height, 2))) + (width * Math.sqrt(Math.pow(length / 2, 2) +
                Math.pow(height, 2)));

        volume = (length * width * height)/3;
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

}

class Sphere extends Shape3D {

    public Sphere(double radius) {
        shapeName = "sphere";
        area = 4 * (Math.PI * (radius * radius));
        volume = (4 * Math.PI * (radius * radius * radius))/3;
    }

    public String getName() {
        return shapeName;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

}


