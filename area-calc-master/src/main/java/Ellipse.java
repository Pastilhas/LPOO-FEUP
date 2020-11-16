public class Ellipse implements Shape {
    private double x_radius;
    private double y_radius;

    Ellipse(int x_radius, int y_radius) {
        this.x_radius = x_radius;
        this.y_radius = y_radius;
    }

    public double getY_radius() {
        return y_radius;
    }

    public void setY_radius(int y_radius) {
        this.y_radius = y_radius;
    }

    public double getX_radius() {
        return x_radius;
    }

    public void setX_radius(int x_radius) {
        this.x_radius = x_radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.x_radius * this.y_radius;
    }
}
