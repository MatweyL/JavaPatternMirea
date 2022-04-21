package matvey;

import org.springframework.stereotype.Component;

@Component
public class Voldemort implements Magican {
    Voldemort() {}
    @Override
    public void doMagic() {
        System.out.println("It's a Voldemort!");
    }
}
