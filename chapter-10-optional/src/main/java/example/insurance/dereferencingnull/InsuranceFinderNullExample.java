package example.insurance.dereferencingnull;

import example.insurance.domain.usingnull.Person;

public class InsuranceFinderNullExample {
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
