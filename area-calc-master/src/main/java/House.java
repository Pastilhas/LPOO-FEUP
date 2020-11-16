public class House implements HasArea {
    private double area;

    House(double area){
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }
}
