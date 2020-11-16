public class Rectangle implements Shape {
    private double height;
    private double width;

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }
}
