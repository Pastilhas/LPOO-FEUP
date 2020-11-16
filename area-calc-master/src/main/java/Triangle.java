public class Triangle implements Shape {
    private double base;
    private double height;

    Triangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double getArea() {
        return this.height * this.base * 0.5;
    }
}