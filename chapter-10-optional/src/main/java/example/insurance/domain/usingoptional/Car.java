package example.insurance.domain.usingoptional;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return this.insurance;
    }
}
