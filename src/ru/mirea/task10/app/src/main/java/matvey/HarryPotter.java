package matvey;

import org.springframework.stereotype.Component;

@Component
public class HarryPotter implements Magican {
    HarryPotter() {}
    @Override
    public void doMagic() {
        System.out.println("It's a Harry Potter!");
    }
}
