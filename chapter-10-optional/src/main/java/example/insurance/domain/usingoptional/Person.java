package example.insurance.domain.usingoptional;

import example.insurance.domain.usingoptional.Car;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return this.car;
    }
}