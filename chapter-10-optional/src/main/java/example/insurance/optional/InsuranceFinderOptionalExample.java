package example.insurance.optional;

import example.insurance.domain.usingoptional.Car;
import example.insurance.domain.usingoptional.Insurance;
import example.insurance.domain.usingoptional.Person;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class InsuranceFinderOptionalExample {
    public String getCarInsuranceName(Optional<Person> personOptional) {
        return personOptional.flatMap(Person::getCar)
                             .flatMap(Car::getInsurance)
                             .map(Insurance::getName)
                             .orElse("Unknown");
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return null;
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return empty();
        }
    }

    public void filterInsurance(Optional<Person> person, Optional<Car> car) {
        Optional<Insurance> insuranceOptional = nullSafeFindCheapestInsurance(person, car);
        insuranceOptional.filter(insurance -> "Cambridge Insurance".equalsIgnoreCase(insurance.getName()))
                         .ifPresent(x -> System.out.println("ok"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NullPointerException e) {
            return empty();
        }
    }
}
