package patterns.decorator.classes;

public class MushroomTopping extends ToppingDecorator {
    
    private final PizzaBase pizzaBase;

    public MushroomTopping(PizzaBase pBase) {
        this.pizzaBase = pBase;
    }

    @Override
    public int price() {
        return pizzaBase.price() + 30;
    }

}
