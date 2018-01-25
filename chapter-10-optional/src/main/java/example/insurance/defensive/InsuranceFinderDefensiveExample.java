package example.insurance.defensive;

import example.insurance.domain.usingnull.Car;
import example.insurance.domain.usingnull.Insurance;
import example.insurance.domain.usingnull.Person;

public class InsuranceFinderDefensiveExample {
    public String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }

        return "Unknown";
    }
    public String getCarInsuranceNameMultiReturn(Person person) {
        if (person == null) {
            return "Unknown";
        }


        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }

        return insurance.getName();
    }
}
