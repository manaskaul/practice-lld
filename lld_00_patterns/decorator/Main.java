package lld_00_patterns.decorator;

import lld_00_patterns.decorator.classes.CheezeTopping;
import lld_00_patterns.decorator.classes.MushroomTopping;
import lld_00_patterns.decorator.classes.PizzaBase;
import lld_00_patterns.decorator.classes.VeggieDelightPizza;

public class Main {
    public static void main(String[] args) {
        PizzaBase vegDelight = new CheezeTopping(new MushroomTopping(new VeggieDelightPizza()));

        System.out.println("Total Price of the Pizza: " + vegDelight.price());
    }
}
