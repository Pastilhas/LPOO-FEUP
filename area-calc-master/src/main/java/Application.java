import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addShape(new Square(10));
        aggregator.addShape(new Circle(5));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Ellipse(2, 3));
        aggregator.addShape(new Rectangle(10, 5));
        aggregator.addShape(new Triangle(10, 2));
        aggregator.addShape(new House(100));

        AreaOutput stringOutputter = new AreaOutput(aggregator);
        AreaXMLOutput xmlOutputter = new AreaXMLOutput(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output_XML());

        City city = new City();
        city.addHouse(new House(50));
        city.addHouse(new House(150));

        AreaOutput cityStringOutputter = new AreaOutput(city);
        AreaXMLOutput cityXmlOutputter = new AreaXMLOutput(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output_XML());
    }

}
