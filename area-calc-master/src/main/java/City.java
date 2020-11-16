import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{
    private List<House> houses;

    City(){
        this.houses = new ArrayList<House>();
    }

    public void addHouse(House house){
        houses.add(house);
    }

    @Override
    public double sum() {
        double sum = 0;
        for(House h : houses){
            sum += h.getArea();
        }
        return sum;
    }
}
