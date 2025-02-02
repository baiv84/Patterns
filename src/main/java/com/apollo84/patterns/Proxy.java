package com.apollo84.patterns;

interface Order {
    void orderDish();
}

class Dish implements Order {
    String nameOfDish;

    private void prepare() { System.out.println("Готовлю ингредиенты для блюда: " + nameOfDish); }

    public Dish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
        prepare();
    }

    @Override
    public void orderDish() {
        System.out.println("Готовлю блюдо: " + nameOfDish);
    }
}

class ProxyDish implements Order {
    String nameOfDish;
    Dish dish;

    public ProxyDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    @Override
    public void orderDish() {
        if (dish == null) {
            dish = new Dish(nameOfDish);
        }
        dish.orderDish();
    }
}

final public class Proxy implements Demonstator{
    @Override
    public void demonstrate() {
        System.out.println("\n***********************\nПАТТЕРН - ПРОКСИ\n***********************\n");
        Order dish = new ProxyDish("Мясо по-французски");
        dish.orderDish();
    }
}
