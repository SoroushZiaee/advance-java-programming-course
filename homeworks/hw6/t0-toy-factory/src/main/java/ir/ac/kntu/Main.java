package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(20000, ToySize.SMALL);
        System.out.println(car.getPrice());
        System.out.println(car.getPrice(20));
        System.out.println(car.getType());

        System.out.println("-------------------------------");
        Toy toy = new Toy(1000, ToySize.SMALL);
        Helicopter helicopter = new Helicopter(1000, ToySize.SMALL);
        Car car1 = new Car(1000, ToySize.SMALL);
        Toy newCar = new Car(2000, ToySize.MEDIUM);
        System.out.println(car1.getType().equals(helicopter.getType()));
        System.out.println(car1.getType().equals(new Car(2000, ToySize.SMALL).getType()));
        System.out.println(car1.getType().equals(toy.getType()));
        System.out.println(toy.getType());
        System.out.println(helicopter.getType());
        System.out.println(car1.getType().equals(newCar.getType()));

    }
}