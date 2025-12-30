package patterns.decorator;

import patterns.decorator.classes.CheezeTopping;
import patterns.decorator.classes.MushroomTopping;
import patterns.decorator.classes.PizzaBase;
import patterns.decorator.classes.VeggieDelightPizza;

public class Main {
    public static void main(String[] args) {
        PizzaBase vegDelight = new CheezeTopping(new MushroomTopping(new VeggieDelightPizza()));

        System.out.println("Total Price of the Pizza: " + vegDelight.price());
    }
}
