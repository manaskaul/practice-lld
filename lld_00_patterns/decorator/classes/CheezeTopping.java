package lld_00_patterns.decorator.classes;

public class CheezeTopping extends ToppingDecorator {
    
    private final PizzaBase pizzaBase;

    public CheezeTopping(PizzaBase pBase) {
        this.pizzaBase = pBase;
    }

    @Override
    public int price() {
        return pizzaBase.price() + 15;
    }

}
